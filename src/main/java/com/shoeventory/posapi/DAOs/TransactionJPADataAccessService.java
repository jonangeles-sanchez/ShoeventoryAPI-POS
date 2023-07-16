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

    @Override
    public void updateTransaction(Transaction transaction) {
        Long id = transaction.getId();

        if(id == null) {
            throw new IllegalStateException("Transaction id is null");
        }

        Transaction transactionToUpdate = transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Transaction with id " + id + " does not exist"));

        if(transaction.getMerchantId() != null) {
            transactionToUpdate.setMerchantId(transaction.getMerchantId());
        }

        if(transaction.getTransactionTime() != null){
            transactionToUpdate.setTransactionTime(transaction.getTransactionTime());
        }

        if(transaction.getShoes() != null) {
            transactionToUpdate.setShoes(transaction.getShoes());
        }

        transactionRepository.save(transactionToUpdate);

    }
}
