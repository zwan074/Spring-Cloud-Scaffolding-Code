package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enitities.Consumer;
import com.example.demo.enitities.service.ConsumerClientService;

@RestController
public class ConsumerController_FeignClientProducer {
	@Autowired
    private ConsumerClientService service;

	@GetMapping(path = "consumer/get/{id}")
    public Consumer get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }

	@GetMapping(path = "consumer/list")
    public List<Consumer> list() {
        return this.service.list();
    }

	@PostMapping(path = "consumer/add")
    public Object add(Consumer consumer) {
        return this.service.add(consumer);
    }

}
