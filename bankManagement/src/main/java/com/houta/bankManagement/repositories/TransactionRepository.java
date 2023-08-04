package com.houta.bankManagement.repositories;

import com.houta.bankManagement.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
