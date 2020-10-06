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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.quick.spring.boot.manage.dao.entity.ManagerDepartment;
import com.github.quick.spring.boot.manage.dao.mapper.ManagerDepartmentMapper;
import com.github.quick.spring.boot.manage.model.req.dept.CreateDeptParam;
import com.github.quick.spring.boot.manage.model.req.dept.QueryDeptParam;
import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.res.ManagerDeptResponse;
import com.github.quick.spring.boot.manage.service.factory.convert.ParamConvert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private ManagerDepartmentMapper departmentMapper;

	@Autowired
	@Qualifier("paramConvertImpl")
	private ParamConvert paramConvert;

	@Override
	public List<ManagerDeptResponse> child(Long deptId) {
		if (deptId == null) {
			return Collections.emptyList();
		}
		List<ManagerDepartment> child = departmentMapper.findByPid(deptId);

		return child.stream().
				map(managerDepartment ->
						paramConvert.convert(managerDepartment, ManagerDeptResponse.class))
				.collect(Collectors.toCollection(() -> new ArrayList<>(child.size())));
	}

	@Override
	public ManagerDeptResponse byId(Long deptId) {
		ManagerDepartment managerDepartment = departmentMapper.selectById(deptId);
		return paramConvert.convert(managerDepartment, ManagerDeptResponse.class);
	}

	@Override
	public Object query(QueryDeptParam param, PageParam pageParam) {

		IPage<ManagerDepartment> departmentPage = new Page<>(pageParam.getPageCount(), pageParam.getPageSize());

		QueryWrapper<ManagerDepartment> queryWrapper = new QueryWrapper<>();
		if (!StringUtils.isEmpty(param.getName())) {
			queryWrapper.like(ManagerDepartment.COL_NAME, param.getName());
		}


		IPage page = this.departmentMapper.selectPage(departmentPage, queryWrapper);

		List records = page.getRecords();
		List<ManagerDeptResponse> res = new ArrayList<>();
		for (Object record : records) {
			records.add(paramConvert.convert(record, ManagerDeptResponse.class));
		}
		page.setRecords(res);
		return page;
	}

	@Override
	public boolean update(Long deptId, CreateDeptParam param) {

		ManagerDepartment managerDepartment = this.departmentMapper.selectById(deptId);
		if (managerDepartment != null) {
			ManagerDepartment db = this.departmentMapper.findByName(param.getName());
			if (db == null) {
				ManagerDepartment convert = paramConvert.convert(param, ManagerDepartment.class);
				convert.setId(deptId);
				return this.departmentMapper.updateById(convert) > 0;

			}

		}


		return false;
	}

	@Override
	public boolean create(CreateDeptParam param) {
		ManagerDepartment convert = paramConvert.convert(param, ManagerDepartment.class);
		return departmentMapper.insert(convert) > 0;
	}
}
