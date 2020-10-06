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

import java.util.Collections;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.quick.spring.boot.manage.common.ex.ManagerCommonException;
import com.github.quick.spring.boot.manage.dao.entity.ManagerApi;
import com.github.quick.spring.boot.manage.dao.entity.ManagerButton;
import com.github.quick.spring.boot.manage.dao.entity.ManagerMenu;
import com.github.quick.spring.boot.manage.dao.entity.ManagerPermission;
import com.github.quick.spring.boot.manage.dao.mapper.ManagerPermissionMapper;
import com.github.quick.spring.boot.manage.model.enums.PermissionType;
import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.req.permission.CreatePermission;
import com.github.quick.spring.boot.manage.model.req.permission.FullPermission;
import com.github.quick.spring.boot.manage.model.res.PermissionInfoResponse;
import com.github.quick.spring.boot.manage.service.permission.ApiPermissionService;
import com.github.quick.spring.boot.manage.service.permission.ButtonPermissionService;
import com.github.quick.spring.boot.manage.service.permission.ManagerPermissionService;
import com.github.quick.spring.boot.manage.service.permission.MenuPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("managerPermissionServiceImpl")
public class ManagerPermissionServiceImpl implements ManagerPermissionService {
	@Autowired
	@Qualifier("apiPermissionServiceImpl")
	ApiPermissionService apiPermissionService;

	@Autowired
	@Qualifier("buttonPermissionServiceImpl")
	ButtonPermissionService buttonPermissionService;

	@Autowired
	@Qualifier("menuPermissionServiceImpl")
	MenuPermissionService menuPermissionService;

	@Autowired
	private ManagerPermissionMapper permissionMapper;

	@Override
	@Transactional
	public boolean save(CreatePermission createPermission) {
		int type = createPermission.getType();
		PermissionType convert = PermissionType.convert(type);

		switch (convert) {
			case API:
				return saveApi(createPermission.getfullPermission());
			case MENU:
				return saveMenu(createPermission.getfullPermission());
			case BUTTON:
				return saveButton(createPermission.getfullPermission());
			default:
				throw new ManagerCommonException("不存在的权限操作");
		}

	}

	private boolean saveButton(FullPermission fullPermission) {
		ManagerButton save = this.buttonPermissionService.save(fullPermission);
		if (save != null) {

			ManagerPermission managerPermission = new ManagerPermission();
			managerPermission.setRefId(save.getId());
			managerPermission.setType((byte) PermissionType.BUTTON.getCode());
			managerPermission.setRefTable(PermissionType.BUTTON.getTableName());
			return this.permissionMapper.insert(managerPermission) > 0;
		}
		return false;
	}

	private boolean saveMenu(FullPermission fullPermission) {
		ManagerMenu save = this.menuPermissionService.save(fullPermission);
		if (save != null) {
			ManagerPermission managerPermission = new ManagerPermission();
			managerPermission.setRefId(save.getId());
			managerPermission.setType((byte) PermissionType.MENU.getCode());
			managerPermission.setRefTable(PermissionType.MENU.getTableName());
			return this.permissionMapper.insert(managerPermission) > 0;
		}
		return false;
	}

	private boolean saveApi(FullPermission fullPermission) {

		ManagerApi save = this.apiPermissionService.save(fullPermission);
		if (save != null) {
			ManagerPermission managerPermission = new ManagerPermission();
			managerPermission.setRefId(save.getId());
			managerPermission.setType((byte) PermissionType.API.getCode());
			managerPermission.setRefTable(PermissionType.API.getTableName());
			return this.permissionMapper.insert(managerPermission) > 0;
		}
		return false;
	}


	@Override
	public boolean delete(Long permissionId) {
		return this.permissionMapper.deleteById(permissionId) > 0;
	}

	@Override
	public Object list(int permissionType, PageParam pageParam) {

		PermissionType convert = PermissionType.convert(permissionType);

		if (convert == PermissionType.BUTTON) {

			PageHelper.startPage(pageParam.getPageCount(), pageParam.getPageSize());
			List<PermissionInfoResponse> byButton = this.permissionMapper.findByButton(convert.getTableName());
			PageInfo pageInfo = new PageInfo<>(byButton);


			return pageInfo;
		}
		else if (convert == PermissionType.MENU) {
			PageHelper.startPage(pageParam.getPageCount(), pageParam.getPageSize());
			List<PermissionInfoResponse> byMenu = this.permissionMapper.findByMenu(convert.getTableName());
			PageInfo pageInfo = new PageInfo<>(byMenu);
			return pageInfo;
		}
		else if (convert == PermissionType.API) {
			PageHelper.startPage(pageParam.getPageCount(), pageParam.getPageSize());
			List<PermissionInfoResponse> byApi = this.permissionMapper.findByApi(convert.getTableName());
			PageInfo pageInfo = new PageInfo<>(byApi);
			return pageInfo;
		}


		return Collections.emptyList();
	}
}
