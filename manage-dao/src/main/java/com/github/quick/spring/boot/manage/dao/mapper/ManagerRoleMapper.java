/*
 * Copyright 2020-present quick-spring-boot All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.quick.spring.boot.manage.dao.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.quick.spring.boot.manage.dao.entity.ManagerRole;
import com.github.quick.spring.boot.manage.model.req.role.QueryRoleParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerRoleMapper extends BaseMapper<ManagerRole> {
	int updateBatch(List<ManagerRole> list);

	int updateBatchSelective(List<ManagerRole> list);

	int batchInsert(@Param("list") List<ManagerRole> list);

	int insertOrUpdate(ManagerRole record);

	int insertOrUpdateSelective(ManagerRole record);

	ManagerRole findByName(@Param("name") String name);

	IPage<ManagerRole> query(@Param("roleIPage") Page<ManagerRole> roleIPage, @Param("param") QueryRoleParam param);

}