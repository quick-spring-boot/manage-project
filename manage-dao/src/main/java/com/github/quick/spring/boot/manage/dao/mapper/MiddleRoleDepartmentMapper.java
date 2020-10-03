package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.MiddleRoleDepartment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MiddleRoleDepartmentMapper extends BaseMapper<MiddleRoleDepartment> {
	int updateBatch(List<MiddleRoleDepartment> list);

	int updateBatchSelective(List<MiddleRoleDepartment> list);

	int batchInsert(@Param("list") List<MiddleRoleDepartment> list);

	int insertOrUpdate(MiddleRoleDepartment record);

	int insertOrUpdateSelective(MiddleRoleDepartment record);
}