package com.shop.demoshop.utils;

import com.shop.demoshop.models.Subscriber;

public class SubscriberUtils {
    public static void updateSubscriber(Subscriber subscriber, Subscriber newSubscriber) {
        subscriber.setFirstName(newSubscriber.getFirstName());
        subscriber.setLastName(newSubscriber.getLastName());

        if (newSubscriber.getDateJoined() != null)
            subscriber.setDateJoined(newSubscriber.getDateJoined());

        if (newSubscriber.getProducts() != null)
            subscriber.setProducts(newSubscriber.getProducts());
    }
}
