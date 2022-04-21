package com.example.BoardGameProject.validators;

import com.example.BoardGameProject.RequestBodies.ChangeGamesCountInStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ChangeGamesCountValidator implements Validator
{
    @Autowired
    GameValidator gameValidator;

    @Autowired
    StoreValidator storeValidator;

    @Override
    public boolean supports(Class<?> clazz)
    {
        return ChangeGamesCountInStore.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        var request = (ChangeGamesCountInStore) target;
        if (request.count < 0)
            errors.rejectValue("count", "negative.value");
        gameValidator.validate(request.game, errors);
        storeValidator.validate(request.store, errors);
    }
}
