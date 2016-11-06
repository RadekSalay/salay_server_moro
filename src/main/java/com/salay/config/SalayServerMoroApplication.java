package com.salay.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.salay")
public class SalayServerMoroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalayServerMoroApplication.class, args);
	}
}
