package com.example.configclientgit.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

	@Value("${from}")
	private String from;
	
	@RequestMapping("/hello-from")
	public String testFrom() {
		return "获取到的from是--"+from;
	}
}
