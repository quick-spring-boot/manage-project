package com.github.quick.spring.boot.manage.rest;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.quick.spring.boot.manage.*")
@EnableOpenApi
public class ManageRestApp {


	public static void main(String[] args) {
		SpringApplication.run(ManageRestApp.class, args);

	}
}
