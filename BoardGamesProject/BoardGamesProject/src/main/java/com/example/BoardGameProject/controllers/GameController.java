package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.models.Game;
import com.example.BoardGameProject.resources.GameResource;
import com.example.BoardGameProject.services.GameInfoService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController extends CoreController
{
    @Autowired
    GameInfoService gameInfoService;
/*
    @Autowired
    Validator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(validator);
    }
*/
    @GetMapping
    public List<GameResource> index()
    {
        throw new NotYetImplementedException();
    }

    @GetMapping("/{id}")
    public GameResource view(@PathVariable("id") long id)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping
    public Game create(@RequestBody Game game)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping("/{id}")
    public Game edit(@PathVariable("id") long id, @RequestBody Game game)
    {
        throw new NotYetImplementedException();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        throw new NotYetImplementedException();
    }
}

