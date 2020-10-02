package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ManagerDepartment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerDepartmentMapper extends BaseMapper<ManagerDepartment> {
	int updateBatch(List<ManagerDepartment> list);

	int updateBatchSelective(List<ManagerDepartment> list);

	int batchInsert(@Param("list") List<ManagerDepartment> list);

	int insertOrUpdate(ManagerDepartment record);

	int insertOrUpdateSelective(ManagerDepartment record);
}