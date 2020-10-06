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

package com.github.quick.spring.boot.manage.rest.controller.role.permission;

import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.req.permission.CreatePermission;
import com.github.quick.spring.boot.manage.model.vo.ResultVo;
import com.github.quick.spring.boot.manage.rest.response.OkResponse;
import com.github.quick.spring.boot.manage.service.permission.ManagerPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	@Qualifier("managerPermissionServiceImpl")
	private ManagerPermissionService managerPermissionService;

	@PostMapping("/")
	public ResultVo<Boolean> create(
			@RequestBody CreatePermission createPermission
	) {
		return OkResponse.SAVE_SUCCESS.ret(managerPermissionService.save(createPermission));
	}

	@DeleteMapping("/{permission_id}")
	public ResultVo<Boolean> delete(
			@PathVariable("permission_id") Long permissionId
	) {
		return OkResponse.DELETE_SUCCESS.ret(this.managerPermissionService.delete(permissionId));
	}

	@GetMapping("/list/{permission_type}")
	public ResultVo<Object> list(
			@PathVariable("permission_type") int permissionType,
			PageParam pageParam
	) {
		return OkResponse.QUERY_SUCCESS.ret(this.managerPermissionService.list(permissionType, pageParam));
	}
}
