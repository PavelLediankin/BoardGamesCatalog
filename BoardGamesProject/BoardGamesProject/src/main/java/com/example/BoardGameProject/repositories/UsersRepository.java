package com.example.BoardGameProject.repositories;

import com.example.BoardGameProject.models.Customer;
import com.example.BoardGameProject.models.RoleSystem.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
