package com.lch.springboot03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Springboot03Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Springboot03Application.class, args);
	}

	/**
	 * 启动类添加Servlet的支持：继承SpringBootServletInitializer
	 * alt+ Insert 选择对configure()方法进行重写
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Springboot03Application.class);
	}
}
