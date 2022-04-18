package com.example.BoardGameProject.models;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "games")
public class Game
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private final String name;

    @Column()
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "producer_id")
    private final Producer producer;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "category_id")
    private final GameCategory category;

    @OneToMany(mappedBy = "game")
    private Map<Store , GamesInStore> gamesInStores;

    public Game(String name, Producer producer, GameCategory category)
    {
        this(name, "Empty description", producer, category);
    }

    public Game(String name, String description, Producer producer, GameCategory category)
    {
        this.name = name;
        this.description = description;
        this.producer = producer;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public GameCategory getCategory()
    {
        return category;
    }

    public Map<Store, GamesInStore> getGamesInStores()
    {
        return gamesInStores;
    }

    public Producer getProducer()
    {
        return producer;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Game game = (Game) o;
        return Objects.equals(name, game.name) && Objects.equals(producer, game.producer);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, producer);
    }
}
