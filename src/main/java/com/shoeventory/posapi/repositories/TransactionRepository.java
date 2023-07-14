package com.shoeventory.posapi.repositories;

import com.shoeventory.posapi.domain.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}