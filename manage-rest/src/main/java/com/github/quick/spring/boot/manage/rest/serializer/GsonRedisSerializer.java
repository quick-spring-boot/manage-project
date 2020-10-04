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

package com.github.quick.spring.boot.manage.rest.serializer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.github.quick.spring.boot.manage.common.serializer.GsonUtils;
import com.google.gson.Gson;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class GsonRedisSerializer<T> implements RedisSerializer<T> {
	public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	private final Class<T> clazz;

	Gson gson = GsonUtils.gsonBuild();

	public GsonRedisSerializer(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public byte[] serialize(T t) throws SerializationException {
		if (t == null) {

			return new byte[0];
		}
		return gson.toJson(t).getBytes(DEFAULT_CHARSET);
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null || bytes.length <= 0) {
			return null;
		}
		String json = new String(bytes, DEFAULT_CHARSET);

		return gson.fromJson(json, clazz);
	}
}
