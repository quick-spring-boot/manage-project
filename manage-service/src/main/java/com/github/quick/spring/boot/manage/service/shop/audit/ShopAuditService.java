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

import com.github.quick.spring.boot.manage.model.enums.AuditStatus;
import com.github.quick.spring.boot.manage.model.req.shop.audit.ShopMaterialReq;

public interface ShopAuditService {

	/**
	 * 提交商铺审核
	 * @param shopUserId 商户id
	 * @param shopId 商铺id
	 * @param materialReq 申请附件信息
	 * @return true: 提交成功,false: 提交失败
	 */
	boolean submit(Long shopUserId, Long shopId, ShopMaterialReq materialReq);

	/**
	 * 是否能够审核
	 * @param userId 用户id
	 * @param shopAuditId 商铺审核单id
	 * @return true \  false:
	 */
	boolean canAudit(Long userId , Long shopAuditId);


	/**
	 * 审核
	 * @param userId 审核人
	 * @param shopAuditId 审核单
	 * @param content 内容
	 * @param status 状态
	 * @return true: 数据保存成功, false: 数据保存失败
	 */
	boolean audit(Long userId, Long shopAuditId, String content, AuditStatus status);
}
