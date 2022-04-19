package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.models.Customer;
import com.example.BoardGameProject.resources.CustomerResource;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController extends CoreController
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
    public List<CustomerResource> index()
    {
        throw new NotYetImplementedException();
    }

    @GetMapping("/{id}")
    public CustomerResource view(@PathVariable("id") long id)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping("/{id}")
    public Customer edit(@PathVariable("id") long id, @RequestBody Customer customer)
    {
        throw new NotYetImplementedException();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        throw new NotYetImplementedException();
    }
}

