package com.houta.bankManagement.repositories;

import com.houta.bankManagement.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository  extends JpaRepository<Account,Integer> {
    Optional<Account> finByIban(String iban);

    Optional<Account> findByUserId(Integer id);
}
