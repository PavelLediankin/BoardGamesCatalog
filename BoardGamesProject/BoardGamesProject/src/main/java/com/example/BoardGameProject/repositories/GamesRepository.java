package com.example.BoardGameProject.repositories;

import com.example.BoardGameProject.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<Game, Long>
{

}
