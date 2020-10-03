package com.github.quick.spring.boot.manage.common.seri;

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
