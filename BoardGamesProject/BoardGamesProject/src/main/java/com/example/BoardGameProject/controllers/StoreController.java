package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.RequestBodies.GhangeGamesCountInStore;
import com.example.BoardGameProject.models.Game;
import com.example.BoardGameProject.models.Store;
import com.example.BoardGameProject.resources.StoreResource;
import com.example.BoardGameProject.services.GameStoreService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController extends CoreController
{
/*
    @Autowired
    Validator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(validator);
    }
*/

    @GetMapping
    public List<StoreResource> index()
    {
        throw new NotYetImplementedException();
    }

    @GetMapping("/{id}")
    public StoreResource view(@PathVariable("id") long id)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping
    public Store create(@RequestBody Store store)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping("/{id}")
    public Store edit(@PathVariable("id") long id, @RequestBody Store store)
    {
        throw new NotYetImplementedException();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping("/add-game")
    public Game add(@RequestBody GhangeGamesCountInStore requestBody)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping("/remove-game")
    public Game remove(@RequestBody GhangeGamesCountInStore requestBody)
    {
        throw new NotYetImplementedException();
    }
}

