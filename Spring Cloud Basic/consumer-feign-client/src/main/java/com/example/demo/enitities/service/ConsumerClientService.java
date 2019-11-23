package com.example.demo.enitities.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.enitities.Consumer;

@FeignClient(value = "microservicecloud-consumer", fallbackFactory = ConsumerClientServiceFallbackFactory.class)
public interface ConsumerClientService {
	// 采用Feign我们就可以使用SpringMVC的注解来对服务进行绑定！
    @GetMapping(path = "consumer/get/{id}")
    public Consumer get(@PathVariable("id") Long id);

    @GetMapping(path = "consumer/list")
    public List<Consumer> list();

    @PostMapping(path = "consumer/add")
    public boolean add(Consumer consumer);
	

}
