package com.shop.demoshop.utils;

import com.shop.demoshop.helpers.TestHelper;
import com.shop.demoshop.models.Product;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

@Test
public class TestProductUtils {

    @Test(dataProvider = "provideTopProducts", dataProviderClass = TestHelper.class)
    public void testGetTop(List<Product> products, int maxSize, List<Product> expected) {
        List<Product> modified = ProductUtils.getTop(products, maxSize);

        TestHelper.compareListsOfProducts(modified, expected);
    }

    @Test(dataProvider = "provideProductsForUpdate", dataProviderClass = TestHelper.class)
    public void testUpdateProduct(Product product, Product newProduct) {
        ProductUtils.updateProduct(product, newProduct);

        TestHelper.compareProducts(product, newProduct);
    }

    @Test(dataProvider = "provideProductsToFilter", dataProviderClass = TestHelper.class)
    public void testFilterProducts(List<Product> products,String dateString, boolean isActive, int expectedOutput) {
        assertEquals(ProductUtils.filterProducts(products, dateString, isActive), expectedOutput);
    }
}
