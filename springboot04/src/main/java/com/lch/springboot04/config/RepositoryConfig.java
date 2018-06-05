package com.lch.springboot04.config;

import com.lch.springboot04.repo.base.BaseRepositoryFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 配置类,不配置，会报错，找不到bean
 */
@Configuration
//指定自己的工厂类
@EnableJpaRepositories(basePackages = {"com.lch.springboot04"},
        repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class RepositoryConfig {
}
