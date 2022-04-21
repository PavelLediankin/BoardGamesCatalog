package com.example.BoardGameProject.validators;

import com.example.BoardGameProject.models.GameCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CategoryValidator implements Validator
{
    @Autowired
    ValidatorHelper helper;

    @Override
    public boolean supports(Class<?> clazz)
    {
        return GameCategory.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        var category = (GameCategory)target;
        helper.validateString("category", category.getCategory(), errors);
    }
}
