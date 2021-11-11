package com.shop.demoshop.helpers;

import com.shop.demoshop.models.Product;
import com.shop.demoshop.models.Subscriber;
import org.testng.annotations.DataProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.testng.Assert.*;

public class TestHelper {
    private static final String DATE_FORMAT_WITH_TIME = "dd-MM-yyyy hh:mm:ss";

    private static Product product1;
    private static Product product2;
    private static Product product3;
    private static Product product4;
    private static Product product5;

    private static Product newProduct1;
    private static Product newProduct2;
    private static Product newProduct3;
    private static Product newProduct4;
    private static Product newProduct5;

    private static Subscriber subscriber1;
    private static Subscriber subscriber2;
    private static Subscriber subscriber3;
    private static Subscriber subscriber4;

    private static Subscriber newSubscriber1;
    private static Subscriber newSubscriber2;
    private static Subscriber newSubscriber3;
    private static Subscriber newSubscriber4;

    public static void initializeData() throws ParseException {
        product1 = new Product();
        product2 = new Product();
        product3 = new Product();
        product4 = new Product();
        product5 = new Product();

        newProduct1 = new Product();
        newProduct2 = new Product();
        newProduct3 = new Product();
        newProduct4 = new Product();
        newProduct5 = new Product();

        subscriber1 = new Subscriber();
        subscriber2 = new Subscriber();
        subscriber3 = new Subscriber();
        subscriber4 = new Subscriber();

        newSubscriber1 = new Subscriber();
        newSubscriber2 = new Subscriber();
        newSubscriber3 = new Subscriber();
        newSubscriber4 = new Subscriber();

        subscriber1.setId(1);
        subscriber2.setId(2);
        subscriber3.setId(3);
        subscriber4.setId(4);

        newSubscriber1.setId(1);
        newSubscriber2.setId(2);
        newSubscriber3.setId(3);
        newSubscriber4.setId(4);

        subscriber1.setFirstName("SubscriberOneFN");
        subscriber2.setFirstName("SubscriberTwoFN");
        subscriber3.setFirstName("SubscriberThreeFN");
        subscriber4.setFirstName("SubscriberFourFN");

        newSubscriber1.setFirstName("Updated SubscriberOneFN");
        newSubscriber2.setFirstName("Updated SubscriberTwoFN");
        newSubscriber3.setFirstName("Updated SubscriberThreeFN");
        newSubscriber4.setFirstName("Updated SubscriberFourFN");

        subscriber1.setLastName("SubscriberOneLN");
        subscriber2.setLastName("SubscriberTwoLN");
        subscriber3.setLastName("SubscriberThreeLN");
        subscriber4.setLastName("SubscriberFourLN");

        newSubscriber1.setLastName("Updated SubscriberOneLN");
        newSubscriber2.setLastName("Updated SubscriberTwoLN");
        newSubscriber3.setLastName("Updated SubscriberThreeLN");
        newSubscriber4.setLastName("Updated SubscriberFourLN");

        subscriber1.setDateJoined(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("01-01-2021 00:00:00"));
        subscriber2.setDateJoined(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("31-12-2021 00:00:00"));
        subscriber3.setDateJoined(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("01-06-2021 12:00:00"));
        subscriber4.setDateJoined(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("08-10-2021 13:43:56"));

        newSubscriber1.setDateJoined(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("31-12-2020 00:00:00"));
        newSubscriber2.setDateJoined(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("01-01-2021 00:00:00"));
        newSubscriber3.setDateJoined(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("12-06-2021 12:32:50"));
        newSubscriber4.setDateJoined(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("08-10-2028 22:43:23"));

        product1.setId(1);
        product2.setId(2);
        product3.setId(3);
        product4.setId(4);
        product5.setId(5);

        newProduct1.setId(1);
        newProduct2.setId(2);
        newProduct3.setId(3);
        newProduct4.setId(4);
        newProduct5.setId(5);

        product1.setName("Product one");
        product2.setName("Product two");
        product3.setName("Product three");
        product4.setName("Product four");
        product5.setName("Product five");

        newProduct1.setName("Updated Product one");
        newProduct2.setName("Updated Product two");
        newProduct3.setName("Updated Product three");
        newProduct4.setName("Updated Product four");
        newProduct5.setName("Updated Product five");

        product1.setAvailable(true);
        product2.setAvailable(false);
        product3.setAvailable(true);
        product4.setAvailable(false);
        product5.setAvailable(true);

        newProduct1.setAvailable(false);
        newProduct2.setAvailable(true);
        newProduct3.setAvailable(false);
        newProduct4.setAvailable(false);
        newProduct5.setAvailable(false);

        product1.setCreationDate(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("01-01-2021 00:00:00"));
        product2.setCreationDate(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("04-03-2021 06:25:50"));
        product3.setCreationDate(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("13-06-2020 00:06:34"));
        product4.setCreationDate(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("31-12-2024 00:00:00"));

        newProduct1.setCreationDate(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("01-06-2021 00:00:25"));
        newProduct2.setCreationDate(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("04-03-2021 00:00:00"));
        newProduct3.setCreationDate(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("16-06-2020 21:43:34"));
        newProduct4.setCreationDate(new SimpleDateFormat(DATE_FORMAT_WITH_TIME).parse("01-01-2025 00:00:00"));

        product1.setSubscribers(new HashSet<>(Arrays.asList(subscriber1, subscriber2, subscriber3, subscriber4)));
        product2.setSubscribers(new HashSet<>(Arrays.asList(subscriber1, subscriber2, subscriber3)));
        product3.setSubscribers(new HashSet<>(Arrays.asList(subscriber1, subscriber2)));
        product4.setSubscribers(new HashSet<>(Arrays.asList(subscriber1)));

        newProduct1.setSubscribers(new HashSet<>(Arrays.asList(subscriber1)));
        newProduct2.setSubscribers(new HashSet<>(Arrays.asList(subscriber1, subscriber2)));
        newProduct3.setSubscribers(new HashSet<>(Arrays.asList(subscriber1, subscriber2, subscriber3)));
        newProduct4.setSubscribers(new HashSet<>(Arrays.asList(subscriber1, subscriber2, subscriber3, subscriber4)));
        newProduct5.setSubscribers(new HashSet<>(Arrays.asList(subscriber1, subscriber2, subscriber3, subscriber4)));

        subscriber1.setProducts(new HashSet<>(Arrays.asList(product1, product2, product3, product4)));
        subscriber2.setProducts(new HashSet<>(Arrays.asList(product1, product2, product3)));
        subscriber3.setProducts(new HashSet<>(Arrays.asList(product1, product2)));
        subscriber4.setProducts(new HashSet<>(Arrays.asList(product1)));

        newSubscriber1.setProducts(new HashSet<>(Arrays.asList(product1)));
        newSubscriber2.setProducts(new HashSet<>(Arrays.asList(product1, product2)));
        newSubscriber3.setProducts(new HashSet<>(Arrays.asList(product1, product2, product3)));
        newSubscriber4.setProducts(new HashSet<>(Arrays.asList(product1, product2, product3, product4)));
    }

    @DataProvider
    public static Object[][] provideProductsForUpdate() throws ParseException {
        initializeData();
        return new Object[][]{
                {product1, newProduct1},
                {product2, newProduct2},
                {product3, newProduct3},
                {product4, newProduct4},
                {product5, newProduct5}
        };
    }

    @DataProvider
    public static Object[][] provideSubscribersForUpdate() throws ParseException {
        initializeData();

        return new Object[][]{
                {subscriber1, newSubscriber1},
                {subscriber2, newSubscriber2},
                {subscriber3, newSubscriber3},
                {subscriber4, newSubscriber4}
        };
    }

    @DataProvider
    public static Object[][] provideTopProducts() throws ParseException {
        initializeData();

        return new Object[][] {
                {getProducts(1), 0, getExpectedProducts(0)},
                {getProducts(1), 1, getExpectedProducts(1)},
                {getProducts(1), 2, getExpectedProducts(1)},
                {getProducts(1), 5, getExpectedProducts(1)},
                {getProducts(2), 0, getExpectedProducts(0)},
                {getProducts(2), 1, getExpectedProducts(1)},
                {getProducts(2), 2, getExpectedProducts(2)},
                {getProducts(2), 3, getExpectedProducts(2)},
                {getProducts(2), 5, getExpectedProducts(2)},
                {getProducts(3), 0, getExpectedProducts(0)},
                {getProducts(3), 1, getExpectedProducts(1)},
                {getProducts(3), 2, getExpectedProducts(2)},
                {getProducts(3), 3, getExpectedProducts(3)},
                {getProducts(3), 4, getExpectedProducts(3)},
                {getProducts(3), 5, getExpectedProducts(3)},
                {getProducts(4), 0, getExpectedProducts(0)},
                {getProducts(4), 1, getExpectedProducts(1)},
                {getProducts(4), 2, getExpectedProducts(2)},
                {getProducts(4), 3, getExpectedProducts(3)},
                {getProducts(4), 4, getExpectedProducts(4)},
                {getProducts(4), 5, getExpectedProducts(4)},
                {getProducts(4), 6, getExpectedProducts(4)},
                {getProducts(5), 0, getExpectedProducts(0)},
                {getProducts(5), 1, getExpectedProducts(1)},
                {getProducts(5), 2, getExpectedProducts(2)},
                {getProducts(5), 3, getExpectedProducts(3)},
                {getProducts(5), 4, getExpectedProducts(4)},
                {getProducts(5), 5, getExpectedProducts(5)},
                {getProducts(5), 6, getExpectedProducts(5)},
                {getProducts(5), 95, getExpectedProducts(5)}
        };
    }

    @DataProvider
    public static Object[][] provideProductsToFilter() throws ParseException {
        initializeData();

        return new Object[][]{
                {getProducts(1), "31-12-2020 03:23:51", true, 1},
                {getProducts(1), "31-12-2021 03:23:51", false, 0},
                {getProducts(1), "31-12-2021 03:23:51", true, 0},
                {getProducts(1), "31-12-2020 03:23:51", false, 0},
                {getProducts(2), "31-12-2020 03:23:51", false, 1},
                {getProducts(2), "31-12-2020 03:23:51", true, 1},
                {getProducts(2), "31-12-2021 03:23:51", true, 0},
                {getProducts(2), "31-12-2021 03:23:51", false, 0},
                {getProducts(3), "13-06-2020 00:06:30", true, 2},
                {getProducts(3), "13-06-2020 00:06:30", false, 1},
                {getProducts(3), "31-12-2020 03:23:51", true, 1},
                {getProducts(3), "31-12-2020 03:23:51", false, 1},
                {getProducts(3), "01-03-2021 03:23:51", true, 0},
                {getProducts(3), "01-03-2021 03:23:51", false, 1},
                {getProducts(4), "13-06-2020 00:06:30", false, 2},
                {getProducts(4), "13-06-2020 00:06:30", true, 2},
                {getProducts(4), "13-06-2020", true, 2}
        };
    }

    @DataProvider
    public static Object[][] provideProduct() throws ParseException {
        initializeData();

        return new Object[][]{
                {product1},
                {product2},
                {product3},
                {product4},
                {product5}
        };
    }

    @DataProvider
    public static Object[][] provideSubscriber() throws ParseException {
        initializeData();

        return new Object[][]{
                {subscriber1},
                {subscriber2},
                {subscriber3},
                {subscriber4},
        };
    }

    public static void compareProducts(Product product1, Product product2) {
        assertEquals(product1.getId(), product2.getId());
        assertEquals(product1.getName(), product2.getName());

        Date product1CreationDate = product1.getCreationDate();
        Date product2CreationDate = product2.getCreationDate();

        assertEquals(product1CreationDate, product2CreationDate);

        Set<Subscriber> product1Subscribers = product1.getSubscribers();
        Set<Subscriber> product2Subscribers = product2.getSubscribers();

        if (product1Subscribers != null && product2Subscribers != null) {
            assertEquals(product1Subscribers.size(), product2Subscribers.size());

            for (Subscriber product1Subscriber : product1Subscribers) {
                assertTrue(product2Subscribers.contains(product1Subscriber));
            }
        } else {
            assertEquals(product1Subscribers, product2Subscribers);
        }
    }

    public static void compareListsOfProducts(List<Product> actual, List<Product> expected) {
        assertEquals(actual.size(), expected.size());

        for (int i = 0; i < actual.size(); i++) {
            Product modifiedProduct = actual.get(i);
            Product expectedProduct = expected.get(i);

            TestHelper.compareProducts(modifiedProduct, expectedProduct);
        }
    }

    public static void compareSubscribers(Subscriber subscriber1, Subscriber subscriber2) {
        assertEquals(subscriber1.getId(), subscriber2.getId());
        assertEquals(subscriber1.getFirstName(), subscriber2.getFirstName());
        assertEquals(subscriber1.getLastName(), subscriber2.getLastName());
        assertEquals(subscriber1.getDateJoined().getTime(), subscriber2.getDateJoined().getTime());

        Set<Product> subscriberProducts = subscriber1.getProducts();
        Set<Product> newSubscriberProducts = subscriber2.getProducts();

        assertEquals(subscriberProducts.size(), newSubscriberProducts.size());

        for (Product newSubscriberProduct : newSubscriberProducts) {
            assertTrue(subscriberProducts.contains(newSubscriberProduct));
        }
    }

    private static List<Product> getProducts(int numberOfProducts) {
        List<Product> products = new ArrayList<>();

        switch (numberOfProducts) {
            case 0:
                break;
            case 1:
                products.add(product1);
                break;
            case 2:
                products.add(product1);
                products.add(product2);
                break;
            case 3:
                products.add(product1);
                products.add(product2);
                products.add(product3);
                break;
            case 4:
                products.add(product1);
                products.add(product2);
                products.add(product3);
                products.add(product4);
                break;
            default:
                products.add(product1);
                products.add(product2);
                products.add(product3);
                products.add(product4);
                products.add(product5);
        }

        return products;
    }

    private static List<Product> getExpectedProducts(int numberOfProducts) {
        List<Product> products = getProducts(numberOfProducts);

        Collections.sort(products);

        return products;
    }
}