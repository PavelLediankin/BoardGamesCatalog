package com.example.BoardGameProject.resources;

import com.example.BoardGameProject.models.Game;
import com.example.BoardGameProject.models.Producer;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class ProducerResource extends ResourceSupport
{
    @JsonProperty
    public long id;
    public final String producerName;
    public final List<Game> games;

    public ProducerResource(Producer model){
        id = model.getId();
        producerName = model.getProducerName();
        games = model.getGames();
    }
}
