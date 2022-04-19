package com.example.BoardGameProject.repositories;

import com.example.BoardGameProject.models.GameCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameCategoriesRepository extends JpaRepository<GameCategory, Long>
{

}
