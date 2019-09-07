package com.example.ribbonconsumer.hystrix;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

@Service
public class HelloCommond extends HystrixCommand<String>{

	private RestTemplate restTemplate;
	
	
	public HelloCommond(RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.restTemplate = restTemplate;
	}
	

	@Override
	protected String run() throws Exception {
		return restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);
	}
	
	@Override
	protected String getFallback() {
		Throwable t = getExecutionException();
		String ret = t.getMessage();
		return "====服务降级成功===="+ret;
	}
	
	

}
