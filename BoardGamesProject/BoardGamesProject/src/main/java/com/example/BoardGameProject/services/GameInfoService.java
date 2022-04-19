package com.example.BoardGameProject.services;

import com.example.BoardGameProject.models.Game;
import com.example.BoardGameProject.models.GameCategory;
import com.example.BoardGameProject.models.Producer;
import com.example.BoardGameProject.repositories.GameCategoriesRepository;
import com.example.BoardGameProject.repositories.GamesRepository;
import com.example.BoardGameProject.repositories.ProducersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameInfoService
{
    @Autowired
    GamesRepository gamesRepository;

    @Autowired
    ProducersRepository producersRepository;

    @Autowired
    GameCategoriesRepository categoriesRepository;

    public Game addGame(Game game)
    {
        return gamesRepository.save(game);
    }

    public Game editGame(long id, Game game)
    {
        var oldGame = gamesRepository.getById(id);
        if(game.getDescription() != null)
        {
            oldGame.setDescription(game.getDescription());
            return gamesRepository.save(oldGame);
        }
        return oldGame;
    }

    public Game getGame(long id)
    {
        return gamesRepository.getById(id);
    }

    public List<Game> getGames()
    {
        return gamesRepository.findAll();
    }

    public void removeGames(long id)
    {
        gamesRepository.deleteById(id);
    }


    public GameCategory addCategory(GameCategory category)
    {
        return categoriesRepository.save(category);
    }

    public GameCategory getCategory(long id)
    {
        return categoriesRepository.getById(id);
    }

    public List<GameCategory> getCategories()
    {
        return categoriesRepository.findAll();
    }

    public void removeCategory(long id)
    {
        categoriesRepository.deleteById(id);
    }


    public Producer addProducer(Producer producer)
    {
        return producersRepository.save(producer);
    }

    public Producer getProducer(long id)
    {
        return producersRepository.getById(id);
    }

    public List<Producer> getProducers()
    {
        return producersRepository.findAll();
    }

    public void removeProducer(long id)
    {
        producersRepository.deleteById(id);
    }
}
