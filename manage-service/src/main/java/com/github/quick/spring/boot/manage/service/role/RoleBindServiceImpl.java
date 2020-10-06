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

import com.github.quick.spring.boot.manage.dao.entity.MiddleRoleDepartment;
import com.github.quick.spring.boot.manage.dao.entity.MiddleRolePermission;
import com.github.quick.spring.boot.manage.dao.mapper.MiddleRoleDepartmentMapper;
import com.github.quick.spring.boot.manage.dao.mapper.MiddleRolePermissionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleBindServiceImpl implements RoleBindService {

	@Autowired
	private MiddleRoleDepartmentMapper middleRoleDepartmentMapper;

	@Autowired
	private MiddleRolePermissionMapper middleRolePermissionMapper;

	private MiddleRoleDepartment findByRoleAndDeptId(Long roleId, Long deptId) {

		return this.middleRoleDepartmentMapper.findByRoleAndDeptId(roleId, deptId);

	}

	@Override
	public Boolean bindDepartment(Long roleId, Long deptId) {
		MiddleRoleDepartment byRoleAndDeptId = findByRoleAndDeptId(roleId, deptId);
		if (byRoleAndDeptId == null) {
			MiddleRoleDepartment middleRoleDepartment = new MiddleRoleDepartment();

			middleRoleDepartment.setDepartmentId(deptId);
			middleRoleDepartment.setRoleId(roleId);

			return middleRoleDepartmentMapper.insert(middleRoleDepartment) > 0;
		}
		return false;
	}

	@Override
	public Boolean unBindDepartment(Long roleId, Long deptId) {
		MiddleRoleDepartment byRoleAndDeptId = findByRoleAndDeptId(roleId, deptId);
		if (byRoleAndDeptId != null) {
			return this.middleRoleDepartmentMapper.deleteById(byRoleAndDeptId.getId()) > 0;
		}
		return false;
	}

	private MiddleRolePermission findByRoleAndPermissionId(Long roleId, Long permissionId) {
		return middleRolePermissionMapper.findByRoleAndPermissionId(roleId, permissionId);
	}

	@Override
	public Boolean bindPermission(Long roleId, Long permissionId) {
		MiddleRolePermission byRoleAndPermissionId = findByRoleAndPermissionId(roleId, permissionId);
		if (byRoleAndPermissionId == null) {
			MiddleRolePermission middleRolePermission = new MiddleRolePermission();
			middleRolePermission.setPermissionId(permissionId);
			middleRolePermission.setRoleId(roleId);
			return middleRolePermissionMapper.insert(middleRolePermission) > 0;
		}
		return false;
	}

	@Override
	public Boolean unBindPermission(Long roleId, Long permissionId) {
		MiddleRolePermission byRoleAndPermissionId = findByRoleAndPermissionId(roleId, permissionId);
		if (byRoleAndPermissionId != null) {
			return this.middleRolePermissionMapper.deleteById(byRoleAndPermissionId.getId()) > 0;
		}

		return false;
	}

}
