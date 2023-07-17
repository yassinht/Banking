package com.houta.bankManagement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Account extends AbstractEntity{

    private String iban;

    private LocalDateTime creationDate;

    private  LocalDateTime lastUpdated;


    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
