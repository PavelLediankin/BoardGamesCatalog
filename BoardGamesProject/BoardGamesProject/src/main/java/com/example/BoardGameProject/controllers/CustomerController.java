package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.models.Customer;
import com.example.BoardGameProject.resources.CustomerResource;
import com.example.BoardGameProject.services.CustomersService;
import com.example.BoardGameProject.validators.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController extends CoreController
{
    @Autowired
    CustomersService customersService;

    @Autowired
    CustomerValidator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.addValidators(validator);
    }

    @GetMapping
    public List<CustomerResource> index()
    {
        var list = customersService.getCustomers();

        var resources = new ArrayList<CustomerResource>();
        list.forEach(customer -> {
            var resource = new CustomerResource(customer);
            resource.add(createHateoasLink(customer.getId()));
            resources.add(resource);
        });

        return resources;
    }

    @GetMapping("/{id}")
    public CustomerResource view(@PathVariable("id") long id)
    {
        var customer = customersService.getCustomer(id);

        var resource = new CustomerResource(customer);
        resource.add(createHateoasLink(customer.getId()));
        return resource;
    }

    @PostMapping
    public Customer create(@RequestBody @Valid Customer customer)
    {
        return customersService.addCustomer(customer);
    }

    @PostMapping("/{id}")
    public Customer edit(@PathVariable("id") long id, @RequestBody @Valid Customer customer)
    {
        return customersService.editCustomer(id, customer);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        customersService.removeCustomer(id);
        return "OK";
    }
}

