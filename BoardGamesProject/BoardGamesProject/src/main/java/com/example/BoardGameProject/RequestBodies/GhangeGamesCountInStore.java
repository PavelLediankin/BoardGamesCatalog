package com.example.BoardGameProject.RequestBodies;

import com.example.BoardGameProject.models.Game;
import com.example.BoardGameProject.models.Store;

public class GhangeGamesCountInStore
{
    public Game game;

    public Store store;

    public int count;

    public GhangeGamesCountInStore(Game game, Store store, int count)
    {
        this.game = game;
        this.store = store;
        this.count = count;
    }
}
