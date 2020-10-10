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

package com.github.quick.spring.boot.manage.rest.controller.role.bind;

import com.github.quick.spring.boot.manage.model.vo.ResultVo;
import com.github.quick.spring.boot.manage.rest.response.OkResponse;
import com.github.quick.spring.boot.manage.service.role.RoleBindService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role/bind")
public class RoleBindController {


	@Autowired
	private RoleBindService roleBindService;

	@PostMapping("/department/{role_id}/{dept_id}")
	public ResultVo<Boolean> bindDepartment(
			@PathVariable(value = "role_id") Long roleId,
			@PathVariable(value = "dept_id") Long deptId
	) {
		return OkResponse.SAVE_SUCCESS.ret(roleBindService.bindDepartment(roleId, deptId));
	}

	@DeleteMapping("un/department/{role_id}/{dept_id}")
	public ResultVo<Boolean> unBindDepartment(
			@PathVariable(value = "role_id") Long roleId,
			@PathVariable(value = "dept_id") Long deptId
	) {
		return OkResponse.SAVE_SUCCESS.ret(roleBindService.unBindDepartment(roleId, deptId));
	}


	@PostMapping("/permission/{role_id}/{permission_id}")
	public ResultVo<Boolean> bindPermission(
			@PathVariable(value = "role_id") Long roleId,
			@PathVariable(value = "permission_id") Long permissionId
	) {
		return OkResponse.SAVE_SUCCESS.ret(roleBindService.bindPermission(roleId, permissionId));
	}

	@DeleteMapping("un/department/{role_id}/{permission_id}")
	public ResultVo<Boolean> unBindPermission(
			 @PathVariable(value = "role_id") Long roleId,
			 @PathVariable(value = "permission_id") Long permissionId
	) {
		return OkResponse.SAVE_SUCCESS.ret(roleBindService.unBindPermission(roleId, permissionId));
	}
}
