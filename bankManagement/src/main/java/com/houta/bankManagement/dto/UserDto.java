package com.houta.bankManagement.dto;

import com.houta.bankManagement.models.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {




    private Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;


    public static UserDto fromEntity(User user){
     //null check
     return UserDto.builder()
             .firstname(user.getFirstname())
             .lastname(user.getLastname())
             .email(user.getEmail())
             .password(user.getPassword())
             .build();

    }

    public static User toEntity(UserDto user) {
        return User.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }


}
