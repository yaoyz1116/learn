package com.example.ribbonconsumer.command;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class ConsumerCommand extends HystrixCommand<String>{
	
	private RestTemplate restTemplate;

	private static int count = 1;
	
	public ConsumerCommand(RestTemplate restTemplate) {	
        super(HystrixCommandGroupKey.Factory.asKey(""));
        this.restTemplate = restTemplate;
	}

	@Override
	protected String run() throws Exception {
		return restTemplate.getForObject("http://HELLO-SERVICE/hello-control", String.class);
	}
	
	@Override
	protected String getFallback() {
		return "调用其他微服务出错，错误次数:"+count++;
	}
}
