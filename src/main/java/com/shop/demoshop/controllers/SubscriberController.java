package com.shop.demoshop.controllers;

import com.shop.demoshop.models.Subscriber;
import com.shop.demoshop.repositories.SubscriberRepository;
import com.shop.demoshop.utils.SubscriberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/subscribers")
public class SubscriberController {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Subscriber add(@RequestBody Subscriber subscriber) {
        if (subscriber.getDateJoined() == null) {
            subscriber.setDateJoined(new Date());
        }

        return subscriberRepository.save(subscriber);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Subscriber getById(@PathVariable long id) {
        try {
            return subscriberRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @RequestMapping(value = "/getAllByProduct/{id}", method = RequestMethod.GET)
    public List<Subscriber> getAllByProduct(@PathVariable long id) {
        return subscriberRepository.findByProducts_Id(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Subscriber update(@RequestBody Subscriber newSubscriber, @PathVariable long id) {
        try {
            Subscriber subscriber = subscriberRepository.findById(id).get();

            SubscriberUtils.updateSubscriber(subscriber, newSubscriber);

            return subscriberRepository.save(subscriber);
        } catch (NoSuchElementException e) {
            return subscriberRepository.save(newSubscriber);
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public long getNumberOfSubscribers() {
        return subscriberRepository.findAll().size();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        subscriberRepository.deleteById(id);
    }
}
