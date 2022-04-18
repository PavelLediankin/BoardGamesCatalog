package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.models.GameCategory;
import com.example.BoardGameProject.resources.CategoryResource;
import com.example.BoardGameProject.services.GameInfoService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController extends CoreController
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
    public List<CategoryResource> index()
    {
        throw new NotYetImplementedException();
    }

    @GetMapping("/{id}")
    public CategoryResource view(@PathVariable("id") long id)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping
    public GameCategory create(@RequestBody GameCategory category)
    {
        throw new NotYetImplementedException();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        throw new NotYetImplementedException();
    }

}

