package com.github.quick.spring.boot.manage.dao.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

/**
 * 商铺审核表
 */
@TableName(value = "shop_audit")
public class ShopAudit implements Serializable {
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 申请人id,从商户系统中获取
	 */
	@TableField(value = "shop_user_id")
	private Long shopUserId;

	/**
	 * 商铺id
	 */
	@TableField(value = "shop_id")
	private Long shopId;

	/**
	 * 审核人
	 */
	@TableField(value = "reviewer")
	private Long reviewer;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 创建人
	 */
	@TableField(value = "create_user")
	private Long createUser;

	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

	/**
	 * 更新人
	 */
	@TableField(value = "update_user")
	private Long updateUser;

	/**
	 * 乐观锁
	 */
	@TableField(value = "version")
	@Version
	private Long version;

	/**
	 * 删除标记
	 */
	@TableField(value = "deleted")
	@TableLogic
	private Byte deleted;

	private static final long serialVersionUID = 1L;

	public static final String COL_ID = "id";

	public static final String COL_SHOP_USER_ID = "shop_user_id";

	public static final String COL_SHOP_ID = "shop_id";

	public static final String COL_REVIEWER = "reviewer";

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
	 * 获取申请人id,从商户系统中获取
	 *
	 * @return shop_user_id - 申请人id,从商户系统中获取
	 */
	public Long getShopUserId() {
		return shopUserId;
	}

	/**
	 * 设置申请人id,从商户系统中获取
	 *
	 * @param shopUserId 申请人id,从商户系统中获取
	 */
	public void setShopUserId(Long shopUserId) {
		this.shopUserId = shopUserId;
	}

	/**
	 * 获取商铺id
	 *
	 * @return shop_id - 商铺id
	 */
	public Long getShopId() {
		return shopId;
	}

	/**
	 * 设置商铺id
	 *
	 * @param shopId 商铺id
	 */
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	/**
	 * 获取审核人
	 *
	 * @return reviewer - 审核人
	 */
	public Long getReviewer() {
		return reviewer;
	}

	/**
	 * 设置审核人
	 *
	 * @param reviewer 审核人
	 */
	public void setReviewer(Long reviewer) {
		this.reviewer = reviewer;
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
		ShopAudit other = (ShopAudit) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getShopUserId() == null ? other.getShopUserId() == null : this.getShopUserId().equals(other.getShopUserId()))
				&& (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
				&& (this.getReviewer() == null ? other.getReviewer() == null : this.getReviewer().equals(other.getReviewer()))
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
		result = prime * result + ((getShopUserId() == null) ? 0 : getShopUserId().hashCode());
		result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
		result = prime * result + ((getReviewer() == null) ? 0 : getReviewer().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
		result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
		result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
		result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
		result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
		return result;
	}
}