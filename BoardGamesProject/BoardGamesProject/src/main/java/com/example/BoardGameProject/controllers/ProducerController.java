package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.models.Producer;
import com.example.BoardGameProject.resources.ProducerResource;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/producer")
public class ProducerController extends CoreController
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
    public List<ProducerResource> index()
    {
        throw new NotYetImplementedException();
    }

    @GetMapping("/{id}")
    public ProducerResource view(@PathVariable("id") long id)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping
    public Producer create(@RequestBody @Valid Producer producer)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping(value = "/{id}")
    public Producer edit(@PathVariable("id") long id, @RequestBody @Valid Producer producer)
    {
        throw new NotYetImplementedException();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        throw new NotYetImplementedException();
    }
}

