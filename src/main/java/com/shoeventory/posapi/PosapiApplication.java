package com.shoeventory.posapi;

import com.shoeventory.posapi.models.Shoe;
import com.shoeventory.posapi.models.Transaction;
import java.util.Set;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.shoeventory.posapi.DAOs")
public class PosapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosapiApplication.class, args);
	}

}
