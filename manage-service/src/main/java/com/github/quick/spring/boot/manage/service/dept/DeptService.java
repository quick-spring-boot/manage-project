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

package com.github.quick.spring.boot.manage.service.dept;

import java.util.List;

import com.github.quick.spring.boot.manage.dao.entity.ManagerDepartment;
import com.github.quick.spring.boot.manage.model.req.dept.CreateDeptParam;
import com.github.quick.spring.boot.manage.model.req.dept.QueryDeptParam;
import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.res.ManagerDeptResponse;

public interface DeptService {
	List<ManagerDeptResponse> child(Long deptId);

	ManagerDeptResponse byId(Long deptId);

	Object query(QueryDeptParam param, PageParam pageParam);

	boolean update(Long deptId, CreateDeptParam param);

	boolean create(CreateDeptParam param);

	/**
	 * 寻找商铺部门
	 * @return
	 */
	List<ManagerDepartment> shopShopAudit();
}
