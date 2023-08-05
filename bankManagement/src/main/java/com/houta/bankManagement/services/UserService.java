package com.houta.bankManagement.services;

import com.houta.bankManagement.dto.UserDto;

public interface UserService  extends AbstractService<UserDto>{


    Integer validateAccount(Integer id);

    Integer invalidateAccount(Integer id);
}
