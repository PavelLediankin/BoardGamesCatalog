package com.example.BoardGameProject.repositories;

import com.example.BoardGameProject.models.Customer;
import com.example.BoardGameProject.models.RoleSystem.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long>
{

}
