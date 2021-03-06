package com.example.BoardGameProject.services;

import com.example.BoardGameProject.models.GamesInStore;
import com.example.BoardGameProject.models.Store;
import com.example.BoardGameProject.repositories.GamesRepository;
import com.example.BoardGameProject.repositories.StoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class GameStoreService
{
    @Autowired
    GamesRepository gamesRepository;

    @Autowired
    StoresRepository storesRepository;

    public Store addStore(Store store)
    {
        return storesRepository.save(store);
    }

    public Store editStore(long id, Store store)
    {
        var oldStore = storesRepository.getById(id);
        if (store.getStoreName() != null)
        {
            oldStore.setStoreName(store.getAddress());
            return storesRepository.save(oldStore);
        }
        return oldStore;
    }

    public Store getStore(long id)
    {
        return storesRepository.getById(id);
    }

    public List<Store> getStores()
    {
        return storesRepository.findAll();
    }

    public void removeStore(long id)
    {
        storesRepository.deleteById(id);
    }


    public GamesInStore addGamesInStore(long gameId, long storeId, int count) throws Exception
    {
        return addGamesInStore(gameId, storeId, count, -1);
    }
    
    public GamesInStore removeGamesInStore(long gameId, long storeId, int count) throws Exception
    {
        return removeGamesInStore(gameId, storeId, count, -1);
    }

    public GamesInStore addGamesInStore(long gameId, long storeId, int count, float price) throws Exception
    {
        return changeGamesCountInStore(true, gameId, storeId, count, price);
    }

    public GamesInStore removeGamesInStore(long gameId, long storeId, int count, float price) throws Exception
    {
        return changeGamesCountInStore(false, gameId, storeId, count, price);
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
    private GamesInStore changeGamesCountInStore(boolean addGames, long gameId, long storeId, int count, float price)
            throws Exception
    {
        var game = gamesRepository.findById(gameId).get();
        var store = storesRepository.findById(storeId).get();
        var games = store.getGames();

        var stored = games.getOrDefault(game, null);
        if (stored == null)
        {
            if (!addGames)
                throw new Exception("No games in that store");
            if (price < 0)
                price = 0;
            store.addGame(game, count, price);
            stored = games.get(game);
        }
        else
        {
            if (price < 0)
                price = stored.getPrice();
            if (addGames)
                stored.addCount(count);
            else
                stored.removeCount(count);
            stored.setPrice(price);
        }
        storesRepository.save(store);
        return stored;
    }
}
