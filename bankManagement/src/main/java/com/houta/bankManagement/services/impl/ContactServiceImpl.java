package com.houta.bankManagement.services.impl;


import com.houta.bankManagement.dto.ContactDto;
import com.houta.bankManagement.models.Contact;
import com.houta.bankManagement.repositories.ContactRepository;
import com.houta.bankManagement.services.ContactService;
import com.houta.bankManagement.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository repository;

    private final ObjectsValidator<ContactDto> validator;

    @Override
    public Integer save(ContactDto dto) {
        validator.validate(dto);
        Contact contact = ContactDto.toEntity(dto);
        return repository.save(contact).getId();
    }

    @Override
    public List<ContactDto> findAll() {
        return  repository.findAll()
                .stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Integer id) {
        return  repository.findById(id)
                .map(ContactDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("no contact was found with this id : "+id));
    }

    @Override
    public void delete(Integer id) {
        //todo check delete
        repository.deleteById(id);

    }
}
