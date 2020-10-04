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

package com.github.quick.spring.boot.manage.service.factory.convert.impl.to.db;

import com.github.quick.spring.boot.manage.common.interfaces.Convert;
import com.github.quick.spring.boot.manage.dao.entity.ManagerUser;
import com.github.quick.spring.boot.manage.model.req.user.ManagerUserCreateParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service("managerUserCreateParamConvert")
public class ManagerUserCreateParamConvert implements Convert<ManagerUserCreateParam, ManagerUser> {
	private static final Logger log = LoggerFactory.getLogger(ManagerUserCreateParamConvert.class);

	@Override
	public ManagerUser convert(ManagerUserCreateParam managerUserCreateParam) {

		if (log.isInfoEnabled()) {
		    log.info("convert,managerUserCreateParam = {}", managerUserCreateParam);
		}
		ManagerUser managerUser = new ManagerUser();
		managerUser.setUsername(managerUserCreateParam.getUsername());
		managerUser.setPassword(managerUserCreateParam.getPassword());
		return managerUser;
	}
}
