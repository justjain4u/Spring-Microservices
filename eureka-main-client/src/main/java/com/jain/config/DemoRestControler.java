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
	
	
	@Autowired DiscoveryClient client;

	@GetMapping("/sentence")
	  public @ResponseBody String getSentence() {
	    return 
	      getWord("eureka-client") + " "
	      + getWord("eureka-client2") + " "
	      + getWord("eureka-client3") + " "
	      + getWord("eureka-client4") + " "
	      + getWord("eureka-client5") + "."
	      ;
	  }
	  
	  public String getWord(String service) {
	    List<ServiceInstance> list = client.getInstances(service);
	    if (list != null && list.size() > 0 ) {
	      URI uri = list.get(0).getUri();
	  if (uri !=null ) {
	    return (new RestTemplate()).getForObject(uri,String.class);
	  }
	    }
	    return null;
	  }
}
