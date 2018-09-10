package com.example.mvc.springwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.mvc.springwebapp.model")

public class SpringwebappApplication {

	public static void main(String[] args) {
        System.out.println("@@ SpringwebappApplication::main() @@");
        SpringApplication.run(SpringwebappApplication.class, args);
	}
}
