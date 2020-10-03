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
import com.github.quick.spring.boot.manage.dao.entity.ManagerPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerPermissionMapper extends BaseMapper<ManagerPermission> {
	int updateBatch(List<ManagerPermission> list);

	int updateBatchSelective(List<ManagerPermission> list);

	int batchInsert(@Param("list") List<ManagerPermission> list);

	int insertOrUpdate(ManagerPermission record);

	int insertOrUpdateSelective(ManagerPermission record);
}