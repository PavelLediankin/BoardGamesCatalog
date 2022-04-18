package com.example.BoardGameProject.repositories;

import com.example.BoardGameProject.models.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducersRepository extends JpaRepository<Producer, Long>
{

}
