package com.example.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ribbonconsumer.hystrix.HelloCommond;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/hello")
	public String index() {
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}
	
	@RequestMapping("/hystrixTest")
	public String hystrix() {
		return new HelloCommond(restTemplate).execute();
	}
}
