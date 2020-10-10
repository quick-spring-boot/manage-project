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

import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.req.role.CreateRoleParam;
import com.github.quick.spring.boot.manage.model.req.role.QueryRoleParam;
import com.github.quick.spring.boot.manage.model.vo.ResultVo;
import com.github.quick.spring.boot.manage.rest.response.OkResponse;
import com.github.quick.spring.boot.manage.service.role.RoleService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

	private final RoleService roleService;

	public RoleController(@Qualifier("roleServiceImpl") RoleService roleService) {
		this.roleService = roleService;
	}

	@PostMapping("/")
	public ResultVo<Boolean> create(
			@RequestBody CreateRoleParam param
	) {

		return OkResponse.SAVE_SUCCESS.ret(roleService.create(param));
	}

	@PutMapping("/{role_id}")
	public ResultVo<Boolean> update(
		 @PathVariable(value = "role_id") Long roleId,
			@RequestBody CreateRoleParam param

	) {
		return OkResponse.UPDATE_SUCCESS.ret(roleService.update(roleId, param));
	}


	@GetMapping("/query")
	public ResultVo<Object> query(
			QueryRoleParam param,
			PageParam pageParam
	) {
		return OkResponse.QUERY_SUCCESS.ret(roleService.query(param,pageParam));
	}

	@GetMapping("/{role_id}")
	public ResultVo<Object> byId(
			 @PathVariable(value = "role_id") Long roleId
	) {
		return OkResponse.QUERY_SUCCESS.ret(roleService.byId(roleId));
	}
}
