package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ManagerButton;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerButtonMapper extends BaseMapper<ManagerButton> {
    int updateBatch(List<ManagerButton> list);

    int updateBatchSelective(List<ManagerButton> list);

    int batchInsert(@Param("list") List<ManagerButton> list);

    int insertOrUpdate(ManagerButton record);

    int insertOrUpdateSelective(ManagerButton record);
}