package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import feign.Logger;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerFeignClientApplication {

	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignClientApplication.class, args);
	}

}
