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

package com.github.quick.spring.boot.manage.dao.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 角色和权限关系表
 */
@TableName(value = "middle_role_permission")
public class MiddleRolePermission implements Serializable {
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 角色id
	 */
	@TableField(value = "role_id")
	private Long roleId;

	/**
	 * 权限id
	 */
	@TableField(value = "permission_id")
	private Long permissionId;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_ROLE_ID = "role_id";

	public static final String COL_PERMISSION_ID = "permission_id";

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取角色id
	 *
	 * @return role_id - 角色id
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 设置角色id
	 *
	 * @param roleId 角色id
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取权限id
	 *
	 * @return permission_id - 权限id
	 */
	public Long getPermissionId() {
		return permissionId;
	}

	/**
	 * 设置权限id
	 *
	 * @param permissionId 权限id
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		MiddleRolePermission other = (MiddleRolePermission) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
				&& (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
		result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
		return result;
	}
}