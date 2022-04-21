package com.example.BoardGameProject.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class ValidatorHelper
{
    public void validateString(String fieldName, String field, Errors errors)
    {
        validateString(fieldName, field, 100, errors);
    }

    public void validateString(String fieldName, String field, int fieldLength, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, fieldName, "field.required");
        var categoryLength = field.length();
        if (categoryLength < 3 || categoryLength > fieldLength)
            errors.rejectValue(fieldName, "invalid.length");
    }
}
