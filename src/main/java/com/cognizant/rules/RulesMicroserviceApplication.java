package com.cognizant.rules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableEurekaClient
@EnableFeignClients
@EnableAspectJAutoProxy
@SpringBootApplication
public class RulesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RulesMicroserviceApplication.class, args);
	}

}
