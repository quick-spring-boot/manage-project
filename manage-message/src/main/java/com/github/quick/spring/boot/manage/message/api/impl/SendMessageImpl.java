/*
 * Copyright 2020-present quick-spring-boot All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.quick.spring.boot.manage.message.api.impl;

import java.util.List;

import com.github.quick.spring.boot.manage.model.dto.ManagerUserDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMessageImpl {
	private static final Logger log = LoggerFactory.getLogger(SendMessageImpl.class);

	public void sendMail(String message, ManagerUserDevice managerUserDevice) {

		System.out.println("发送消息");
	}

	public void sendMail(String message, String mail) {
		System.out.println("发送消息");
	}

	public void sendMail(String message, List<String> mails) {
		System.out.println("发送消息");
	}
}
