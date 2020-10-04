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

package com.github.quick.spring.boot.manage.service.permission.impl;

import com.github.quick.spring.boot.manage.dao.entity.ManagerApi;
import com.github.quick.spring.boot.manage.dao.mapper.ManagerApiMapper;
import com.github.quick.spring.boot.manage.model.req.permission.FullPermission;
import com.github.quick.spring.boot.manage.service.factory.convert.ParamConvert;
import com.github.quick.spring.boot.manage.service.permission.ApiPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("apiPermissionServiceImpl")
public class ApiPermissionServiceImpl implements ApiPermissionService {
	@Autowired
	@Qualifier("paramConvertImpl") ParamConvert paramConvert;

	@Autowired
	private ManagerApiMapper managerApiMapper;

	@Override
	public ManagerApi save(FullPermission fullPermission) {
		ManagerApi convert = paramConvert.convert(fullPermission, ManagerApi.class);
		int insert = managerApiMapper.insert(convert);

		if ( insert> 0) {
			return convert;
		}
		return null;
	}

}
