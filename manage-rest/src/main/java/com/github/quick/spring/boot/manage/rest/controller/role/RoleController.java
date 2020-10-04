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

package com.github.quick.spring.boot.manage.rest.controller.role;

import com.github.quick.spring.boot.manage.model.vo.ResultVo;
import com.github.quick.spring.boot.manage.rest.response.OkResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("角色相关接口")
@RestController
@RequestMapping("/role")
public class RoleController {



	@ApiOperation(value = "创建角色")
	@PostMapping("/")
	public ResultVo<Boolean> createUser(

	) {
		return OkResponse.SAVE_SUCCESS.ret();
	}

	@ApiOperation(value = "修改角色信息")
	@PutMapping("/{role_id}")
	public ResultVo<Boolean> updateUser(
			@ApiParam(value = "角色id") @PathVariable(value = "role_id") Long roleId

	) {
		return OkResponse.UPDATE_SUCCESS.ret();
	}


	@ApiOperation(value = "查询角色列表")
	@GetMapping("/query")
	public ResultVo<Object> query(

	) {
		return OkResponse.QUERY_SUCCESS.ret();
	}

	@ApiOperation(value = "根据ID查询角色详情")
	@GetMapping("/{role_id}")
	public ResultVo<Object> byId(
			@ApiParam(value = "角色id") @PathVariable(value = "role_id") Long roleId
	) {

		return OkResponse.UPDATE_SUCCESS.ret();
	}
}
