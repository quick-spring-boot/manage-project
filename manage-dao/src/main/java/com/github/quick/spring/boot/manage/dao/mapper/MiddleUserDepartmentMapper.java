package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.MiddleUserDepartment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MiddleUserDepartmentMapper extends BaseMapper<MiddleUserDepartment> {
    int updateBatch(List<MiddleUserDepartment> list);

    int updateBatchSelective(List<MiddleUserDepartment> list);

    int batchInsert(@Param("list") List<MiddleUserDepartment> list);

    int insertOrUpdate(MiddleUserDepartment record);

    int insertOrUpdateSelective(MiddleUserDepartment record);
}