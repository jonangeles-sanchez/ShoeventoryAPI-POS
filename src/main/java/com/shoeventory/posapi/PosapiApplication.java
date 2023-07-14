package com.shoeventory.posapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.shoeventory.posapi.DAOs",
		"com.shoeventory.posapi.controllers",
		"com.shoeventory.posapi.services",
		"com.shoeventory.posapi.repositories",
		"com.shoeventory.posapi",
		"com.shoeventory.posapi.DTOs"})
public class PosapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosapiApplication.class, args);
	}

}
