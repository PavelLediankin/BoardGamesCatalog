package com.example.BoardGameProject.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "producers")
public class Producer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String producerName;

    @OneToMany(mappedBy = "producer")
    private List<Game> games;

    public Producer(String producerName)
    {
        this.producerName = producerName;
    }

    public long getId()
    {
        return id;
    }

    public String getProducerName()
    {
        return producerName;
    }

    public void setProducerName(String producerName)
    {
        this.producerName = producerName;
    }

    public List<Game> getGames()
    {
        return games;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Producer producer = (Producer) o;
        return Objects.equals(producerName, producer.producerName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(producerName);
    }
}
