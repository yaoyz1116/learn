package com.example.ribbonconsumer.servicer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HelloService {
	
	@Autowired
	private RestTemplate restTemplate;

//    @HystrixCommand(fallbackMethod = "findByIdFallback")
	public String helloService() {
		return restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);
	}
	
	public String helloServiceFallback() {
		return "sorry";
	}
}
