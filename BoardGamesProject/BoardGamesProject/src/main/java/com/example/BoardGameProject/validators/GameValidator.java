package com.example.BoardGameProject.validators;

import com.example.BoardGameProject.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class GameValidator implements Validator
{
    @Autowired
    ValidatorHelper helper;

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Game.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        var game = (Game) target;
        helper.validateString("name", game.getName(), errors);
        helper.validateString("description", game.getDescription(), 500, errors);
    }
}
