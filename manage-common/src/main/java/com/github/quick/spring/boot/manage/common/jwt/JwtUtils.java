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

package com.github.quick.spring.boot.manage.common.jwt;

import java.time.LocalDateTime;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.quick.spring.boot.manage.common.DateUtils;

public class JwtUtils {
	public static final String SIGN = "ABCab123";

	private JwtUtils() {
	}

	/***
	 * 生成一个token
	 * @param userId 用户id
	 * @param minutes 过期时间, 单位分钟
	 * @return token
	 */
	public static String createToken(long userId, long minutes) {
		String userStr = String.valueOf(userId);
		LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(minutes);
		Date expireAt = DateUtils.LocalDateTimeToDate(localDateTime);

		return JWT.create().withExpiresAt(expireAt).withAudience(userStr)
				.sign(Algorithm.HMAC256(SIGN));
	}

	public static boolean expire(String token) {
		Date expire = getExpire(token);
		if (expire == null) {
			return false;
		}
		return expire.compareTo(new Date()) < 0;
	}

	public static Date getExpire(String token) {
		try {
			JWTVerifier build = JWT.require(Algorithm.HMAC256(SIGN)).build();
			DecodedJWT verify = build.verify(token);
			return verify.getExpiresAt();
		}
		catch (TokenExpiredException e) {
			return null;
		}
	}


	/***
	 * 解析token中的信息
	 * @param token token
	 * @return 用户id
	 */
	public static String decodeToken(String token) {
		return JWT.decode(token).getAudience().get(0);
	}

}
