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

package com.github.quick.spring.boot.manage.rest.controller.department;

import com.github.quick.spring.boot.manage.model.req.dept.CreateDeptParam;
import com.github.quick.spring.boot.manage.model.req.dept.QueryDeptParam;
import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.vo.ResultVo;
import com.github.quick.spring.boot.manage.rest.response.OkResponse;
import com.github.quick.spring.boot.manage.service.dept.DeptService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DeptService deptService;


	@ApiOperation(value = "创建部门")
	@PostMapping("/")
	public ResultVo<Boolean> create(
			@RequestBody CreateDeptParam param
	) {

		return OkResponse.SAVE_SUCCESS.ret(deptService.create(param));
	}

	@ApiOperation(value = "修改部门信息")
	@PutMapping("/{dept_id}")
	public ResultVo<Boolean> update(
			@ApiParam(value = "部门id") @PathVariable(value = "dept_id") Long deptId,
			@RequestBody CreateDeptParam param

	) {
		return OkResponse.UPDATE_SUCCESS.ret(deptService.update(deptId,param));
	}


	@ApiOperation(value = "查询部门列表")
	@GetMapping("/query")
	public ResultVo<Object> query(
			QueryDeptParam param,
			PageParam pageParam
	) {
		return OkResponse.QUERY_SUCCESS.ret(deptService.query(param,pageParam));
	}

	@ApiOperation(value = "根据ID查询部门详情")
	@GetMapping("/{dept_id}")
	public ResultVo<Object> byId(
			@ApiParam(value = "部门id") @PathVariable(value = "dept_id") Long deptId
	) {
		return OkResponse.QUERY_SUCCESS.ret(deptService.byId(deptId));
	}


	@ApiOperation(value = "下级部门列表")
	@GetMapping("/child/{dept_id}")
	public ResultVo<Object> child(
			@ApiParam(value = "部门id") @PathVariable(value = "dept_id") Long deptId
	) {
		return OkResponse.QUERY_SUCCESS.ret(deptService.child(deptId));
	}

}
