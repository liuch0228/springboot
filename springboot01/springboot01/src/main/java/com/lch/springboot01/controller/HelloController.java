package com.lch.springboot01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lch.springboot01.domain.User;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String index() {
		return "hello world";
	}

	@RequestMapping("/getUser")
	public User getUser() {
		User user = new User();
		user.setUserName("小明");
		user.setPassWord("123");
		return user;
	}

}
