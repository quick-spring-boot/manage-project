package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ManagerRole;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerRoleMapper extends BaseMapper<ManagerRole> {
	int updateBatch(List<ManagerRole> list);

	int updateBatchSelective(List<ManagerRole> list);

	int batchInsert(@Param("list") List<ManagerRole> list);

	int insertOrUpdate(ManagerRole record);

	int insertOrUpdateSelective(ManagerRole record);
}