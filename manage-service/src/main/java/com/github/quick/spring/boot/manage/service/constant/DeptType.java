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

package com.github.quick.spring.boot.manage.service.constant;

import java.util.ArrayList;
import java.util.List;

public enum DeptType {
	/**
	 * 商铺审核部门
	 */
	ShopAudit(1, "商铺审核部门"),
	;


	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	DeptType(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static List<String > names (){
		List<String> res = new ArrayList<>();
		DeptType[] values = DeptType.values();
		for (DeptType value : values) {
			res.add(value.name);
		}
		return res;
	}

	private final int code;
	private final String name;

}
