package com.example.helloservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	private static int num=1;
	
	@RequestMapping("/hello")
	public String index() {
		String ret = "hello world";
		System.out.println(ret+"------"+num++);
		return ret;
	}

}
