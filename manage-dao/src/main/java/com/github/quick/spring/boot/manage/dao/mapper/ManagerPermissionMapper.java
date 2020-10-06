package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.quick.spring.boot.manage.dao.entity.ManagerPermission;

import java.util.List;

import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.res.PermissionInfoResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerPermissionMapper extends BaseMapper<ManagerPermission> {
	int updateBatch(List<ManagerPermission> list);

	int updateBatchSelective(List<ManagerPermission> list);

	int batchInsert(@Param("list") List<ManagerPermission> list);

	int insertOrUpdate(ManagerPermission record);

	int insertOrUpdateSelective(ManagerPermission record);

	List<PermissionInfoResponse> findByButton( @Param("tableName") String tableName);

	List<PermissionInfoResponse> findByMenu( @Param("tableName") String tableName);

	List<PermissionInfoResponse> findByApi( @Param("tableName") String tableName);
}