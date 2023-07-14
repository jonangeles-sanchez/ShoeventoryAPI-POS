package com.shoeventory.posapi.services;

import com.shoeventory.posapi.DAOs.TransactionDao;
import com.shoeventory.posapi.DTOs.TransactionDto;
import com.shoeventory.posapi.DTOs.TransactionDtoMapper;
import com.shoeventory.posapi.domain.Transaction;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {

    private final TransactionDao transactionDao;
    private final TransactionDtoMapper transactionDtoMapper;

    public TransactionService(TransactionDao transactionDao, TransactionDtoMapper transactionDtoMapper) {
        this.transactionDao = transactionDao;
        this.transactionDtoMapper = transactionDtoMapper;
    }

    public void createTransaction(TransactionDto req) {
        System.out.println("merchantId: " + req.merchantId());
        System.out.println("transactionTime: " + req.transactionTime());
        Transaction newTransaction = new Transaction(
                req.merchantId(),
                req.transactionTime()
        );
        System.out.println("In TransactionService");
        transactionDao.createTransaction(newTransaction);
    }

}
