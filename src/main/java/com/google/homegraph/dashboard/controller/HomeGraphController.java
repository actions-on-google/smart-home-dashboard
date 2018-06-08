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

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.home.graph.v1.HomeGraphApiServiceGrpc;
import com.google.home.graph.v1.HomeGraphApiServiceGrpc.HomeGraphApiServiceBlockingStub;
import com.google.home.graph.v1.HomeGraphApiServiceProto.AgentDeviceId;
import com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest;
import com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest.Builder;
import com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequestInput;
import com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequestPayload;
import com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse;
import com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest;
import com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse;
import com.google.homegraph.dashboard.model.Device;
import com.google.homegraph.dashboard.model.Response;
import com.google.homegraph.dashboard.service.StorageService;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.auth.MoreCallCredentials;

@RestController
@Scope(value = "session")
public class HomeGraphController implements Serializable {

	private static final long serialVersionUID = -7587398671809190089L;

	private static Logger log = Logger.getLogger("HomeGraphController");

	@Autowired
	private StorageService storageService;

	public static final String HOME_GRAPH = "homegraph.googleapis.com";

	private static Map<String, List<Device>> deviceCache = new HashMap<>();
	private String file;

	@GetMapping("/homegraph")
	@CrossOrigin(origins = "http://localhost:4200") // for testing && development, should be safe to remove
	public List<Device> getHomegraph(@RequestParam(value = "file") final String file,
			@RequestParam(value = "agentUserId") final String agentUserId) {
		this.file = file;

		HomeGraphApiServiceGrpc.HomeGraphApiServiceBlockingStub blockingStub = createConnection();

		/*
		 * Get device list
		 */
		syncHomeGraph(agentUserId, blockingStub);

		/*
		 * Iterate devices and request states
		 */
		return queryHomeGraph(agentUserId, blockingStub).getDevices();

	}

	private HomeGraphApiServiceBlockingStub createConnection() {

		HomeGraphApiServiceGrpc.HomeGraphApiServiceBlockingStub blockingStub = null;
		try {
			InputStream stream = storageService.loadFile(file);
			GoogleCredentials creds = GoogleCredentials.fromStream(stream);
			ManagedChannel channel = ManagedChannelBuilder.forTarget(HOME_GRAPH).build();

			blockingStub = HomeGraphApiServiceGrpc.newBlockingStub(channel)
					// See https://grpc.io/docs/guides/auth.html#authenticate-with-google-3.
					.withCallCredentials(MoreCallCredentials.from(creds));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return blockingStub;
	}

	private List<Device> syncHomeGraph(String agentUserId,
			HomeGraphApiServiceGrpc.HomeGraphApiServiceBlockingStub blockingStub) {
		SyncRequest reqSync = SyncRequest.newBuilder().setRequestId(UUID.randomUUID().toString())
				.setAgentUserId(agentUserId).build();

		SyncResponse resSync = blockingStub.sync(reqSync);
		List<com.google.home.graph.v1.DeviceProto.Device> devices = resSync.getPayload().getDevicesList();

		List<Device> deviceList = new ArrayList<>();
		for (com.google.home.graph.v1.DeviceProto.Device d: devices) {
			Device device = new Device();
			device.setId(d.getId());
			device.setType(d.getType().substring(d.getType().lastIndexOf('.') + 1));
			device.setName(d.getName().getName());
			deviceList.add(device);
		}
		deviceCache.put(agentUserId, deviceList);
		return deviceList;
	}

	@GetMapping("/refresh")
	@CrossOrigin(origins = "http://localhost:4200") // for testing && development, should be safe to remove
	public Response refresh(@RequestParam(value = "agentUserId") final String agentUserId) {
		return queryHomeGraph(agentUserId, createConnection());
	}

	private Response queryHomeGraph(String agentUserId,
			HomeGraphApiServiceGrpc.HomeGraphApiServiceBlockingStub blockingStub) {
		Response response = new Response();
		Builder builder = QueryRequest.newBuilder().setRequestId(UUID.randomUUID().toString())
				.setAgentUserId(agentUserId);
		com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequestPayload.Builder deviceListBuilder = QueryRequestPayload
				.newBuilder();
		List<Device> deviceList = deviceCache.get(agentUserId);
		for (Device device : deviceList) {
			deviceListBuilder.addDevices(AgentDeviceId.newBuilder().setId(device.getId()).build());
		}

		QueryRequest reqQuery = builder
				.addInputs(QueryRequestInput.newBuilder().setPayload(deviceListBuilder.build()).build()).build();

		response.setDebugRequest(reqQuery.toString());
		log.debug("Calling ReportStateAndNotification with request " + reqQuery);
		QueryResponse resQuery = blockingStub.query(reqQuery);
		response.setDebugResponse(resQuery.toString());
		Map<String, Struct> responseDevices = resQuery.getPayload().getDevicesMap();

		StringBuilder delta = new StringBuilder();
		for (Device device : deviceList) {
			delta.append(flatten(responseDevices.get(device.getId()).getFieldsMap(), device, ""));

		}
		response.setDebugDelta(delta.toString());
		response.setDevices(deviceList);
		return response;
	}

	private String flatten(Map<String, Value> _states, Device device, String parent) {
		StringBuilder delta = new StringBuilder();
		device.setUpdated(false);
		for (String _key : _states.keySet()) {
			Value _value = _states.get(_key);
			switch (_value.getKindCase()) {
			case STRUCT_VALUE:
				delta.append(flatten(_value.getStructValue().getFieldsMap(), device, parent + _key + "/"));
				break;
			case STRING_VALUE:
				delta.append(setFlattenValue(device, parent, _key, _value.getStringValue()));
				break;
			case NUMBER_VALUE:
				delta.append(setFlattenValue(device, parent, _key, String.valueOf(_value.getNumberValue())));
				break;
			case BOOL_VALUE:
				delta.append(setFlattenValue(device, parent, _key, String.valueOf(_value.getBoolValue())));
				break;
			default:
				break;
			}

		}
		return delta.toString();
	}

	private String setFlattenValue(Device device, String parent, String _key, String str) {
		StringBuilder delta = new StringBuilder();
		String state = parent + _key + ": " + str;
		if (device.getStatesCache().containsKey(_key)) {
			if (!device.getStatesCache().get(_key).equals(state)) {
				device.setUpdated(true);
				delta.append(state).append(" | ");
			}
		}
		device.getStatesCache().put(_key, state);
		return delta.toString();
	}

}
