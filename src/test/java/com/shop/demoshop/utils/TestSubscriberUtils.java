package com.shop.demoshop.utils;

import com.shop.demoshop.helpers.TestHelper;
import com.shop.demoshop.models.Subscriber;
import org.testng.annotations.Test;

public class TestSubscriberUtils {

    @Test(dataProvider = "provideSubscribersForUpdate", dataProviderClass = TestHelper.class)
    public void testUpdateSubscriber(Subscriber subscriber, Subscriber newSubscriber) {
        SubscriberUtils.updateSubscriber(subscriber, newSubscriber);

        TestHelper.compareSubscribers(subscriber, newSubscriber);
    }
}
