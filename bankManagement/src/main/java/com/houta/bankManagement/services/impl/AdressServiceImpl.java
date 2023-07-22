package com.houta.bankManagement.services.impl;

import com.houta.bankManagement.dto.AccountDto;
import com.houta.bankManagement.dto.AdressDto;
import com.houta.bankManagement.models.Adress;
import com.houta.bankManagement.services.AdressService;
import com.houta.bankManagement.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdressServiceImpl  implements AdressService {

    private final AdressRepository repository ;

    private final ObjectsValidator<AccountDto> validator;
    @Override
    public Integer save(AdressDto dto) {
        validator.validate(dto);
        Adress adress = AdressDto.toEntity(dto);
        return repository.save(adress).getId();
    }

    @Override
    public List<AdressDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AdressDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AdressDto findById(Integer id) {
        return repository.findById(id)
                .map(AdressDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Adress found with this id"+id))
    }

    @Override
    public void delete(Integer id) {
        // check before delete
        repository.deleteById(id);

    }
}
