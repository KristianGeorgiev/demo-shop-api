package com.shop.demoshop.repositories;

import com.shop.demoshop.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
    List<Subscriber> findByProducts_Id(int id);
}
