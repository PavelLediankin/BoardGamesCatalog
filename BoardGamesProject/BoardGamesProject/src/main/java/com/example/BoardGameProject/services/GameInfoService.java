package com.example.BoardGameProject.services;

import com.example.BoardGameProject.models.Game;
import com.example.BoardGameProject.models.GameCategory;
import com.example.BoardGameProject.models.Producer;
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
        var producer = producersRepository.getById(producerId);
        var category = categoriesRepository.getById(categoryId);
        var game = new Game(name, description, producer, category);
        gamesRepository.save(game);
    }

    public void editGame(long id, Game game)
    {
        var oldGame = gamesRepository.getById(id);
        if(game.getDescription() != null)
        {
            oldGame.setDescription(game.getDescription());
            gamesRepository.save(game);
        }
    }

    public Game getGame(long id)
    {
        return gamesRepository.getById(id);
    }

    public void removeGame(long id)
    {
        gamesRepository.deleteById(id);
    }


    public void addCategory(String categoryName)
    {
        var category = new GameCategory(categoryName);
        categoriesRepository.save(category);
    }

    public GameCategory getCategory(long id)
    {
        return categoriesRepository.getById(id);
    }

    public void removeCategory(long id)
    {
        categoriesRepository.deleteById(id);
    }


    public void addProducer(String producerName)
    {
        var producer = new Producer(producerName);
        producersRepository.save(producer);
    }

    public Producer getProducer(long id)
    {
        return producersRepository.getById(id);
    }

    public void removeProducer(long id)
    {
        producersRepository.deleteById(id);
    }
}
