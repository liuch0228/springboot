package com.lch.springboot02.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthorProperties {

	@Value("${book.author.name}")
	private String authorName;
	
	@Value("${book.author.name1}")
	private String authorName1;


	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorName1() {
		return authorName1;
	}

	public void setAuthorName1(String authorName1) {
		this.authorName1 = authorName1;
	}
}
