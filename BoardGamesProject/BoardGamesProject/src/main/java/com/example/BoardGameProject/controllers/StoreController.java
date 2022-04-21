package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.RequestBodies.ChangeGamesCountInStore;
import com.example.BoardGameProject.models.GamesInStore;
import com.example.BoardGameProject.models.Store;
import com.example.BoardGameProject.resources.StoreResource;
import com.example.BoardGameProject.services.GameStoreService;
import com.example.BoardGameProject.validators.ChangeGamesCountValidator;
import com.example.BoardGameProject.validators.StoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController extends CoreController
{
    @Autowired
    GameStoreService gameStoreService;

    @Autowired
    StoreValidator storeValidator;

    @Autowired
    ChangeGamesCountValidator requestValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.addValidators(storeValidator, requestValidator);
    }

    @GetMapping
    public List<StoreResource> index()
    {
        var list = gameStoreService.getStores();

        var resources = new ArrayList<StoreResource>();
        list.forEach(store -> {
            var resource = new StoreResource(store);
            resource.add(createHateoasLink(store.getId()));
            resources.add(resource);
        });

        return resources;
    }

    @GetMapping("/{id}")
    public StoreResource view(@PathVariable("id") long id)
    {
        var store = gameStoreService.getStore(id);

        var resource = new StoreResource(store);
        resource.add(createHateoasLink(store.getId()));
        return resource;
    }

    @PostMapping
    public Store create(@RequestBody @Valid Store store)
    {
        return gameStoreService.addStore(store);
    }

    @PostMapping("/{id}")
    public Store edit(@PathVariable("id") long id, @RequestBody @Valid Store store)
    {
        return gameStoreService.editStore(id, store);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        gameStoreService.removeStore(id);
        return "OK";
    }

    @PostMapping("/add-game")
    public GamesInStore add(@RequestBody @Valid ChangeGamesCountInStore requestBody)
    {
        var gameId = requestBody.game.getId();
        var storeId = requestBody.store.getId();
        try
        {
            return gameStoreService.addGamesInStore(gameId, storeId, requestBody.count);
        }
        catch (Exception e)
        {
            return gameStoreService.getGamesInStore(storeId, gameId);
        }
    }

    @PostMapping("/remove-game")
    public GamesInStore remove(@RequestBody @Valid ChangeGamesCountInStore requestBody)
    {
        var gameId = requestBody.game.getId();
        var storeId = requestBody.store.getId();
        try
        {
            return gameStoreService.removeGamesInStore(gameId, storeId, requestBody.count);
        }
        catch (Exception e)
        {
            return gameStoreService.getGamesInStore(storeId, gameId);
        }
    }
}