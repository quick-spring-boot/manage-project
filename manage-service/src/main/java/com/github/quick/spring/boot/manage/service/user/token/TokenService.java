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

package com.github.quick.spring.boot.manage.service.user.token;

import com.github.quick.spring.boot.manage.model.res.TokenCollection;

public interface TokenService {
	/**
	 * 生成 refresh_token
	 * @param userId 用户id
	 * @return refresh_token
	 */
	String generatorRefreshToken(long userId);

	/**
	 * 生成 access_token
	 * @param userId 用户id
	 * @return access_token
	 */
	String generatorAccessToken(long userId);


	TokenCollection generatorToken(long userId);

	TokenCollection refreshToken(String refreshToken);

	boolean expire(String token);

	String getUserId(String token);

}
