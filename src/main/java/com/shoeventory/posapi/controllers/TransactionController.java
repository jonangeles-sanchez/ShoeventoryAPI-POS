package com.shoeventory.posapi.controllers;

import com.shoeventory.posapi.DTOs.TransactionDto;
import com.shoeventory.posapi.domain.Transaction;
import com.shoeventory.posapi.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createTransaction(
            @RequestBody TransactionDto req) {
        transactionService.createTransaction(req);
        System.out.println("In TransactionController");
        System.out.println("Request: " + req);
        return ResponseEntity.ok().build();
    }

}
