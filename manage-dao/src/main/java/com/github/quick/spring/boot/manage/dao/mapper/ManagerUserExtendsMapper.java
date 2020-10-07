package com.github.quick.spring.boot.manage.dao.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ManagerUserExtends;
import com.github.quick.spring.boot.manage.model.dto.ManagerUserDevice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerUserExtendsMapper extends BaseMapper<ManagerUserExtends> {
	int updateBatch(List<ManagerUserExtends> list);

	int updateBatchSelective(List<ManagerUserExtends> list);

	int batchInsert(@Param("list") List<ManagerUserExtends> list);

	int insertOrUpdate(ManagerUserExtends record);

	int insertOrUpdateSelective(ManagerUserExtends record);

	ManagerUserDevice findByUserId(@Param("userId") Long userId);
}