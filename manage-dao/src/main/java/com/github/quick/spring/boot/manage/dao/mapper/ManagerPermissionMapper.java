package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ManagerPermission;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerPermissionMapper extends BaseMapper<ManagerPermission> {
	int updateBatch(List<ManagerPermission> list);

	int updateBatchSelective(List<ManagerPermission> list);

	int batchInsert(@Param("list") List<ManagerPermission> list);

	int insertOrUpdate(ManagerPermission record);

	int insertOrUpdateSelective(ManagerPermission record);
}