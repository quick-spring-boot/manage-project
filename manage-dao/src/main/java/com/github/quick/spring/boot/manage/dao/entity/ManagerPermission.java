package com.github.quick.spring.boot.manage.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限表
 */
@ApiModel(value = "com-github-quick-spring-boot-manage-dao-entity-ManagerPermission")
@TableName(value = "manager_permission")
public class ManagerPermission implements Serializable {
	public static final String COL_CODE = "code";

	public static final String COL_VAL = "val";

	public static final String COL_ID = "id";

	public static final String COL_TYPE = "type";

	public static final String COL_REF_ID = "ref_id";

	public static final String COL_STATUS = "status";

	public static final String COL_CREATE_TIME = "create_time";

	public static final String COL_CREATE_USER = "create_user";

	public static final String COL_UPDATE_TIME = "update_time";

	public static final String COL_UPDATE_USER = "update_user";

	public static final String COL_VERSION = "version";

	public static final String COL_DELETED = "deleted";

	public static final String COL_REF_TABLE = "ref_table";

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "")
	private Long id;

	/**
	 * 1. 菜单，2. 按钮，3. url
	 */
	@TableField(value = "`type`")
	@ApiModelProperty(value = "1. 菜单，2. 按钮，3. url")
	private Byte type;

	/**
	 * 外联id
	 */
	@TableField(value = "ref_id")
	@ApiModelProperty(value = "外联id")
	private Long refId;

	/**
	 * 0无效，1有效
	 */
	@TableField(value = "`status`")
	@ApiModelProperty(value = "0无效，1有效")
	private Byte status;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
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
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
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
	@Version
	@TableField(value = "version")
	@ApiModelProperty(value = "乐观锁")
	private Long version;

	/**
	 * 删除标记
	 */
	@TableLogic
	@TableField(value = "deleted")
	@ApiModelProperty(value = "删除标记")
	private Byte deleted;

	/**
	 * 外联表
	 */
	@TableField(value = "ref_table")
	@ApiModelProperty(value = "外联表")
	private String refTable;

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
	 * 获取1. 菜单，2. 按钮，3. url
	 *
	 * @return type - 1. 菜单，2. 按钮，3. url
	 */
	public Byte getType() {
		return type;
	}

	/**
	 * 设置1. 菜单，2. 按钮，3. url
	 *
	 * @param type 1. 菜单，2. 按钮，3. url
	 */
	public void setType(Byte type) {
		this.type = type;
	}

	/**
	 * 获取外联id
	 *
	 * @return ref_id - 外联id
	 */
	public Long getRefId() {
		return refId;
	}

	/**
	 * 设置外联id
	 *
	 * @param refId 外联id
	 */
	public void setRefId(Long refId) {
		this.refId = refId;
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

	/**
	 * 获取外联表
	 *
	 * @return ref_table - 外联表
	 */
	public String getRefTable() {
		return refTable;
	}

	/**
	 * 设置外联表
	 *
	 * @param refTable 外联表
	 */
	public void setRefTable(String refTable) {
		this.refTable = refTable;
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
		ManagerPermission other = (ManagerPermission) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getRefId() == null ? other.getRefId() == null : this.getRefId().equals(other.getRefId()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
				&& (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
				&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
				&& (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
				&& (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
				&& (this.getRefTable() == null ? other.getRefTable() == null : this.getRefTable().equals(other.getRefTable()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getRefId() == null) ? 0 : getRefId().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
		result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
		result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
		result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
		result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
		result = prime * result + ((getRefTable() == null) ? 0 : getRefTable().hashCode());
		return result;
	}
}