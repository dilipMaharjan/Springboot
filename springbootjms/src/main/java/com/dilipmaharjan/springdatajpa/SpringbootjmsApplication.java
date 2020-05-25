package com.dilipmaharjan.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringbootjmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjmsApplication.class, args);
	}

}
