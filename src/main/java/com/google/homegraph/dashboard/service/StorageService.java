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
package com.google.homegraph.dashboard.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Scope(value="session")
public class StorageService implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger("StorageService");

	private Map<String, byte[]> inMemoryStore = new HashMap<>();

	public void storeInMemory(MultipartFile file) {
		try {
			inMemoryStore.put(file.getOriginalFilename(), convert(file));
		} catch (IOException e) {
			log.error(e.getMessage() + ", Failed to convert the file and store in memory, will try disk instead");
		}
	}

	public InputStream loadFile(String filename) {
		// check if it is in memory
		log.debug("Storing file: " + filename);
		if (inMemoryStore.containsKey(filename)) {
			log.debug("Found file in memory");
			return new ByteArrayInputStream(inMemoryStore.get(filename));

		} else {
			log.debug("File is not in memory..");

			return null;
		}
	}

	private byte[] convert(MultipartFile file) throws IOException {
		InputStream is = file.getInputStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[16384];
		while ((nRead = is.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}

		buffer.flush();
		return buffer.toByteArray();
	}
}
