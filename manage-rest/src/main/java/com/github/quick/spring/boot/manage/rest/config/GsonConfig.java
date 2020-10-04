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

package com.github.quick.spring.boot.manage.rest.config;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.github.quick.spring.boot.manage.common.serializer.GsonUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import springfox.documentation.spring.web.json.Json;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Configuration
public class GsonConfig {
	@Bean
	public HttpMessageConverters customConverters() {

		Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
		GsonBuilder gsonBuilder = GsonUtils.gsonBuildBuild();
		gsonBuilder.registerTypeAdapter(Json.class, new SpringfoxJsonToGsonAdapter());

		gsonHttpMessageConverter.setGson(gsonBuilder.create());
		messageConverters.add(gsonHttpMessageConverter);
		return new HttpMessageConverters(true, messageConverters);
	}

	/**
	 * 针对 swagger 问题的处理.
	 * Unable to render this definition The provided definition does not specify a valid version field.
	 * Please indicate a valid Swagger or OpenAPI version field. Supported version fields are swagger: “2.0” and those that match openapi: 3.0.n (for example, openapi: 3.0.0).
	 *
	 * <a href="https://blog.csdn.net/deaidai/article/details/105896545}">参考</a>
	 */
	private static class SpringfoxJsonToGsonAdapter implements JsonSerializer<Json> {
		@Override
		public JsonElement serialize(Json json, Type type, JsonSerializationContext context) {
			final JsonParser parser = new JsonParser();
			return parser.parse(json.value());
		}
	}

}