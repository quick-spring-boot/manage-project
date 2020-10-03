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
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com-github-quick-spring-boot-manage-dao-entity-ManagerMenu")
@TableName(value = "manager_menu")
public class ManagerMenu implements Serializable {
	@TableId(value = "id", type = IdType.INPUT)
	@ApiModelProperty(value = "")
	private Long id;

	/**
	 * 父id
	 */
	@TableField(value = "pid")
	@ApiModelProperty(value = "父id")
	private Long pid;

	/**
	 * 菜单地址
	 */
	@TableField(value = "`path`")
	@ApiModelProperty(value = "菜单地址")
	private String path;

	/**
	 * 菜单名称
	 */
	@TableField(value = "`name`")
	@ApiModelProperty(value = "菜单名称")
	private String name;

	/**
	 * 0无效，1有效
	 */
	@TableField(value = "`status`")
	@ApiModelProperty(value = "0无效，1有效")
	private Byte status;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * 创建人
	 */
	@TableField(value = "create_user")
	@ApiModelProperty(value = "创建人")
	private Long createUser;

	/**
	 * 更新时间
	 */
	@TableField(value = "update_time")
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;

	/**
	 * 更新人
	 */
	@TableField(value = "update_user")
	@ApiModelProperty(value = "更新人")
	private Long updateUser;

	/**
	 * 乐观锁
	 */
	@TableField(value = "version")
	@ApiModelProperty(value = "乐观锁")
	private Long version;

	/**
	 * 删除标记
	 */
	@TableField(value = "deleted")
	@ApiModelProperty(value = "删除标记")
	private Byte deleted;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_PID = "pid";

	public static final String COL_PATH = "path";

	public static final String COL_NAME = "name";

	public static final String COL_STATUS = "status";

	public static final String COL_CREATE_TIME = "create_time";

	public static final String COL_CREATE_USER = "create_user";

	public static final String COL_UPDATE_TIME = "update_time";

	public static final String COL_UPDATE_USER = "update_user";

	public static final String COL_VERSION = "version";

	public static final String COL_DELETED = "deleted";

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
	 * 获取父id
	 *
	 * @return pid - 父id
	 */
	public Long getPid() {
		return pid;
	}

	/**
	 * 设置父id
	 *
	 * @param pid 父id
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}

	/**
	 * 获取菜单地址
	 *
	 * @return path - 菜单地址
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 设置菜单地址
	 *
	 * @param path 菜单地址
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 获取菜单名称
	 *
	 * @return name - 菜单名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置菜单名称
	 *
	 * @param name 菜单名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取0无效，1有效
	 *
	 * @return status - 0无效，1有效
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * 设置0无效，1有效
	 *
	 * @param status 0无效，1有效
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_time - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取创建人
	 *
	 * @return create_user - 创建人
	 */
	public Long getCreateUser() {
		return createUser;
	}

	/**
	 * 设置创建人
	 *
	 * @param createUser 创建人
	 */
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	/**
	 * 获取更新时间
	 *
	 * @return update_time - 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置更新时间
	 *
	 * @param updateTime 更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取更新人
	 *
	 * @return update_user - 更新人
	 */
	public Long getUpdateUser() {
		return updateUser;
	}

	/**
	 * 设置更新人
	 *
	 * @param updateUser 更新人
	 */
	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * 获取乐观锁
	 *
	 * @return version - 乐观锁
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * 设置乐观锁
	 *
	 * @param version 乐观锁
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * 获取删除标记
	 *
	 * @return deleted - 删除标记
	 */
	public Byte getDeleted() {
		return deleted;
	}

	/**
	 * 设置删除标记
	 *
	 * @param deleted 删除标记
	 */
	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
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
		ManagerMenu other = (ManagerMenu) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
				&& (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
				&& (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
				&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
				&& (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
				&& (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
		result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
		result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
		result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
		result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
		result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
		return result;
	}
}