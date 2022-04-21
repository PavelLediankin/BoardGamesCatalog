package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.models.Game;
import com.example.BoardGameProject.resources.GameResource;
import com.example.BoardGameProject.services.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController extends CoreController
{
    @Autowired
    GameInfoService gameInfoService;

    @Autowired
    Validator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.addValidators(validator);
    }

    @GetMapping
    public List<GameResource> index()
    {
        var list = gameInfoService.getGames();

        var resources = new ArrayList<GameResource>();
        list.forEach(game -> {
            var resource = new GameResource(game);
            resource.add(createHateoasLink(game.getId()));
            resources.add(resource);
        });

        return resources;
    }

    @GetMapping("/{id}")
    public GameResource view(@PathVariable("id") long id)
    {
        var game = gameInfoService.getGame(id);

        var resource = new GameResource(game);
        resource.add(createHateoasLink(game.getId()));
        return resource;
    }

    @PostMapping
    public Game create(@RequestBody @Valid Game game)
    {
        return gameInfoService.addGame(game);
    }

    @PostMapping("/{id}")
    public Game edit(@PathVariable("id") long id, @RequestBody @Valid Game game)
    {
        return gameInfoService.editGame(id, game);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        gameInfoService.removeGames(id);
        return "Ok";
    }
}

