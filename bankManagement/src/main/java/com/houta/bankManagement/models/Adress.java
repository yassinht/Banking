package com.houta.bankManagement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Adress extends AbstractEntity {

    private String street;

    private Integer houseNumber;

    private Integer zipCode;

    private  String city;

    private  String country;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
