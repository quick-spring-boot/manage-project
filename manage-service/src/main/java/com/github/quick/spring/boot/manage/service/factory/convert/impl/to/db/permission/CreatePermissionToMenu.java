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
import com.github.quick.spring.boot.manage.common.interfaces.Convert;
import com.github.quick.spring.boot.manage.dao.entity.ManagerMenu;
import com.github.quick.spring.boot.manage.model.req.permission.FullPermission;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("createPermissionToMenu")
public class CreatePermissionToMenu extends FullPermissionCheck implements Convert<FullPermission, ManagerMenu> {
	@Override
	public ManagerMenu convert(FullPermission fullPermission) {
		checkPermissionCodeAndName(fullPermission.getCode(), fullPermission.getName());

		String path = fullPermission.getPath();
		if (StringUtils.isEmpty(path)) {
			throw new ManagerCommonException("菜单地址不能为空");
		}

		ManagerMenu managerMenu = new ManagerMenu();
		managerMenu.setCode(fullPermission.getCode());
		managerMenu.setName(fullPermission.getName());
		managerMenu.setPath(path);
		managerMenu.setPid(fullPermission.getPid());

		return managerMenu;
	}
}
