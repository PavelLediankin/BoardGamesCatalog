package com.example.BoardGameProject.resources;

import com.example.BoardGameProject.models.GameCategory;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

public class CategoryResource extends RepresentationModel<CategoryResource>
{
    @JsonProperty
    public long id;
    public final String category;

    public CategoryResource(GameCategory model){
        id = model.getId();
        category = model.getCategory();
    }
}
