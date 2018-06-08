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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.homegraph.dashboard.service.StorageService;

@Controller
@Scope(value="session")
public class UploadController implements Serializable{

	private static final long serialVersionUID = 5546148932202075489L;
	private static Logger log = Logger.getLogger("UploadController");
	@Autowired
	private StorageService storageService;

	@PostMapping("/upload")
	@CrossOrigin
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") final MultipartFile file) {
		log.debug("Uploading file");
		try {
			log.debug("storing file " + file.getOriginalFilename());
			storageService.storeInMemory(file);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			String message = "Failed to upload " + file.getOriginalFilename() + "!";
			log.error(message + e.getMessage());
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

}
