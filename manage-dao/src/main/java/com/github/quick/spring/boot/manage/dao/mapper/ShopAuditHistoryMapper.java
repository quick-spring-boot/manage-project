package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ShopAuditHistory;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopAuditHistoryMapper extends BaseMapper<ShopAuditHistory> {
    int updateBatch(List<ShopAuditHistory> list);

    int updateBatchSelective(List<ShopAuditHistory> list);

    int batchInsert(@Param("list") List<ShopAuditHistory> list);

    int insertOrUpdate(ShopAuditHistory record);

    int insertOrUpdateSelective(ShopAuditHistory record);
}