package com.example.BoardGameProject.resources;

import com.example.BoardGameProject.models.Game;
import com.example.BoardGameProject.models.GameCategory;
import com.example.BoardGameProject.models.Producer;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

public class GameResource extends RepresentationModel<GameResource>
{
    @JsonProperty
    public long id;
    public String name;
    public String description;
    public Producer producer;
    public GameCategory category;

    public GameResource(Game model){
        id = model.getId();
        name = model.getName();
        description = model.getDescription();
        producer = model.getProducer();
        category = model.getCategory();
    }
}
