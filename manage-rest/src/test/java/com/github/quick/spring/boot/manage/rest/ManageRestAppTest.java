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

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.quick.spring.boot.manage.dao.entity.ManagerApi;
import com.github.quick.spring.boot.manage.dao.mapper.ManagerApiMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ManageRestAppTest {


	@Autowired
	private RedisTemplate redisTemplate;


	@Autowired
	private ManagerApiMapper managerApiMapper;


	@Test
	public void testMapper() {
//		ManagerApi api = new ManagerApi();
//		api.setCode("test");
//		managerApiMapper.insert(api);
		managerApiMapper.deleteById(9);
		System.out.println();
	}


	@Test
	public void rd() {
		Map<String, Object> data = new HashMap<>();
		data.put("1", null);
		data.put("2", LocalDate.now());
		redisTemplate.opsForValue().set("a", data);
	}

}