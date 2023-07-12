package com.shoeventory.posapi;

import com.shoeventory.posapi.models.Shoe;
import com.shoeventory.posapi.models.Transaction;
import java.util.Set;
import java.util.HashSet;

import com.shoeventory.posapi.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PosapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TransactionRepository transactionRepository) {
		// Create a fake transaction
		Transaction transaction = new Transaction(1, 1234567890, null);
		Set<Shoe> shoes = new HashSet<>();
		shoes.add(new Shoe("Nike", "Air Force 1", "07", "White", "10", 1, 100, transaction));
		shoes.add(new Shoe("Nike", "Dunks", "Panda", "White", "10", 1, 100, transaction));
		transaction.setShoes(shoes);

		return args -> {
			transactionRepository.save(transaction);
		};
	}

}
