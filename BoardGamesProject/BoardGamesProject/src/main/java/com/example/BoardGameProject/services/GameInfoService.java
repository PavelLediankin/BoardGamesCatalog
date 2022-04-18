package com.example.BoardGameProject.services;

import com.example.BoardGameProject.models.Game;
import com.example.BoardGameProject.models.GameCategory;
import com.example.BoardGameProject.repositories.GameCategoriesRepository;
import com.example.BoardGameProject.repositories.GamesRepository;
import com.example.BoardGameProject.repositories.ProducersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameInfoService
{
    @Autowired
    GamesRepository gamesRepository;

    @Autowired
    ProducersRepository producersRepository;

    @Autowired
    GameCategoriesRepository categoriesRepository;

    public void addGame(String name, String description, long producerId, long categoryId)
    {
        var producer = producersRepository.findById(producerId).get();
        var category = categoriesRepository.findById(categoryId).get();
        var game = new Game(name, description, producer, category);
        gamesRepository.save(game);
    }

    public void addCategory(String categoryName)
    {
        var category = new GameCategory(categoryName);
        categoriesRepository.save(category);
    }

    public void removeGame(long id)
    {
        gamesRepository.deleteById(id);
    }

    public void removeCategory(long id)
    {
        categoriesRepository.deleteById(id);
    }
}
