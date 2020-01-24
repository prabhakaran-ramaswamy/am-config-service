package org.sample.capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConfigController {

	@Autowired
	private LimitConfig limitConfig;

	@GetMapping("/limits")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	public LimitConfig getLimitConfigs() {
		if(limitConfig.getMinimum()<1 || limitConfig.getMaximum()<1)
			throw new RuntimeException("values are not loaded");
		return limitConfig;
	}

	public LimitConfig fallbackRetrieveConfiguration() {
		return new LimitConfig(1, 1);
	}
}
