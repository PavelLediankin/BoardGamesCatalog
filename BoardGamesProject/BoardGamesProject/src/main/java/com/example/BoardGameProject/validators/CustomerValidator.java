package com.example.BoardGameProject.validators;

import com.example.BoardGameProject.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator
{
    @Autowired
    ValidatorHelper helper;

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        var customer = (Customer) target;
        helper.validateString("firstName", customer.getFirstName(), errors);
        helper.validateString("lastName", customer.getLastName(), errors);
        helper.validateString("address", customer.getAddress(), errors);
    }
}
