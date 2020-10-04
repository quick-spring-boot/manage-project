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


public enum PermissionType {
	BUTTON(2, "manager_button"), MENU(1, "manager_menu"), API(3, "manager_api"),
	;

	public String getTableName() {
		return tableName;
	}

	private final int code;

	private final String tableName;

	PermissionType(int code, String tableName) {
		this.code = code;
		this.tableName = tableName;
	}

	public static PermissionType convert(int i) {
		for (PermissionType value : PermissionType.values()) {
			if (value.code == i) {
				return value;
			}
		}
		throw new IllegalArgumentException("输入值没有对应的权限类型");
	}

	public int getCode() {
		return code;
	}
}
