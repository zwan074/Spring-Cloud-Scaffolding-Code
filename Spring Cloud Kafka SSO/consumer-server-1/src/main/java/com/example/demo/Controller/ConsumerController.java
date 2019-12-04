package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enitities.Consumer;
import com.example.demo.enitities.Message;
import com.example.demo.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {
	@Autowired
    private ConsumerService service = null;

	@Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
	
	@GetMapping("consumer/post/{message}")
    public void sendMessage(@PathVariable String message) {
        this.kafkaTemplate.send("test", new Message("kafkaTest", message));
    }
	
    @GetMapping(path = "consumer/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get") //will use @HystrixCommand annotation and fall back to the fallbackMethod
    public Consumer get(@PathVariable("id") Long id) {

    	Consumer consumer = this.service.get(id);

        if (null == consumer) {
            throw new RuntimeException("this ID：" + id + "no such information");
        }

        return consumer;
    }

    @GetMapping(path = "consumer/user/{id}") //variable id from feign client to find login user id
    public Consumer user(@PathVariable("id") Long id) {
    	Consumer consumer = this.service.get(id);

        if (null == consumer) {
            throw new RuntimeException("this ID：" + id + "no such information");
        }

        return consumer;
    }
    
    public Consumer processHystrix_Get(@PathVariable("id") Long id) {
        return new Consumer().setConsumer_no(id).setCname("this ID：" + id + " no such information,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
     
}
