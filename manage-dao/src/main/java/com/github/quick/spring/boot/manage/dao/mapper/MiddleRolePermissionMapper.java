package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.MiddleRolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MiddleRolePermissionMapper extends BaseMapper<MiddleRolePermission> {
    int updateBatch(List<MiddleRolePermission> list);

    int updateBatchSelective(List<MiddleRolePermission> list);

    int batchInsert(@Param("list") List<MiddleRolePermission> list);

    int insertOrUpdate(MiddleRolePermission record);

    int insertOrUpdateSelective(MiddleRolePermission record);
}