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

package com.github.quick.spring.boot.manage.service.factory.convert.impl;

import com.github.quick.spring.boot.manage.common.interfaces.Convert;
import com.github.quick.spring.boot.manage.service.factory.convert.ParamConvert;
import com.github.quick.spring.boot.manage.service.runner.ConvertRunner;
import com.github.quick.spring.boot.manage.service.singlet.SingletObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("paramConvertImpl")
public class ParamConvertImpl implements ParamConvert {
	@Autowired
	private ApplicationContext context;

	@Override
	public <T> T convert(Object source, Class<T> target) {
		Class<?> sourceClass = source.getClass();
		ConvertRunner.ConvertSourceAndTarget convertSourceAndTarget = new ConvertRunner.ConvertSourceAndTarget(sourceClass, target);
		Convert convertMap = SingletObject.getConvertMap(convertSourceAndTarget);
		return (T) convertMap.convert(source);
	}
}
