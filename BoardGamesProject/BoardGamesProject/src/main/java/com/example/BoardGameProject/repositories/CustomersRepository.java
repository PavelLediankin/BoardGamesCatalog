package com.example.BoardGameProject.repositories;

import com.example.BoardGameProject.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long>
{

}
