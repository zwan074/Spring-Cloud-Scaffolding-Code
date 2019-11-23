package com.example.demo.enitities.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.enitities.Consumer;
import feign.hystrix.FallbackFactory;

@Component
public class ConsumerClientServiceFallbackFactory implements FallbackFactory<ConsumerClientService> {

	@Override
	public ConsumerClientService create(Throwable cause) {
		return new ConsumerClientService() {
            @Override
            public Consumer get(Long id) {
                return new Consumer().setConsumer_no(id).setCname("this ID：" + id + "has no such information")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Consumer> list() {
                return null;
            }

            @Override
            public boolean add(Consumer consumer) {
                return false;
            }
        };
	}

}
