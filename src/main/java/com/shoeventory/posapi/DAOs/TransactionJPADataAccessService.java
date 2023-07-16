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
    public void updateTransaction(Transaction newTransaction) {
        Long id = newTransaction.getId();

        if(id == null) {
            throw new IllegalStateException("Transaction id is null");
        }

        Transaction transactionToUpdate = transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Transaction with id " + id + " does not exist"));

        if(newTransaction.getMerchantId() != null) {
            transactionToUpdate.setMerchantId(newTransaction.getMerchantId());
        }

        if(newTransaction.getTransactionTime() != null){
            transactionToUpdate.setTransactionTime(newTransaction.getTransactionTime());
        }

        if(newTransaction.getShoes() != null) {
            transactionRepository.deleteShoesByTransactionId(id);
            transactionToUpdate.setShoes(newTransaction.getShoes());
        }

        transactionRepository.save(transactionToUpdate);

    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Transaction with id " + id + " does not exist"));
    }
}
