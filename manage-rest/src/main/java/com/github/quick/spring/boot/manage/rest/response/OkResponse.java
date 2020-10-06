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

package com.github.quick.spring.boot.manage.rest.response;

import com.github.quick.spring.boot.manage.model.vo.ResultVo;

public enum OkResponse {
	SAVE_SUCCESS(200, "保存成功"),
	UPDATE_SUCCESS(200, "更新成功"),
	QUERY_SUCCESS(200, "查询成功"),
	DELETE_SUCCESS(200, "删除成功"),
	HEALTHY_SUCCESS(200, "健康"),
	GENERATOR_TOKEN_SUCCESS(200, "token生成成功"),
	;

	private final int code;

	private final String message;

	OkResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public <T> ResultVo<T> ret(T data) {
		return new ResultVo<>(this.getCode(), this.getMessage(), data);
	}

	public <T> ResultVo<T> ret() {
		return new ResultVo<>(this.getCode(), this.getMessage(), null);
	}

}
