package com.houta.bankManagement.dto;

import com.houta.bankManagement.models.Account;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Integer id;

    private String iban;

    private UserDto user;

    public static AccountDto fromEntity(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(UserDto.fromEntity(account.getUser()))

                .build();
    }


    public static Account toEntity(AccountDto account){
        return Account.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(UserDto.toEntity(account.getUser()))

                .build();
    }
}
