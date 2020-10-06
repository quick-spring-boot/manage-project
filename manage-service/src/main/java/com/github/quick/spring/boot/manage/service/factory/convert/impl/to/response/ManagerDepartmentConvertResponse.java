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
import com.github.quick.spring.boot.manage.dao.entity.ManagerDepartment;
import com.github.quick.spring.boot.manage.model.res.ManagerDeptResponse;

import org.springframework.stereotype.Service;

@Service
public class ManagerDepartmentConvertResponse implements Convert<ManagerDepartment, ManagerDeptResponse> {
	@Override
	public ManagerDeptResponse convert(ManagerDepartment managerDepartment) {
		ManagerDeptResponse managerDeptResponse = new ManagerDeptResponse();
		managerDeptResponse.setName(managerDepartment.getName());
		managerDeptResponse.setPid(managerDepartment.getPid());
		return managerDeptResponse;
	}
}
