package com.houta.bankManagement.services;

import com.houta.bankManagement.dto.ContactDto;

import java.util.List;

public interface ContactService  extends AbstractService<ContactDto>{

List<ContactDto> findAllByUserId(Integer userId);
}
