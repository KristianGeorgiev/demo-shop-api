package com.shop.demoshop.controllers;

import com.shop.demoshop.helpers.TestHelper;
import com.shop.demoshop.models.Subscriber;
import com.shop.demoshop.repositories.SubscriberRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;

@Test
public class TestSubscriberController {

    @Mock
    private SubscriberRepository subscriberRepository;

    @InjectMocks
    private SubscriberController subscriberController;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(dataProvider = "provideSubscriber", dataProviderClass = TestHelper.class)
    public void testAdd(Subscriber subscriber) {
        when(subscriberRepository.save(Mockito.any(Subscriber.class)))
                .thenReturn(subscriber);

        TestHelper.compareSubscribers(subscriber, subscriberController.add(subscriber));
    }

    @Test(dataProvider = "provideSubscriber", dataProviderClass = TestHelper.class)
    public void testGetById(Subscriber subscriber) {
        when(subscriberRepository.findById(Mockito.anyInt()))
                .thenReturn(java.util.Optional.ofNullable(subscriber));

        TestHelper.compareSubscribers(subscriber, subscriberController.getById(subscriber.getId()));
    }

    @Test(dataProvider = "provideSubscribersForUpdate", dataProviderClass = TestHelper.class)
    public void testUpdate(Subscriber subscriber, Subscriber newSubscriber) {
        when(subscriberRepository.getById(Mockito.anyInt()))
                .thenReturn(subscriber);
        when(subscriberRepository.save(Mockito.any(Subscriber.class)))
                .thenReturn(newSubscriber);

        TestHelper.compareSubscribers(subscriberController.update(subscriber, subscriber.getId()), newSubscriber);
    }
}
