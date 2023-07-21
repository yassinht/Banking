package com.houta.bankManagement.services.impl;

import com.houta.bankManagement.dto.AccountDto;
import com.houta.bankManagement.exceptions.OperationNonPermittedException;
import com.houta.bankManagement.models.Account;
import com.houta.bankManagement.repositories.AccountRepository;
import com.houta.bankManagement.services.AccountService;
import com.houta.bankManagement.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private  final AccountRepository repository;

    private final ObjectsValidator<AccountDto> validator;

    @Override
    public Integer save(AccountDto dto) {
        //block account update -> iban cant be change
        if(dto.getId() != null){
            throw new OperationNonPermittedException(
                    "Account can't updated",
                    "save account",
                    "account",
                    "update not permitted");
        }
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        // generate random IBAN
        account.setIban(generateRandomIban());
        return repository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
      return   repository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public AccountDto findById(Integer id) {
        return repository.findById(id)
                .map(AccountDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException("no account was found with id "+id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);

    }

    private String generateRandomIban(){
        //todo generate Iban
      String iban= Iban.random(CountryCode.TN).toFormattedString();
        //check if this Iban exist
         boolean ibanExist = repository.finByIban(iban)
               .isPresent();
        //generate new random Iban
       if(ibanExist){
           generateRandomIban();
        }
        //if not return generated Iban

        return iban;
    }
}
