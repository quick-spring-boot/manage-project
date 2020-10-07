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

package com.github.quick.spring.boot.manage.service.shop.audit;

import java.util.List;

import com.github.quick.spring.boot.manage.common.ex.ManagerCommonException;
import com.github.quick.spring.boot.manage.dao.entity.ManagerUser;
import com.github.quick.spring.boot.manage.dao.entity.ShopAudit;
import com.github.quick.spring.boot.manage.dao.entity.ShopAuditHistory;
import com.github.quick.spring.boot.manage.dao.entity.ShopMaterial;
import com.github.quick.spring.boot.manage.dao.mapper.ShopAuditHistoryMapper;
import com.github.quick.spring.boot.manage.dao.mapper.ShopAuditMapper;
import com.github.quick.spring.boot.manage.dao.mapper.ShopMaterialMapper;
import com.github.quick.spring.boot.manage.model.enums.AuditStatus;
import com.github.quick.spring.boot.manage.model.req.shop.audit.ShopMaterialReq;
import com.github.quick.spring.boot.manage.service.factory.convert.ParamConvert;
import com.github.quick.spring.boot.manage.service.user.ManagerUserBizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopAuditServiceImpl implements ShopAuditService {
	private static final Logger log = LoggerFactory.getLogger(ShopAuditServiceImpl.class);

	@Autowired
	@Qualifier("paramConvertImpl") ParamConvert paramConvert;

	@Autowired
	@Qualifier("managerUserBizServiceImpl")
	private ManagerUserBizService managerUserBizService;

	@Autowired
	private ShopAuditMapper shopAuditMapper;

	@Autowired
	private ShopMaterialMapper shopMaterialMapper;

	@Autowired
	private ShopAuditHistoryMapper historyMapper;

	@Transactional(rollbackFor = Exception.class)
	public boolean submit(Long shopUserId, Long shopId, ShopMaterialReq materialReq) {
		if (log.isInfoEnabled()) {
			log.info("submit,shopUserId = {}, shopId = {}, materialReq = {}", shopUserId, shopId, materialReq);
		}


		// 1. 创建实体
		ShopAudit shopAudit = new ShopAudit();
		shopAudit.setShopId(shopId);
		shopAudit.setShopUserId(shopUserId);
		// 2. 发送审核信息给审核人
		List<ManagerUser> shopAuditUser = managerUserBizService.findShopAudit();
		// TODO: 发送消息给审核人
		// 3. 审核表落地
		int insert = shopAuditMapper.insert(shopAudit);
		if (insert > 0) {
			// 4. 审核附件落地
			ShopMaterial convert = paramConvert.convert(materialReq, ShopMaterial.class);
			return shopMaterialMapper.insert(convert) > 0;
		}

		return false;
	}

	@Override
	public boolean canAudit(Long userId, Long shopAuditId) {
		if (log.isInfoEnabled()) {
			log.info("canAudit,userId = {}, shopAuditId = {}", userId, shopAuditId);
		}

		if (shopAuditId == null) {
			throw new ManagerCommonException("商铺审核id不能为空");
		}

		if (userId == null) {
			throw new ManagerCommonException("用户id不能为空");
		}

		ShopAudit shopAudit = shopAuditMapper.selectById(shopAuditId);
		if (shopAudit != null) {
			return shopAudit.getReviewer().equals(userId);
		}
		return false;
	}

	@Override
	public boolean audit(
			@NonNull Long userId, @NonNull Long shopAuditId, @NonNull String content,
			@NonNull AuditStatus status) {
		if (log.isInfoEnabled()) {
			log.info("audit,userId = {}, shopAuditId = {}, content = {}, status = {}", userId, shopAuditId, content, status);
		}
		if (canAudit(userId, shopAuditId)) {
			ShopAuditHistory shopAuditHistory = new ShopAuditHistory();
			shopAuditHistory.setShopAuditId(shopAuditId);
			shopAuditHistory.setStatus((byte) status.getCode());
			shopAuditHistory.setContent(content);
			return historyMapper.insert(shopAuditHistory) > 0;
		}


		return false;
	}
}
