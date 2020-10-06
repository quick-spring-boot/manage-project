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

package com.github.quick.spring.boot.manage.service.factory.convert.impl.to.db.role;

import com.github.quick.spring.boot.manage.common.ex.ManagerCommonException;
import com.github.quick.spring.boot.manage.common.interfaces.Convert;
import com.github.quick.spring.boot.manage.dao.entity.ManagerRole;
import com.github.quick.spring.boot.manage.model.req.role.CreateRoleParam;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CreateRoleParamConvertRole implements Convert<CreateRoleParam, ManagerRole> {
	@Override
	public ManagerRole convert(CreateRoleParam param) {
		ManagerRole managerRole = new ManagerRole();

		if (StringUtils.isEmpty(param.getName())) {
			throw new ManagerCommonException("角色名称不能为空");
		}
		managerRole.setName(param.getName());
		return managerRole;
	}
}
