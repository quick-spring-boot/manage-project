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

package com.github.quick.spring.boot.manage.rest.controller.user;

import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.req.user.ManagerUserCreateParam;
import com.github.quick.spring.boot.manage.model.vo.ResultVo;
import com.github.quick.spring.boot.manage.rest.response.OkResponse;
import com.github.quick.spring.boot.manage.service.user.ManagerUserBizService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 1. 创建用户
 * 2. 修改用户信息
 * 3. 查询用户
 * 4. 删除用户
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private final ManagerUserBizService managerUserBizService;

	public UserController(@Qualifier("managerUserBizServiceImpl") ManagerUserBizService managerUserBizService) {
		this.managerUserBizService = managerUserBizService;
	}

	@ApiOperation(value = "创建用户")
	@PostMapping("/")
	public ResultVo<Boolean> createUser(
			@ApiParam(value = "创建用户的参数") @RequestBody ManagerUserCreateParam userCreateParam
	) {
		return OkResponse.SAVE_SUCCESS.ret(managerUserBizService.createManagerUser(userCreateParam));
	}

	@ApiOperation(value = "修改用户信息")
	@PutMapping("/{user_id}")
	public ResultVo<Boolean> updateUser(
			@ApiParam(value = "用户id") @PathVariable(value = "user_id") Long userId,
			@ApiParam(value = "创建用户的参数") @RequestBody ManagerUserCreateParam userCreateParam

	) {
		return OkResponse.UPDATE_SUCCESS.ret(managerUserBizService.updateUser(userId, userCreateParam));
	}


	@ApiOperation(value = "查询用户列表")
	@GetMapping("/query")
	public ResultVo<Object> query(
			PageParam pageParam
	) {
		return OkResponse.QUERY_SUCCESS.ret(managerUserBizService.query(pageParam));
	}

	@ApiOperation(value = "根据ID查询用户详情")
	@GetMapping("/{user_id}")
	public ResultVo<Object> byId(
			@ApiParam(value = "用户id") @PathVariable(value = "user_id") Long userId
	) {
		return OkResponse.QUERY_SUCCESS.ret(managerUserBizService.byId(userId));
	}

}
