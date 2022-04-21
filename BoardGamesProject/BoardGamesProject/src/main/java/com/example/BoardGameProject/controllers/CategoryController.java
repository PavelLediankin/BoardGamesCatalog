package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.models.GameCategory;
import com.example.BoardGameProject.resources.CategoryResource;
import com.example.BoardGameProject.services.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController extends CoreController
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
    public List<CategoryResource> index()
    {
        var list = gameInfoService.getCategories();

        var resources = new ArrayList<CategoryResource>();
        list.forEach(category -> {
            var resource = new CategoryResource(category);
            resource.add(createHateoasLink(category.getId()));
            resources.add(resource);
        });

        return resources;
    }

    @GetMapping("/{id}")
    public CategoryResource view(@PathVariable("id") long id)
    {
        var category = gameInfoService.getCategory(id);

        var resource = new CategoryResource(category);
        resource.add(createHateoasLink(category.getId()));
        return resource;
    }

    @PostMapping
    public GameCategory create(@RequestBody @Valid GameCategory category)
    {
        return gameInfoService.addCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        gameInfoService.removeGames(id);
        return "OK";
    }
}

