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

package com.github.quick.spring.boot.manage.rest.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.github.quick.spring.boot.manage.model.vo.ResultVo;
import com.github.quick.spring.boot.manage.rest.response.OkResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("健康检查接口")
public class HealthyController {
	@ApiOperation(value = "ping接口")
	@GetMapping("/ping")
	public ResultVo<String> ping() {
		return OkResponse.HEALTHY_SUCCESS.ret("pong");
	}


	@GetMapping("/demo")
	public ResultVo<Map<String, Object>> demo() {
		Map<String, Object> map = new HashMap<>();
		map.put("1", 1);
		map.put("2", null);
		map.put("3", LocalDateTime.now());
		map.put("4", LocalDate.now());

		return new ResultVo<>(200, "test", map);
	}

}
