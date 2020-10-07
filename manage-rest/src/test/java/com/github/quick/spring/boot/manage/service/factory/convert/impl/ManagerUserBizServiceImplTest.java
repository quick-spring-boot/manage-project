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

package com.github.quick.spring.boot.manage.service.factory.convert.impl;

import java.util.List;

import com.github.quick.spring.boot.manage.dao.entity.ManagerUser;
import com.github.quick.spring.boot.manage.rest.ManageRestApp;
import com.github.quick.spring.boot.manage.service.user.ManagerUserBizService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ManageRestApp.class})
class ManagerUserBizServiceImplTest {

	@Autowired
	@Qualifier("managerUserBizServiceImpl")
	private ManagerUserBizService managerUserBizService;


	@Test
	void findShopAudit() {
		List<ManagerUser> shopAudit = managerUserBizService.findShopAudit();
		System.out.println();
	}
}