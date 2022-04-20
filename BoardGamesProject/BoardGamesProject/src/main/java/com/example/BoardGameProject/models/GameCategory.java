package com.example.BoardGameProject.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game_categories")
public class GameCategory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private final String category;

    @OneToMany(mappedBy = "category")
    private List<Game> games;

    public GameCategory(String category)
    {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getCategory()
    {
        return category;
    }

    public List<Game> getGames()
    {
        return games;
    }
}
