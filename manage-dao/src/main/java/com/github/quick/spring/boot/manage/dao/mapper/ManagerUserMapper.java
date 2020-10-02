package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ManagerUser;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerUserMapper extends BaseMapper<ManagerUser> {
    int updateBatch(List<ManagerUser> list);

    int updateBatchSelective(List<ManagerUser> list);

    int batchInsert(@Param("list") List<ManagerUser> list);

    int insertOrUpdate(ManagerUser record);

    int insertOrUpdateSelective(ManagerUser record);
}