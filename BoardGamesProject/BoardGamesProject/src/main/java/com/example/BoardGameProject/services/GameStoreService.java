package com.example.BoardGameProject.services;

import com.example.BoardGameProject.models.GamesInStore;
import com.example.BoardGameProject.models.Store;
import com.example.BoardGameProject.repositories.GamesRepository;
import com.example.BoardGameProject.repositories.StoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class GameStoreService
{
    @Autowired
    GamesRepository gamesRepository;

    @Autowired
    StoresRepository storesRepository;

    public void addStore(String storeName, String address)
    {
        var store = new Store(storeName, address);
        storesRepository.save(store);
    }

    public Store getStore(long id)
    {
        return storesRepository.getById(id);
    }

    public void removeStore(long id)
    {
        storesRepository.deleteById(id);
    }


    public void addGamesInStore(long gameId, long storeId, int count) throws Exception
    {
        addGamesInStore(gameId, storeId, count, -1);
    }

    public void addGamesInStore(long gameId, long storeId, int count, float price) throws Exception
    {
        changeGamesCountInStore(true, gameId, storeId, count, price);
    }

    public void removeGamesInStore(long gameId, long storeId, int count, float price) throws Exception
    {
        changeGamesCountInStore(false, gameId, storeId, count, price);
    }

    public GamesInStore getGamesInStore(long storeId, long gameId)
    {
        var store = storesRepository.getById(storeId);
        var game = gamesRepository.getById(gameId);
        return store.getGames().getOrDefault(game, null);
    }

    public Collection<GamesInStore> getAllGamesInStore(long storeId)
    {
        var store = storesRepository.getById(storeId);
        return store.getGames().values();
    }

    @Transactional
    private void changeGamesCountInStore(boolean addGames, long gameId, long storeId, int count, float price) throws Exception
    {
        var game = gamesRepository.findById(gameId).get();
        var store = storesRepository.findById(storeId).get();
        var games = store.getGames();

        var stored = games.getOrDefault(game, null);
        if (stored == null)
        {
            if(!addGames)
                throw new Exception("No games in that store");
            if(price < 0)
                price = 0;
            store.addGame(game,count,price);
        }
        else
        {
            if(price < 0)
                price = stored.getPrice();
            if(addGames)
                stored.addCount(count);
            else
                stored.removeCount(count);
            stored.setPrice(price);
        }
        storesRepository.save(store);
    }
}
