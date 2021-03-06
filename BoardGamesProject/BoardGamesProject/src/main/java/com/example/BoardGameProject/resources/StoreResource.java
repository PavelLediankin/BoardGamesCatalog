package com.example.BoardGameProject.resources;

import com.example.BoardGameProject.models.Store;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class StoreResource extends RepresentationModel<StoreResource>
{
    @JsonProperty
    public long id;
    public final String storeName;
    public final String address;

    public StoreResource(Store model){
        id = model.getId();
        address = model.getAddress();
        storeName = model.getStoreName();
    }
}
