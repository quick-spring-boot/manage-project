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

package com.github.quick.spring.boot.manage.common.serializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.github.quick.spring.boot.manage.common.DateConstant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

public class GsonUtils {
	private GsonUtils() {
	}

	public static Gson gsonBuild() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat(DateConstant.LONG_DATE_FORMAT);
		gsonBuilder.serializeNulls();
		gsonBuilder.registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) ->
				new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
		gsonBuilder.registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>) (src, typeOfSrc, context) ->
				new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));


		gsonBuilder.registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> {
			String datetime = json.getAsJsonPrimitive().getAsString();
			return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		});
		gsonBuilder.registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> {
			String datetime = json.getAsJsonPrimitive().getAsString();
			return LocalDate.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}).create();


		return gsonBuilder.create();
	}
}
