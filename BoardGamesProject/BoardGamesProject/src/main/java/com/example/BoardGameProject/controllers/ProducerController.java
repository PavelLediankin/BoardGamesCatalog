package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.models.Producer;
import com.example.BoardGameProject.resources.ProducerResource;
import com.example.BoardGameProject.services.GameInfoService;
import com.example.BoardGameProject.validators.ProducerValidator;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producer")
public class ProducerController extends CoreController
{
    @Autowired
    GameInfoService gameInfoService;

    @Autowired
    ProducerValidator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.addValidators(validator);
    }

    @GetMapping
    public List<ProducerResource> index()
    {
        var list = gameInfoService.getProducers();

        var resources = new ArrayList<ProducerResource>();
        list.forEach(producer -> {
            var resource = new ProducerResource(producer);
            resource.add(createHateoasLink(producer.getId()));
            resources.add(resource);
        });

        return resources;
    }

    @GetMapping("/{id}")
    public ProducerResource view(@PathVariable("id") long id)
    {
        var producer = gameInfoService.getProducer(id);

        var resource = new ProducerResource(producer);
        resource.add(createHateoasLink(producer.getId()));
        return resource;
    }

    @PostMapping
    public Producer create(@RequestBody @Valid Producer producer)
    {
        return gameInfoService.addProducer(producer);
    }

    /**
     * This method NOT used now, but it is saved in case of changing in producer editing
     */
    @PostMapping(value = "/{id}")
    public Producer edit(@PathVariable("id") long id, @RequestBody @Valid Producer producer)
    {
        throw new NotYetImplementedException();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        gameInfoService.removeProducer(id);
        return "OK";
    }
}

