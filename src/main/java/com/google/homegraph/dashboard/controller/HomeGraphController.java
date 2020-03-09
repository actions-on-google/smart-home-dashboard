/**
 * Copyright 2018 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.homegraph.dashboard.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.homegraph.v1.HomeGraphService;
import com.google.api.services.homegraph.v1.HomeGraphServiceRequestInitializer;
import com.google.api.services.homegraph.v1.model.AgentDeviceId;
import com.google.api.services.homegraph.v1.model.QueryRequest;
import com.google.api.services.homegraph.v1.model.QueryRequestInput;
import com.google.api.services.homegraph.v1.model.QueryRequestPayload;
import com.google.api.services.homegraph.v1.model.QueryResponse;
import com.google.api.services.homegraph.v1.model.SyncRequest;
import com.google.api.services.homegraph.v1.model.SyncResponse;
import com.google.homegraph.dashboard.model.Device;
import com.google.homegraph.dashboard.model.Response;
import com.google.homegraph.dashboard.service.StorageService;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value = "session")
public class HomeGraphController implements Serializable {

	private static final long serialVersionUID = -7587398671809190089L;
	private static final String HOMEGRAPH_SCOPE = "https://www.googleapis.com/auth/homegraph";

	private static Logger log = Logger.getLogger("HomeGraphController");

	private String file;

	private static Map<String, List<Device>> deviceCache = new HashMap<>();

	@GetMapping("/homegraph")
	@CrossOrigin(origins = "http://localhost:4200") // for testing && development, should be safe to remove
	public List<Device> getHomegraph(@RequestParam(value = "file") final String file,
			@RequestParam(value = "agentUserId") final String agentUserId) {
		this.file = file;

		try {
			HomeGraphService homeGraphService = createConnection();
			/*
			 * Get device list
			 */
			log.debug("Calling SYNC for " + agentUserId);
			syncHomeGraph(agentUserId, homeGraphService);
			/*
			 * Iterate devices and request states
			 */
			log.debug("Calling QUERY for " + agentUserId);
			return queryHomeGraph(agentUserId, homeGraphService).getDevices();
		} catch (IOException | GeneralSecurityException e) {
			throw new RuntimeException("Cannot connect to Home Graph service: " + e.getMessage(), e);
		}
	}

	private HomeGraphService createConnection() throws IOException, GeneralSecurityException {
		InputStream stream = StorageService.getInstance().loadFile(file);
		GoogleCredential creds = GoogleCredential.fromStream(stream)
				.createScoped(Collections.singletonList(HOMEGRAPH_SCOPE));
		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		JsonFactory jsonFactory = new JacksonFactory();
		return new HomeGraphService.Builder(httpTransport, jsonFactory, creds).build();
	}

	private List<Device> syncHomeGraph(String agentUserId, HomeGraphService homeGraphService)
			throws IOException {
		SyncRequest reqSync = new SyncRequest();
		reqSync.setRequestId(UUID.randomUUID().toString());
		reqSync.setAgentUserId(agentUserId);

		SyncResponse resSync = homeGraphService.devices().sync(reqSync).execute();

		List<com.google.api.services.homegraph.v1.model.Device> devices = resSync.getPayload().getDevices();

		List<Device> deviceList = new ArrayList<>();
		for (com.google.api.services.homegraph.v1.model.Device d: devices) {
			Device device = new Device();
			device.setId(d.getId());
			device.setType(d.getType().substring(d.getType().lastIndexOf('.') + 1));
			device.setName(d.getName().getName());
			if (d.getName().getNicknames() != null) {
				device.setNicknames(d.getName().getNicknames());
			}
			deviceList.add(device);
		}
		deviceCache.put(agentUserId, deviceList);
		return deviceList;
	}

	@GetMapping("/refresh")
	@CrossOrigin(origins = "http://localhost:4200") // for testing && development, should be safe to remove
	public Response refresh(@RequestParam(value = "agentUserId") final String agentUserId) {
		try {
			return queryHomeGraph(agentUserId, createConnection());
			// Response r = new Response();
			// return r;
		} catch (IOException | GeneralSecurityException e) {
			throw new RuntimeException("Cannot refresh devices", e);
		}
	}

	private Response queryHomeGraph(String agentUserId, HomeGraphService homeGraphService)
			throws IOException {
		Response response = new Response();

		QueryRequest reqQuery = new QueryRequest();
		reqQuery.setRequestId(UUID.randomUUID().toString());
		reqQuery.setAgentUserId(agentUserId);

		List<Device> deviceList = deviceCache.get(agentUserId);

		List<AgentDeviceId> deviceIdList = new ArrayList<>();
		for (Device device : deviceList) {
			AgentDeviceId agentDeviceId = new AgentDeviceId().setId(device.getId());
			deviceIdList.add(agentDeviceId);
		}

		QueryRequestInput queryRequestInput = new QueryRequestInput()
				.setPayload(new QueryRequestPayload()
						.setDevices(deviceIdList));
		reqQuery.setInputs(Collections.singletonList(queryRequestInput));

		response.setDebugRequest(reqQuery.toString());
		QueryResponse resQuery = homeGraphService.devices().query(reqQuery).execute();
		response.setDebugResponse(resQuery.toString());
		Map<String, Map<String, Object>> responseDevices = resQuery.getPayload().getDevices();

		StringBuilder delta = new StringBuilder();
		for (Device device : deviceList) {
			Map<String, Object> deviceStates = responseDevices.get(device.getId());
			for (Map.Entry<String, Object> state : deviceStates.entrySet()) {
				if (device.getStatesCache().containsKey(state.getKey()) &&
						!device.getStatesCache().get(state.getKey()).equals(state.getValue())) {
					// This state has changed!
					device.setUpdated(true);
					delta
							.append(state.getKey())
							.append(": ")
							.append(state.getValue().toString())
							.append(" | ");
				}
				device.getStatesCache().put(state.getKey(), state.getValue());
			}
		}
		response.setDebugDelta(delta.toString());
		response.setDevices(deviceList);
		return response;
	}
}
