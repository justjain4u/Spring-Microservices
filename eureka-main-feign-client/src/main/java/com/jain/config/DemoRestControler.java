package com.jain.config;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoRestControler {
	
	
	@Autowired EurekaClient1 client1;
	
	@GetMapping("/sentence1")
	  public @ResponseBody String getSentence() {
	    return client1.getWord();
	  }
	  
}
