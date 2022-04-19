package com.example.BoardGameProject.services;

import com.example.BoardGameProject.models.Customer;
import com.example.BoardGameProject.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService
{
    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    GameStoreService gameStoreService;

    public void addCustomer(String firstName, String lastName, String address)
    {
        var customer = new Customer(firstName, lastName, address);
        customersRepository.save(customer);
    }

    public void editCustomer(long id, Customer customer)
    {
        var oldCustomer = customersRepository.getById(id);
        if(customer.getAddress() != null)
        {
            oldCustomer.setAddress(customer.getAddress());
            customersRepository.save(oldCustomer);
        }
    }

    public Customer getCustomer(long id)
    {
        return customersRepository.getById(id);
    }

    public List<Customer> getCustomers()
    {
        return customersRepository.findAll();
    }

    public void removeCustomer(long id)
    {
        customersRepository.deleteById(id);
    }

    public String getGame(long gameId, long storeId) throws Exception
    {
        //TODO Buy(billing) or quasi-buying

        gameStoreService.removeGamesInStore(gameId, storeId, 1);
        return "OK";
    }
}
