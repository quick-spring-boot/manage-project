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

import java.lang.reflect.Type;
import java.util.Map;

import com.github.quick.spring.boot.manage.common.interfaces.Convert;
import com.github.quick.spring.boot.manage.dao.entity.ManagerUser;
import com.github.quick.spring.boot.manage.model.req.user.ManagerUserCreateParam;
import com.github.quick.spring.boot.manage.rest.ManageRestApp;
import com.github.quick.spring.boot.manage.service.factory.convert.ParamConvert;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = {ManageRestApp.class})
class ParamConvertImplTest {

	@Autowired
	private ApplicationContext context;

	@Autowired
	@Qualifier("paramConvertImpl")
	private ParamConvert paramConvert;

	@Test
	void testConvert() {
		ManagerUserCreateParam managerUserCreateParam = new ManagerUserCreateParam();
		managerUserCreateParam.setPassword("123456");
		managerUserCreateParam.setUsername("zhangsan");

		ManagerUser convert = paramConvert.convert(managerUserCreateParam, ManagerUser.class);
		System.out.println();
	}

	@Test
	public void param() {
		Map<String, Convert> beansOfType = context.getBeansOfType(Convert.class);
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		beansOfType.forEach((k, v) -> {
			Class<? extends Convert> aClass = v.getClass();
			Type[] genericInterfaces = aClass.getGenericInterfaces();


			for (Type genericInterface : genericInterfaces) {
				ParameterizedTypeImpl type = (ParameterizedTypeImpl) genericInterface;
				Class<?> rawType = type.getRawType();
				if (rawType.equals(Convert.class)) {
					Type[] actualTypeArguments = type.getActualTypeArguments();
					if (actualTypeArguments.length == 2) {

						Type sourceType = actualTypeArguments[0];
						String sourceTypeTypeName = sourceType.getTypeName();
						Type targetType = actualTypeArguments[1];
						String targetTypeName = sourceType.getTypeName();
						try {
							Class<?> sourceTypeClass = Class.forName(sourceTypeTypeName);
							Class<?> targetTypeClass = Class.forName(sourceTypeTypeName);

							System.out.println();
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

					}
				}
			}

			System.out.println();
		});
		System.out.println();
	}

}
