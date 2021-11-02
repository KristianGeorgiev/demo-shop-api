package com.shop.demoshop.utils;

import com.shop.demoshop.models.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProductUtils {

    public static Date setTimeToZero(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static List<Product> getTop(List<Product> products, int maxSize) {
        List<Product> topProducts = new ArrayList<Product>(maxSize);

        for (int i = 0; i < maxSize; i++) {
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
}
