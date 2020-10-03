package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ManagerApi;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerApiMapper extends BaseMapper<ManagerApi> {
    int updateBatch(List<ManagerApi> list);

    int updateBatchSelective(List<ManagerApi> list);

    int batchInsert(@Param("list") List<ManagerApi> list);

    int insertOrUpdate(ManagerApi record);

    int insertOrUpdateSelective(ManagerApi record);
}