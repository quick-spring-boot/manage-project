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

package com.github.quick.spring.boot.manage.service.role;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.quick.spring.boot.manage.common.ex.ManagerCommonException;
import com.github.quick.spring.boot.manage.dao.entity.ManagerRole;
import com.github.quick.spring.boot.manage.dao.mapper.ManagerRoleMapper;
import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.req.role.CreateRoleParam;
import com.github.quick.spring.boot.manage.model.req.role.QueryRoleParam;
import com.github.quick.spring.boot.manage.model.res.ManagerRoleResponse;
import com.github.quick.spring.boot.manage.service.factory.convert.ParamConvert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	@Autowired
	@Qualifier("paramConvertImpl")
	private ParamConvert paramConvert;

	@Autowired
	private ManagerRoleMapper roleMapper;

	@Override
	public boolean create(CreateRoleParam param) {
		ManagerRole convert = paramConvert.convert(param, ManagerRole.class);
		ManagerRole db = roleMapper.findByName(param.getName());
		if (db == null) {
			return roleMapper.insert(convert) > 0;
		}
		return false;
	}

	@Override
	public boolean update(Long roleId, CreateRoleParam param) {


		ManagerRole managerRole = roleMapper.selectById(roleId);
		if (managerRole != null) {
			ManagerRole db = roleMapper.findByName(param.getName());
			if (db == null) {
				ManagerRole convert = paramConvert.convert(param, ManagerRole.class);
				convert.setId(roleId);
				return roleMapper.updateById(convert) > 0;
			}
			else {
				throw new ManagerCommonException("当前角色名称已存在");
			}

		}

		return false;
	}

	@Override
	public Object query(QueryRoleParam param, PageParam pageParam) {
		Page<ManagerRole> roleIPage = new Page<>(pageParam.getPageCount(), pageParam.getPageSize());

		IPage roles = this.roleMapper.query(roleIPage, param);
		List<ManagerRoleResponse> res = new ArrayList<>();

		for (Object record : roles.getRecords()) {
			ManagerRoleResponse convert = this.paramConvert.convert(record, ManagerRoleResponse.class);
			res.add(convert);
		}
		roles.setRecords(res);
		return roles;
	}

	@Override
	public Object byId(Long roleId) {
		return this.roleMapper.selectById(roleId);
	}
}
