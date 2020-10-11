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

package com.github.quick.spring.boot.manage.rest;


import com.github.quick.spring.boot.manage.message.api.SendMessage;
import org.apache.dubbo.config.annotation.DubboReference;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.github.quick.spring.boot.manage.*")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.github.quick.spring.boot.manage.message.api.api")
public class ManageRestApp {

	@DubboReference(version = "1")
	private SendMessage sendMessage;

	public static void main(String[] args) {

		SpringApplication.run(ManageRestApp.class, args);
	}

	@Bean
	public ApplicationRunner runner() {
		return args -> {
			sendMessage.dom();
			System.out.println();

		};
	}

}
