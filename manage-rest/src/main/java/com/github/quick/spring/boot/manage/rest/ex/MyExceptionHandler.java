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

package com.github.quick.spring.boot.manage.rest.ex;

import javax.servlet.http.HttpServletRequest;

import com.github.quick.spring.boot.manage.model.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultVo<String> exceptionHandler(HttpServletRequest req, Exception e) {
		if (log.isErrorEnabled()) {
			log.error("异常", e);
		}
		return new ResultVo<>(500, "异常", e.getMessage());
	}
}
