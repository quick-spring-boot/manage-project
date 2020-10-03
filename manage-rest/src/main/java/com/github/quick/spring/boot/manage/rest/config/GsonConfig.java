package com.github.quick.spring.boot.manage.rest.config;

import java.util.ArrayList;
import java.util.Collection;

import com.github.quick.spring.boot.manage.common.seri.GsonUtils;

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
		gsonHttpMessageConverter.setGson(GsonUtils.gsonBuild());
		messageConverters.add(gsonHttpMessageConverter);
		return new HttpMessageConverters(true, messageConverters);
	}
}