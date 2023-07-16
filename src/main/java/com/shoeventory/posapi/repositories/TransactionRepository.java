package com.shoeventory.posapi.repositories;

import com.shoeventory.posapi.domain.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Modifying
    @Query("DELETE FROM Shoe s WHERE s.transaction.id = :transactionId")
    void deleteShoesByTransactionId(@Param("transactionId") Long transactionId);
}