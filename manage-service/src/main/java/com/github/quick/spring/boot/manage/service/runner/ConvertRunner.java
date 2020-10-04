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

package com.github.quick.spring.boot.manage.service.runner;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;

import com.github.quick.spring.boot.manage.common.interfaces.Convert;
import com.github.quick.spring.boot.manage.service.singlet.SingletObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * convert 提取方法
 *
 * @author huifer
 */
@Component
public class ConvertRunner implements CommandLineRunner, Ordered {

	private static final Logger log = LoggerFactory.getLogger(ConvertRunner.class);


	@Autowired
	private ApplicationContext context;


	@Override
	public void run(String... args) throws Exception {
		Map<String, Convert> beansOfType = context.getBeansOfType(Convert.class);
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
						String targetTypeName = targetType.getTypeName();
						try {
							Class<?> sourceTypeClass = Class.forName(sourceTypeTypeName);
							Class<?> targetTypeClass = Class.forName(targetTypeName);
							ConvertSourceAndTarget convertSourceAndTarget = new ConvertSourceAndTarget(sourceTypeClass,
									targetTypeClass);

							SingletObject.putConvertMap(convertSourceAndTarget, v);
						}
						catch (ClassNotFoundException e) {
							if (log.isErrorEnabled()) {
								log.error("初始化 convert 异常 .", e);
							}
						}

					}
				}
			}

		});
		if (log.isDebugEnabled()) {
			log.debug("初始化 convert 缓存成功!");
		}
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}


	/**
	 * 用来存储 {@link Convert} 的 source 和 target 的实体对象
	 */
	public static class ConvertSourceAndTarget {

		/**
		 * convert - s
		 */
		private Class sourceTypeClass;


		/**
		 * convert -t
		 */
		private Class targetTypeClass;

		public ConvertSourceAndTarget(Class sourceTypeClass, Class targetTypeClass) {
			this.sourceTypeClass = sourceTypeClass;
			this.targetTypeClass = targetTypeClass;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			ConvertSourceAndTarget that = (ConvertSourceAndTarget) o;
			return Objects.equals(sourceTypeClass, that.sourceTypeClass) &&
					Objects.equals(targetTypeClass, that.targetTypeClass);
		}

		@Override
		public int hashCode() {
			return Objects.hash(sourceTypeClass, targetTypeClass);
		}

		public Class getSourceTypeClass() {
			return sourceTypeClass;
		}

		public void setSourceTypeClass(Class sourceTypeClass) {
			this.sourceTypeClass = sourceTypeClass;
		}

		public Class getTargetTypeClass() {
			return targetTypeClass;
		}

		public void setTargetTypeClass(Class targetTypeClass) {
			this.targetTypeClass = targetTypeClass;
		}
	}
}
