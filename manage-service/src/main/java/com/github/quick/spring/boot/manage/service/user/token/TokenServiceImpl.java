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

import java.util.Date;

import com.github.quick.spring.boot.manage.common.ex.ManagerCommonException;
import com.github.quick.spring.boot.manage.common.jwt.JwtUtils;
import com.github.quick.spring.boot.manage.model.res.TokenCollection;
import com.github.quick.spring.boot.manage.service.constant.RedisKey;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("tokenServiceImpl")
public class TokenServiceImpl implements TokenService {

	private final long expireMinutesForRefreshToken = 1;

	private final long expireMinutesForAccessToken = 1;

	private final StringRedisTemplate redisTemplate;


	public TokenServiceImpl(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public String generatorRefreshToken(long userId) {
		return JwtUtils.createToken(userId, expireMinutesForRefreshToken);
	}

	@Override
	public String generatorAccessToken(long userId) {
		return JwtUtils.createToken(userId, expireMinutesForAccessToken);
	}

	@Override
	public TokenCollection generatorToken(long userId) {
		String refreshToken = generatorRefreshToken(userId);
		String accessToken = generatorAccessToken(userId);

		Date refreshTokenExpireDate = JwtUtils.getExpire(refreshToken);
		Date accessTokenExpireDate = JwtUtils.getExpire(accessToken);


		// 保存 token
		redisTemplate.opsForValue().set(RedisKey.USER_TOKEN_REFRESH + userId, refreshToken);
		redisTemplate.expireAt(RedisKey.USER_TOKEN_REFRESH + userId, refreshTokenExpireDate);
		redisTemplate.opsForValue().set(RedisKey.USER_TOKEN_ACCESS + userId, accessToken);
		redisTemplate.expireAt(RedisKey.USER_TOKEN_ACCESS + userId, accessTokenExpireDate);

		return new TokenCollection(refreshToken, accessToken);

	}

	@Override
	public TokenCollection refreshToken(String refreshToken) {
		if (JwtUtils.expire(refreshToken)) {
			throw new ManagerCommonException("当前 refresh token 已过期");
		}

		String userId = JwtUtils.decodeToken(refreshToken);

		if (StringUtils.isEmpty(userId)) {
			throw new ManagerCommonException("当前 refresh token 中用户信息不存在");
		}
		return generatorToken(Long.parseLong(userId));

	}

	@Override
	public boolean expire(String token) {
		return JwtUtils.expire(token);
	}

	@Override
	public String getUserId(String token) {
		return JwtUtils.decodeToken(token);
	}
}
