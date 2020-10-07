package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ShopAudit;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopAuditMapper extends BaseMapper<ShopAudit> {
    int updateBatch(List<ShopAudit> list);

    int updateBatchSelective(List<ShopAudit> list);

    int batchInsert(@Param("list") List<ShopAudit> list);

    int insertOrUpdate(ShopAudit record);

    int insertOrUpdateSelective(ShopAudit record);
}