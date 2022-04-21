package com.example.BoardGameProject.validators;

import com.example.BoardGameProject.models.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StoreValidator implements Validator
{
    @Autowired
    ValidatorHelper helper;

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Store.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        var store = (Store) target;
        helper.validateString("storeName", store.getStoreName(), errors);
        helper.validateString("address", store.getAddress(), errors);
    }
}
