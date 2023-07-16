package com.shoeventory.posapi.services;

import com.shoeventory.posapi.DAOs.TransactionDao;
import com.shoeventory.posapi.DTOs.ShoeDto;
import com.shoeventory.posapi.DTOs.TransactionDto;
import com.shoeventory.posapi.DTOs.TransactionDtoMapper;
import com.shoeventory.posapi.domain.Shoe;
import com.shoeventory.posapi.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

        List<Shoe> shoes = new ArrayList<>();
        for (ShoeDto shoeDto : req.shoes()) {
            Shoe shoe = new Shoe(
                    shoeDto.manufacturer(),
                    shoeDto.type(),
                    shoeDto.name(),
                    shoeDto.color(),
                    shoeDto.size(),
                    shoeDto.quantity(),
                    shoeDto.price()
            );
            shoe.setTransaction(newTransaction);
            shoes.add(shoe);
        }

        newTransaction.setShoes(shoes);

        System.out.println("newTransaction: " + newTransaction);
        System.out.println("In TransactionService");
        transactionDao.createTransaction(newTransaction);
    }

    public void updateTransaction(Long id, TransactionDto req) {

        Transaction updatedTransaction = buildTransaction(id, req);

        transactionDao.updateTransaction(updatedTransaction);
    }

    public Transaction buildTransaction(TransactionDto req) {
       Transaction newTransaction = new Transaction(
                req.merchantId(),
                req.transactionTime()
        );

        List<Shoe> shoes = new ArrayList<>();
        for (ShoeDto shoeDto : req.shoes()) {
            Shoe shoe = new Shoe(
                    shoeDto.manufacturer(),
                    shoeDto.type(),
                    shoeDto.name(),
                    shoeDto.color(),
                    shoeDto.size(),
                    shoeDto.quantity(),
                    shoeDto.price()
            );
            shoe.setTransaction(newTransaction);
            shoes.add(shoe);
        }

        newTransaction.setShoes(shoes);

        return newTransaction;
    }

    public Transaction buildTransaction(Long Id, TransactionDto req) {
        System.out.println("TrasanctionId in builder (service): " + Id);
       Transaction newTransaction = new Transaction(
                Id,
                req.merchantId(),
                req.transactionTime(),
                null
        );

       if(req.shoes() == null){
           return newTransaction;
       }
        List<Shoe> shoes = new ArrayList<>();
        for (ShoeDto shoeDto : req.shoes()) {
            Shoe shoe = new Shoe(
                    shoeDto.manufacturer(),
                    shoeDto.type(),
                    shoeDto.name(),
                    shoeDto.color(),
                    shoeDto.size(),
                    shoeDto.quantity(),
                    shoeDto.price()
            );
            shoe.setTransaction(newTransaction);
            shoes.add(shoe);
        }

        newTransaction.setShoes(shoes);

        return newTransaction;
    }
}