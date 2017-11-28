package com.galley.larder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class LarderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LarderApplication.class, args);
	}
}
