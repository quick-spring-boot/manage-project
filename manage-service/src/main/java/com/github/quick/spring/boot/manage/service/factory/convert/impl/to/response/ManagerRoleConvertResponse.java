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

package com.github.quick.spring.boot.manage.service.factory.convert.impl.to.response;

import com.github.quick.spring.boot.manage.common.interfaces.Convert;
import com.github.quick.spring.boot.manage.dao.entity.ManagerRole;
import com.github.quick.spring.boot.manage.model.res.ManagerRoleResponse;

import org.springframework.stereotype.Service;

@Service
public class ManagerRoleConvertResponse implements Convert<ManagerRole, ManagerRoleResponse> {
	@Override
	public ManagerRoleResponse convert(ManagerRole managerRole) {
		ManagerRoleResponse managerRoleResponse = new ManagerRoleResponse();
		managerRoleResponse.setName(managerRole.getName());
		return managerRoleResponse;
	}
}
