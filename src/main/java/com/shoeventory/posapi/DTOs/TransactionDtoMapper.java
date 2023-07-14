package com.shoeventory.posapi.DTOs;

import com.shoeventory.posapi.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TransactionDtoMapper implements Function<Transaction, TransactionDto> {

    @Override
    public TransactionDto apply(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getMerchantId(),
                transaction.getTransactionTime()
        );
    }
}
