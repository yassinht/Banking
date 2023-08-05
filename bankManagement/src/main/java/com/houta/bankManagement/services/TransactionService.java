package com.houta.bankManagement.services;

import com.houta.bankManagement.dto.TransactionDto;
import com.houta.bankManagement.models.Transaction;

import java.util.List;

public interface TransactionService extends AbstractService<TransactionDto>{

    List<TransactionDto> findAllByUserId(Integer userId);
}
