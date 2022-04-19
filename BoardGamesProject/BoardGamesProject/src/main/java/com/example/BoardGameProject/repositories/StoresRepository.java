package com.example.BoardGameProject.repositories;

import com.example.BoardGameProject.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoresRepository extends JpaRepository<Store, Long>
{

}
