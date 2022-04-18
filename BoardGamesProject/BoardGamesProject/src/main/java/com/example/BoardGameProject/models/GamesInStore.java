package com.example.BoardGameProject.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "games_in_stores")
public class GamesInStore
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "game_id")
    private final Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "store_id")
    private final Store store;

    @Column
    private float price;

    @Column
    private int count;

    public GamesInStore(Game game, Store store, float price, int count)
    {
        this.game = game;
        this.store = store;
        this.price = price;
        this.count = count;
    }

    public long getId()
    {
        return id;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public Game getGame()
    {
        return game;
    }

    public Store getStore()
    {
        return store;
    }

    public int getCount()
    {
        return count;
    }

    public void addCount(int count)
    {
        this.count += count;
    }
    public void removeCount(int count) throws Exception
    {
        if (this.count <= count)
            throw new Exception("You cant remove more games then stored");
        this.count = count;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GamesInStore that = (GamesInStore) o;
        return Objects.equals(game, that.game) && Objects.equals(store, that.store);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(game, store);
    }
}
