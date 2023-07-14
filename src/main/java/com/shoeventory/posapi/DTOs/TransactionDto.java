package com.shoeventory.posapi.DTOs;

import java.time.LocalDateTime;

public record TransactionDto(
        Long id,
        Long merchantId,
        String transactionTime
) {
}
