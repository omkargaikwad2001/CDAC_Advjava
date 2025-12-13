package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class P7SpringBootService2Application {

	public static void main(String[] args) {
		SpringApplication.run(P7SpringBootService2Application.class, args);
	}

}
