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
import com.github.quick.spring.boot.manage.model.res.ManagerUserResponse;
import com.github.quick.spring.boot.manage.model.res.TokenCollection;
import com.github.quick.spring.boot.manage.model.vo.ResultVo;
import com.github.quick.spring.boot.manage.rest.response.OkResponse;
import com.github.quick.spring.boot.manage.service.user.ManagerUserBizService;

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

	/**
	 * 创建用户
	 * @param userCreateParam 创建用户参数
	 * @return true: 成功, false: 失败
	 */
	@PostMapping("/")
	public ResultVo<Boolean> createUser(
			@RequestBody ManagerUserCreateParam userCreateParam
	) {
		return OkResponse.SAVE_SUCCESS.ret(managerUserBizService.createManagerUser(userCreateParam));
	}

	@PutMapping("/{user_id}")
	public ResultVo<Boolean> updateUser(
			@PathVariable(value = "user_id") Long userId,
			@RequestBody ManagerUserCreateParam userCreateParam

	) {
		return OkResponse.UPDATE_SUCCESS.ret(managerUserBizService.updateUser(userId, userCreateParam));
	}


	@GetMapping("/query")
	public ResultVo<Object> query(
			PageParam pageParam
	) {
		return OkResponse.QUERY_SUCCESS.ret(managerUserBizService.query(pageParam));
	}

	@GetMapping("/{user_id}")
	public ResultVo<Object> byId(
			@PathVariable(value = "user_id") Long userId
	) {
		return OkResponse.QUERY_SUCCESS.ret(managerUserBizService.byId(userId));
	}


	@PostMapping("/token/{user_id}")
	public ResultVo<TokenCollection> generatorToken(
			@PathVariable(value = "user_id") Long userId
	) {
		return OkResponse.GENERATOR_TOKEN_SUCCESS.ret(managerUserBizService.generatorToken(userId));
	}


	@PutMapping("/token/refresh/{refresh_token}")
	public ResultVo<TokenCollection> generatorToken(
			@PathVariable(value = "refresh_token") String refreshToken
	) {
		return OkResponse.GENERATOR_TOKEN_SUCCESS.ret(managerUserBizService.refreshToken(refreshToken));
	}


	@GetMapping("/token/{access_token}")
	public ResultVo<ManagerUserResponse> findUserByToken(
			@PathVariable(value = "access_token") String accessToken
	) {
		return OkResponse.QUERY_SUCCESS.ret(managerUserBizService.findUserByToken(accessToken));
	}
}
