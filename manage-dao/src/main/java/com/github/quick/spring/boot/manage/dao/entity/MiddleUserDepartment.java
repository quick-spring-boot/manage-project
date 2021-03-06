package com.github.quick.spring.boot.manage.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
    * 用户和部门关系表
    */
@ApiModel(value="com-github-quick-spring-boot-manage-dao-entity-MiddleUserDepartment")
@TableName(value = "middle_user_department")
public class MiddleUserDepartment implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 管理端用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="管理端用户id")
    private Long userId;

    /**
     * 部门id
     */
    @TableField(value = "department_id")
    @ApiModelProperty(value="部门id")
    private Long departmentId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

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
     * 获取管理端用户id
     *
     * @return user_id - 管理端用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置管理端用户id
     *
     * @param userId 管理端用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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
        MiddleUserDepartment other = (MiddleUserDepartment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        return result;
    }
}