package com.shop.demoshop.controllers;

import com.shop.demoshop.helpers.TestHelper;
import com.shop.demoshop.models.Product;
import com.shop.demoshop.repositories.ProductRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

@Test
public class TestProductController {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

   @BeforeMethod
    public void setup() {
       MockitoAnnotations.initMocks(this);
    }

    @Test(dataProvider = "provideProduct", dataProviderClass = TestHelper.class)
    public void testAdd(Product product) {
        when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(product);

        TestHelper.compareProducts(product, productController.add(product));
    }

    @Test(dataProvider = "provideProduct", dataProviderClass = TestHelper.class)
    public void testGetById(Product product) {
        when(productRepository.findById(Mockito.anyInt()))
                .thenReturn(java.util.Optional.ofNullable(product));

        TestHelper.compareProducts(product, productController.getById(product.getId()));
    }

    @Test(dataProvider = "provideTopProducts", dataProviderClass = TestHelper.class)
    public void testGetMostPopular(List<Product> products, int maxSize, List<Product> expected) {
        when(productRepository.findAll()).thenReturn(products);

        List<Product> modified = productController.getMostPopular(maxSize);

        TestHelper.compareListsOfProducts(modified, expected);
    }

    @Test(dataProvider = "provideProductsToFilter", dataProviderClass = TestHelper.class)
    public void testGetAllByStatusAndDate(List<Product> products,String dateString, boolean isActive, int expectedOutput) {
        when(productRepository.findAll()).thenReturn(products);

        assertEquals(productController.getAllByStatusAndDate(dateString, isActive), expectedOutput);
    }

    @Test(dataProvider = "provideProductsForUpdate", dataProviderClass = TestHelper.class)
    public void testUpdate(Product product, Product newProduct) {
        when(productRepository.getById(Mockito.anyInt()))
                .thenReturn(product);
        when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(newProduct);

        TestHelper.compareProducts(productController.update(product, product.getId()), newProduct);
    }
}