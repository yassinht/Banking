package com.houta.bankManagement.dto;

import com.houta.bankManagement.models.User;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {




    private Integer id;
    @NotNull
    @NotEmpty
    @NotBlank(message = "common.user.error.empty")
    private String firstname;
    @NotNull
    @NotEmpty
    @NotBlank
    private String lastname;
    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 8,max = 16)
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
