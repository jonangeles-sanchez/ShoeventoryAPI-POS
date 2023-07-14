package com.shoeventory.posapi.DAOs;

import com.shoeventory.posapi.domain.Transaction;
import com.shoeventory.posapi.repositories.TransactionRepository;
import org.springframework.stereotype.Repository;

@Repository("jpa")
public class TransactionJPADataAccessService implements TransactionDao{
    private final TransactionRepository transactionRepository;

    public TransactionJPADataAccessService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
