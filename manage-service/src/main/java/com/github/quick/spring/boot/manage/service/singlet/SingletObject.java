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

package com.github.quick.spring.boot.manage.service.singlet;

import java.util.HashMap;
import java.util.Map;

import com.github.quick.spring.boot.manage.common.interfaces.Convert;
import com.github.quick.spring.boot.manage.service.runner.ConvertRunner;

public class SingletObject {

	private static final Map<ConvertRunner.ConvertSourceAndTarget, Convert> convertMap = new HashMap<>(64);

	public static Convert getConvertMap(ConvertRunner.ConvertSourceAndTarget convertSourceAndTarget) {
		return convertMap.get(convertSourceAndTarget);
	}


	public static void putConvertMap(ConvertRunner.ConvertSourceAndTarget convertSourceAndTarget, Convert convert) {
		convertMap.put(convertSourceAndTarget, convert);
	}

}
