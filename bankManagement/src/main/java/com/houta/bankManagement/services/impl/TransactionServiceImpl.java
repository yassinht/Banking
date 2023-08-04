package com.houta.bankManagement.services.impl;

import com.houta.bankManagement.dto.TransactionDto;
import com.houta.bankManagement.models.Transaction;
import com.houta.bankManagement.models.TransactionType;
import com.houta.bankManagement.repositories.TransactionRepository;
import com.houta.bankManagement.services.TransactionService;
import com.houta.bankManagement.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

   private final TransactionRepository repository;
   private final ObjectsValidator<TransactionDto> validator;


    @Override

    public Integer save(TransactionDto dto) {
        validator.validate(dto);
        Transaction transaction = TransactionDto.toEntity(dto);
        BigDecimal transactionMultiplier = BigDecimal.valueOf(getTransactionMultiplaier(transaction.getType()));
        BigDecimal amount = transaction.getAmount().multiply(transactionMultiplier);
        transaction.setAmount(amount);
        return repository.save(transaction).getId() ;    }

    @Override
    public List<TransactionDto> findAll() {

        return repository.findAll()
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto findById(Integer id) {

        return repository.findById(id)
                .map(TransactionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No transaction was found with ID"+id));
    }

    @Override
    public void delete(Integer id) {
 // todo check delete
        repository.deleteById(id);

    }

    private  int getTransactionMultiplaier(TransactionType type){
        return TransactionType.TRANSFERT == type ? -1 : 1;
    }
}
