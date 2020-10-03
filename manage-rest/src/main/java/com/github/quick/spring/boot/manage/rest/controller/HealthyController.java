package com.github.quick.spring.boot.manage.rest.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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


	@GetMapping("/demo")
	public ResultVo<Map> demo() {
		Map<String, Object> map = new HashMap<>();
		map.put("1", 1);
		map.put("2", null);
		map.put("3", LocalDateTime.now());
		map.put("4", LocalDate.now());

		return new ResultVo<>(200, "test", map);
	}
}
