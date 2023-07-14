package com.shoeventory.posapi.DAOs;

import com.shoeventory.posapi.domain.Transaction;

public interface TransactionDao {
    void createTransaction(Transaction transaction);
}
