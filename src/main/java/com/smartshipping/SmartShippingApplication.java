package com.smartshipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SmartShippingApplication {
	public static void main(String[] args) {
		SpringApplication.run(SmartShippingApplication.class, args);
	}
}
