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

package com.github.quick.spring.boot.manage.dao.mp;

import java.util.Date;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.ibatis.reflection.MetaObject;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
		return new OptimisticLockerInterceptor();
	}

	@Override
	public void insertFill(MetaObject metaObject) {
		// 创建时间+更新时间设置
		this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
		this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
		// todo: 创建人设置, 更新人设置
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		// 设置更新时间
		this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
		// todo: 更新人设置
	}

}