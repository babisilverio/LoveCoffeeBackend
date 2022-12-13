package com.coffee.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LoveCoffeeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveCoffeeBackendApplication.class, args);
	}

}
