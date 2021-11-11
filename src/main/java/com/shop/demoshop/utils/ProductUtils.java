package com.shop.demoshop.utils;

import com.shop.demoshop.exceptions.DateFormatException;
import com.shop.demoshop.models.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductUtils {

    private static final String EXPECTED_DATE_FORMAT = "dd-MM-yyyy hh:mm:ss";
    private static final String FULL_TIME_REGEX = "\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}";
    private static final String BEGIN_OF_DAY_TIME = " 00:00:00";

    public static List<Product> getTop(List<Product> products, int maxSize) {
        List<Product> topProducts = new ArrayList<>(maxSize);

        Collections.sort(products);

        for (int i = 0; i < maxSize; i++) {
            if (i >= products.size())
                break;

            topProducts.add(products.get(i));
        }

        return topProducts;
    }

    public static void updateProduct(Product product, Product newProduct) {
        product.setName(newProduct.getName());
        product.setAvailable(newProduct.isAvailable());

        if (newProduct.getCreationDate() != null)
            product.setCreationDate(newProduct.getCreationDate());

        if (newProduct.getSubscribers() != null)
            product.setSubscribers(newProduct.getSubscribers());
    }

    public static int filterProducts(List<Product> products,String dateString, boolean isActive) {
        int numberOfProducts = 0;

        for (Product product : products) {
            try {
                Date date = new SimpleDateFormat(EXPECTED_DATE_FORMAT).parse(
                        dateString.matches(FULL_TIME_REGEX) ? dateString : dateString + BEGIN_OF_DAY_TIME);

                Date dateFromDB = product.getCreationDate();

                if (isActive == product.isAvailable() && date.compareTo(dateFromDB) <= 0) {
                    numberOfProducts++;
                }
            } catch (ParseException e){
                throw new DateFormatException();
            }
        }

        return numberOfProducts;
    }
}
