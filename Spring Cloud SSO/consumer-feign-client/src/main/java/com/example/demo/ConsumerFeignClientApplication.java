package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.ConfigurationBean.ConfigBean;

import feign.Logger;


@EnableDiscoveryClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = ConfigBean.class)
@SpringBootApplication
@EnableCircuitBreaker
public class ConsumerFeignClientApplication {

	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignClientApplication.class, args);
	}

}
