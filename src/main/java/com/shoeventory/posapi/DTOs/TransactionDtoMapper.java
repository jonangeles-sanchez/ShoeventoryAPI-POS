package com.shoeventory.posapi.DTOs;

import com.shoeventory.posapi.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TransactionDtoMapper implements Function<Transaction, TransactionDto> {

    private final ShoeDtoMapper shoeDtoMapper;

    public TransactionDtoMapper(ShoeDtoMapper shoeDtoMapper) {
        this.shoeDtoMapper = shoeDtoMapper;
    }

    @Override
    public TransactionDto apply(Transaction transaction) {
        List<ShoeDto> shoeDtos = transaction.getShoes()
                .stream()
                .map(shoeDtoMapper::mapToDto)
                .collect(Collectors.toList());

        return new TransactionDto(
                transaction.getId(),
                transaction.getMerchantId(),
                transaction.getTransactionTime(),
                shoeDtos
        );
    }
}