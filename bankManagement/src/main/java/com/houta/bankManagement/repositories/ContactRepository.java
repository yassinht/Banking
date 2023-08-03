package com.houta.bankManagement.repositories;

import com.houta.bankManagement.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact ,Integer> {
}
