package com.shop.demoshop.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Products")
public class Product implements Comparable<Product>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return product.subscribers.size() - this.subscribers.size();
    }
}
