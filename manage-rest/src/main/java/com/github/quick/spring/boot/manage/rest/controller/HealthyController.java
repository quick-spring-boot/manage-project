package com.github.quick.spring.boot.manage.rest.controller;

import com.github.quick.spring.boot.manage.model.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("健康检查接口")
public class HealthyController {
	@ApiOperation(value = "ping接口")
	@GetMapping("/ping")
	public ResultVo<String> ping() {
		return new ResultVo<>(200, "健康检查", "pong");
	}
}
