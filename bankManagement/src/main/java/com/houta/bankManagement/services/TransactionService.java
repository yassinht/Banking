package com.houta.bankManagement.services;

import com.houta.bankManagement.dto.TransactionDto;
import com.houta.bankManagement.models.Transaction;

public interface TransactionService extends AbstractService<TransactionDto>{
    Integer save(TransactionDto dto);
}
