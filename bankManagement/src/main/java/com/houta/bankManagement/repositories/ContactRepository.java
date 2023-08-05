package com.houta.bankManagement.repositories;

import com.houta.bankManagement.dto.ContactDto;
import com.houta.bankManagement.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact ,Integer> {
    List<Contact> findAllByUserId(Integer userId);
}
