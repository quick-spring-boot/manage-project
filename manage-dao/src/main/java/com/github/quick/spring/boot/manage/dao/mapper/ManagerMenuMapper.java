package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ManagerMenu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerMenuMapper extends BaseMapper<ManagerMenu> {
	int updateBatch(List<ManagerMenu> list);

	int updateBatchSelective(List<ManagerMenu> list);

	int batchInsert(@Param("list") List<ManagerMenu> list);

	int insertOrUpdate(ManagerMenu record);

	int insertOrUpdateSelective(ManagerMenu record);
}