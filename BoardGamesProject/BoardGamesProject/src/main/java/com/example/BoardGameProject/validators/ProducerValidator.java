package com.example.BoardGameProject.validators;

import com.example.BoardGameProject.models.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProducerValidator implements Validator
{
    @Autowired
    ValidatorHelper helper;

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Producer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        var producer = (Producer) target;
        helper.validateString("producerName", producer.getProducerName(), errors);
    }
}
