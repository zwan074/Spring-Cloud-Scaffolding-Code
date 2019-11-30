package com.example.demo.Controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.enitities.Consumer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class ConsumerController_FeignClientProducer {

	private static final String REST_URL_PREFIX = "http://microservicecloud-consumer";
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "consumer/get/{id}")
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Consumer get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/consumer/get/" + id, Consumer.class);
    }
	
	public Consumer processHystrix_Get(@PathVariable("id") Long id) {
        return new Consumer().setConsumer_no(id).setCname("this ID：" + id + " no such information,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
	
	@GetMapping(path = "consumer/p")
    public Principal p(Principal principal) {
        return principal;
    }
	
	@GetMapping(path = "consumer/user") //pass principal variable to consumer
    public Consumer get(Principal principal) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/consumer/user/" + 1, Consumer.class);
    }
	

}
