package com.github.quick.spring.boot.manage.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.quick.spring.boot.manage.dao.entity.ShopMaterial;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopMaterialMapper extends BaseMapper<ShopMaterial> {
    int updateBatch(List<ShopMaterial> list);

    int updateBatchSelective(List<ShopMaterial> list);

    int batchInsert(@Param("list") List<ShopMaterial> list);

    int insertOrUpdate(ShopMaterial record);

    int insertOrUpdateSelective(ShopMaterial record);
}