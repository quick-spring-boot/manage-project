package com.github.quick.spring.boot.manage.rest.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mapper 配置
 * @author huifer
 */
@Configuration
@MapperScan("com.github.quick.spring.boot.manage.dao.mapper")
public class MapperConfig {

	/**
	 * mybatis-plus 乐观锁
	 * @return OptimisticLockerInterceptor
	 */
	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
		return new OptimisticLockerInterceptor();
	}
}
