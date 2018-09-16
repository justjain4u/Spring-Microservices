package com.jain.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eureka-client")
public interface EurekaClient1 {

	 @RequestMapping(value = "/", method = RequestMethod.GET)
	 String getWord();
	
	
}
