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

package com.github.quick.spring.boot.manage.model.enums;

public enum AuditStatus {

	ToBeReviewed(1,"待审核"),
	AuditSuccessful(1,"审核成功"),
	AuditFailure(1,"审核失败"),
	;

	private int code;

	private String name;

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	AuditStatus(int code, String name) {
		this.code = code;
		this.name = name;
	}
}
