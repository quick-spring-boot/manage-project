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

package com.github.quick.spring.boot.manage.service.user;

import com.github.quick.spring.boot.manage.dao.entity.ManagerUser;
import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.req.user.ManagerUserCreateParam;
import com.github.quick.spring.boot.manage.model.res.ManagerUserResponse;
import com.github.quick.spring.boot.manage.model.res.TokenCollection;

/**
 * 管理端用户业务
 */
public interface ManagerUserBizService {
	/**
	 * 创建管理端用户
	 * @param param 参数
	 * @return true: 创建成功, false: 创建失败
	 */
	boolean createManagerUser(ManagerUserCreateParam param);

	boolean updateUser(Long userId, ManagerUserCreateParam userCreateParam);

	Object query(PageParam pageParam);

	ManagerUserResponse byId(Long userId);

	TokenCollection generatorToken(long userId);

	/**
	 * 刷新token
	 * @param refreshToken
	 * @return
	 */
	TokenCollection refreshToken(String refreshToken);


	ManagerUserResponse findUserByToken(String accessToken);

	Boolean bindDepartment(Long userId, Long deptId);

	Boolean unBindDepartment(Long userId, Long deptId);
}
