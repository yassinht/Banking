package com.houta.bankManagement.dto;

import com.houta.bankManagement.models.Account;
import com.houta.bankManagement.models.Adress;
import com.houta.bankManagement.models.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdressDto {

    private Integer id;

    private String street;

    private Integer houseNumber;

    private Integer zipCode;

    private  String city;

    private  String country;

    private Integer userId;

    public static AdressDto fromEntity(Adress adress){
        //null check
        return AdressDto.builder()
                .id(adress.getId())
                .street(adress.getStreet())
                .houseNumber(adress.getHouseNumber())
                .zipCode(adress.getZipCode())
                .city(adress.getCity())
                .city(adress.getCity())
                .userId(adress.getUser().getId())
                .build();

    }

    public static Adress toEntity(AdressDto adress){
        return Adress.builder()
                .id(adress.getId())
                .street(adress.getStreet())
                .houseNumber(adress.getHouseNumber())
                .zipCode(adress.getZipCode())
                .city(adress.getCity())
                .city(adress.getCity())
                .user(
                        User.builder()
                                .id(adress.getUserId()).
                                build()
                )

                .build();
    }
}
