package com.example.feignconsumer.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {

	@Override
	public String hello() {
		return "我是feign的服务降级";
	}

}
