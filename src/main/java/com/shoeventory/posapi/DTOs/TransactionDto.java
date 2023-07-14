package com.shoeventory.posapi.DTOs;

import com.shoeventory.posapi.domain.Shoe;

import java.time.LocalDateTime;
import java.util.List;

public record TransactionDto(
        Long id,
        Long merchantId,
        String transactionTime,
        List<ShoeDto> shoes
) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransactionDto[id=").append(id())
                .append(", merchantId=").append(merchantId())
                .append(", transactionTime=").append(transactionTime());
        if (shoes() != null) {
            sb.append(", shoes=").append(shoes());
        }
        sb.append("]");
        return sb.toString();
    }
}