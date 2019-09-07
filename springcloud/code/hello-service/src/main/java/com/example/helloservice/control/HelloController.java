package com.example.helloservice.control;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private static int count=1;
	
	@RequestMapping("/hello-control")
	public String helloControl() {
		return "hello-control-time-"+System.currentTimeMillis()+"-count-"+count++;
	}

}
