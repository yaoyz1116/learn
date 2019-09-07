package com.example.ribbonconsumer.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ribbonconsumer.command.ConsumerCommand;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/hello-consumer")
	public String consumerdemo() {
		return restTemplate.getForObject("http://HELLO-SERVICE/hello-control", String.class);
	}
	
	@RequestMapping("/hello-hystrix")
	public String hystrixDemo() {
		return new ConsumerCommand(restTemplate).execute();
	}
}
