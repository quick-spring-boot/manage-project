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

package com.github.quick.spring.boot.manage.service.factory.convert.impl.to.db.auto.audit;

import com.github.quick.spring.boot.manage.common.ex.ManagerCommonException;
import com.github.quick.spring.boot.manage.common.interfaces.Convert;
import com.github.quick.spring.boot.manage.dao.entity.ShopMaterial;
import com.github.quick.spring.boot.manage.model.req.shop.audit.ShopMaterialReq;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ShopMaterialReqToDb implements Convert<ShopMaterialReq, ShopMaterial> {

	@Override
	public ShopMaterial convert(ShopMaterialReq materialReq) {
		ShopMaterial shopMaterial = new ShopMaterial();

		if (StringUtils.isEmpty(materialReq.getFoodLicense())) {
			throw new ManagerCommonException("食品许可证不能为空");
		}
		shopMaterial.setFoodLicense(materialReq.getFoodLicense());

		return shopMaterial;
	}
}
