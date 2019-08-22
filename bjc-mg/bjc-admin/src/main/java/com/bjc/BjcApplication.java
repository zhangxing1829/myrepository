package com.bjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BjcApplication {

	public static void main(String[] args) {

		SpringApplication.run(BjcApplication.class, args);
		System.out.println("run ok!");
	}
}
