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

package com.github.quick.spring.boot.manage.service.factory.convert.impl.to.db.permission;

import com.github.quick.spring.boot.manage.common.ex.ManagerCommonException;

import org.springframework.util.StringUtils;

public class FullPermissionCheck {
	protected void checkPermissionCodeAndName(String code, String name) {

		if (StringUtils.isEmpty(code)) {
			throw new ManagerCommonException("权限编码不能为空");
		}
		if (StringUtils.isEmpty(name)) {
			throw new ManagerCommonException("权限名称不能为空");
		}
	}
}