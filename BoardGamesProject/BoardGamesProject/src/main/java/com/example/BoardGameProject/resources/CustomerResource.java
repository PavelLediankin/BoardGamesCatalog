package com.example.BoardGameProject.resources;

import com.example.BoardGameProject.models.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class CustomerResource extends ResourceSupport
{
    @JsonProperty
    public long id;
    public final String firstName;
    public final String lastName;
    public final  String address;

    public CustomerResource(Customer model){
        id = model.getId();
        firstName = model.getFirstName();
        lastName = model.getLastName();
        address = model.getAddress();
    }
}
