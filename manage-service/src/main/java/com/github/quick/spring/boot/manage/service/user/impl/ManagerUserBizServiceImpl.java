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

package com.github.quick.spring.boot.manage.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.quick.spring.boot.manage.common.ex.ManagerCommonException;
import com.github.quick.spring.boot.manage.dao.entity.ManagerUser;
import com.github.quick.spring.boot.manage.dao.entity.MiddleUserDepartment;
import com.github.quick.spring.boot.manage.dao.mapper.ManagerUserMapper;
import com.github.quick.spring.boot.manage.dao.mapper.MiddleUserDepartmentMapper;
import com.github.quick.spring.boot.manage.model.req.page.PageParam;
import com.github.quick.spring.boot.manage.model.req.user.ManagerUserCreateParam;
import com.github.quick.spring.boot.manage.model.res.ManagerUserResponse;
import com.github.quick.spring.boot.manage.model.res.TokenCollection;
import com.github.quick.spring.boot.manage.service.factory.convert.ParamConvert;
import com.github.quick.spring.boot.manage.service.user.ManagerUserBizService;
import com.github.quick.spring.boot.manage.service.user.token.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("managerUserBizServiceImpl")
public class ManagerUserBizServiceImpl implements ManagerUserBizService {
	private static final Logger log = LoggerFactory.getLogger(ManagerUserBizServiceImpl.class);


	private final ParamConvert paramConvert;

	private final ManagerUserMapper managerUserMapper;

	private final TokenService tokenService;

	@Autowired
	private MiddleUserDepartmentMapper middleUserDepartmentMapper;

	public ManagerUserBizServiceImpl(
			ManagerUserMapper managerUserMapper,
			@Qualifier("paramConvertImpl") ParamConvert paramConvert, @Qualifier("tokenServiceImpl") TokenService tokenService) {
		this.managerUserMapper = managerUserMapper;
		this.paramConvert = paramConvert;
		this.tokenService = tokenService;
	}

	@Override
	public boolean createManagerUser(ManagerUserCreateParam param) {
		if (log.isInfoEnabled()) {
			log.info("createManagerUser,param = {}", param);
		}
		checkByUqUsername(param.getUsername());

		ManagerUser convert = paramConvert.convert(param, ManagerUser.class);

		int insert = managerUserMapper.insert(convert);
		return insert > 0;
	}

	/**
	 * 判断用户名是否唯一
	 * @param username 用户名称
	 */
	private void checkByUqUsername(String username) {
		ManagerUser byUsername = managerUserMapper.queryByUsername(username);
		if (byUsername != null) {
			throw new ManagerCommonException("当前用户名已存在请更换用户名");
		}
	}

	@Override
	public boolean updateUser(Long userId, ManagerUserCreateParam userCreateParam) {
		if (log.isInfoEnabled()) {
			log.info("updateUser,userId = {}, userCreateParam = {}", userId, userCreateParam);
		}

		ManagerUser dbUser = managerUserMapper.selectById(userId);
		if (dbUser != null) {


			ManagerUser convert = paramConvert.convert(userCreateParam, ManagerUser.class);

			if (!dbUser.getUsername().equals(convert.getUsername())) {

				// 如果数据库名称和请求参数名称不相同则需要验证请求参数的名称是否唯一
				checkByUqUsername(userCreateParam.getUsername());
				dbUser.setUsername(convert.getUsername());
			}

			if (!dbUser.getPassword().equals(convert.getPassword())) {
				dbUser.setPassword(convert.getPassword());
			}
			int i = managerUserMapper.updateById(dbUser);
			return i > 0;

		}


		return false;
	}

	@Override
	public Object query(PageParam pageParam) {
		IPage<ManagerUser> userPage = new Page<>(pageParam.getPageCount(), pageParam.getPageSize());
		IPage managerUserIPage = this.managerUserMapper.selectPage(userPage, null);


		List records = managerUserIPage.getRecords();
		List<ManagerUserResponse> res = new ArrayList<>();

		for (Object record : records) {
			ManagerUserResponse convert = this.paramConvert.convert(record, ManagerUserResponse.class);
			res.add(convert);
		}
		managerUserIPage.setRecords(res);
		return managerUserIPage;
	}

	@Override
	public ManagerUserResponse byId(Long userId) {
		ManagerUser managerUser = this.managerUserMapper.selectById(userId);
		if (managerUser != null) {
			return this.paramConvert.convert(managerUser, ManagerUserResponse.class);
		}

		return null;
	}

	@Override
	public TokenCollection generatorToken(long userId) {
		return tokenService.generatorToken(userId);
	}

	@Override
	public TokenCollection refreshToken(String refreshToken) {
		return tokenService.refreshToken(refreshToken);
	}

	@Override
	public ManagerUserResponse findUserByToken(String accessToken) {
		boolean expire = this.tokenService.expire(accessToken);
		if (expire) {
			throw new ManagerCommonException("token过期");
		}

		String userId = this.tokenService.getUserId(accessToken);
		if (StringUtils.isEmpty(userId)) {
			throw new ManagerCommonException("token 中用户id不存在");
		}
		return this.byId(Long.parseLong(userId));
	}

	@Override
	public Boolean bindDepartment(Long userId, Long deptId) {

		MiddleUserDepartment middleUserDepartment = middleUserDepartmentMapper.findByUserIdAndDeptId(userId, deptId);

		if (middleUserDepartment == null) {
			MiddleUserDepartment insert = new MiddleUserDepartment();
			insert.setDepartmentId(deptId);
			insert.setUserId(userId);
			return this.middleUserDepartmentMapper.insert(insert) > 0;
		}
		else {
			throw new ManagerCommonException("已存在绑定关系");
		}
	}

	@Override
	public Boolean unBindDepartment(Long userId, Long deptId) {
		MiddleUserDepartment middleUserDepartment = middleUserDepartmentMapper.findByUserIdAndDeptId(userId, deptId);

		if (middleUserDepartment != null) {
			Long id = middleUserDepartment.getId();
			return this.middleUserDepartmentMapper.deleteById(id) > 0;
		}
		return false;
	}
}
