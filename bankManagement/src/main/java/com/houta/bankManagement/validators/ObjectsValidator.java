package com.houta.bankManagement.validators;

import com.houta.bankManagement.exceptions.ObjectValidationException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectsValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator =factory.getValidator();
    public void validate(T objectTovalidate){
        Set<ConstraintViolation<T>> violations = validator.validate(objectTovalidate);
        if (!violations.isEmpty()){
            Set<String> errorMessage= violations.stream()
                    .map(violation -> violation.getMessage())
                    .collect(Collectors.toSet());
       throw new ObjectValidationException(errorMessage,objectTovalidate.getClass().getName());
        }
    }
}
