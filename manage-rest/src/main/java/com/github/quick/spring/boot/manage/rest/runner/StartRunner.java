package com.github.quick.spring.boot.manage.rest.runner;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class StartRunner implements CommandLineRunner, Ordered {
	private static final Logger log = LoggerFactory.getLogger(StartRunner.class);
	@Autowired
	private WebApplicationContext context;

	@Override
	public void run(String... args) throws Exception {
		if (log.isInfoEnabled()) {
			log.info("管理端api项目启动成功");
		}

		RequestMappingHandlerMapping mapping = context
				.getBean(RequestMappingHandlerMapping.class);
		Map<RequestMappingInfo, HandlerMethod> map = mapping
				.getHandlerMethods();
		System.out.println();
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}
}
