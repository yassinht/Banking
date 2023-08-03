package com.houta.bankManagement.repositories;

import com.houta.bankManagement.models.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
