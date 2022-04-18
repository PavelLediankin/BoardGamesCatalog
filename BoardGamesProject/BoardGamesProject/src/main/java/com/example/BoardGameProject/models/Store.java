package com.example.BoardGameProject.models;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "stores")
public class Store
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String storeName;

    @Column
    private final String address;

    @OneToMany(mappedBy = "store")
    private Map<Game, GamesInStore> games;

    public Store(String storeName, String address)
    {
        this.storeName = storeName;
        this.address = address;
    }

    public long getId()
    {
        return id;
    }

    public String getStoreName()
    {
        return storeName;
    }

    public void setStoreName(String storeName)
    {
        this.storeName = storeName;
    }

    public String getAddress()
    {
        return address;
    }

    public Map<Game, GamesInStore> getGames()
    {
        return games;
    }

    public void addGame(Game game, int count, float price)
    {
        games.put(game, new GamesInStore(game, this, price, count));
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Store store = (Store) o;
        return Objects.equals(storeName, store.storeName) && Objects.equals(address, store.address);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(storeName, address);
    }


}
