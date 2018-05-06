package com.lch.springboot02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lch.springboot02.domain.AuthorProperties;

@RestController // 使用这个注解必须在pom中引入web模块的依赖！
public class PropertiesController {
	@Autowired
	AuthorProperties properties;

	@RequestMapping("/hello")
	public String hello() {
		return "hello spring-boot";
	}

	@RequestMapping("/author")
	public String author() {
		return "the author name is: " + properties.getAuthorName() + ", the author name1 is: " + properties.getAuthorName1();
	}

}
