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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色和部门关系表
 */
@ApiModel(value = "com-github-quick-spring-boot-manage-dao-entity-MiddleRoleDepartment")
@TableName(value = "middle_role_department")
public class MiddleRoleDepartment implements Serializable {
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "")
	private Long id;

	/**
	 * 角色id
	 */
	@TableField(value = "role_id")
	@ApiModelProperty(value = "角色id")
	private Long roleId;

	/**
	 * 部门id
	 */
	@TableField(value = "department_id")
	@ApiModelProperty(value = "部门id")
	private Long departmentId;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_ROLE_ID = "role_id";

	public static final String COL_DEPARTMENT_ID = "department_id";

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
	 * 获取部门id
	 *
	 * @return department_id - 部门id
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * 设置部门id
	 *
	 * @param departmentId 部门id
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
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
		MiddleRoleDepartment other = (MiddleRoleDepartment) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
				&& (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
		result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
		return result;
	}
}