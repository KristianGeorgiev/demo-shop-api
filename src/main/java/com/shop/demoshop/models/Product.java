package com.shop.demoshop.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Products")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Product implements Comparable<Product>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "CreationDate", nullable = false)
    private Date creationDate;

    @Column(name = "IsAvailable", nullable = false)
    private boolean isAvailable;

    @ManyToMany
    private Set<Subscriber> subscribers;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public int compareTo(Product product) {
        Set<Subscriber> thisSubscribers = this.subscribers;
        Set<Subscriber> otherSubscribers = product.subscribers;

        if (thisSubscribers != null && otherSubscribers != null) {
            return otherSubscribers.size() - thisSubscribers.size();
        }

        if (thisSubscribers == null && otherSubscribers != null) {
            return 1;
        }

        if (thisSubscribers != null && otherSubscribers == null) {
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        // Returning JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        }
        catch (IOException e) {
            return null;
        }
    }
}
