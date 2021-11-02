package com.shop.demoshop.controllers;

import com.shop.demoshop.exceptions.DateFormatException;
import com.shop.demoshop.models.Product;
import com.shop.demoshop.repositories.ProductRepository;
import com.shop.demoshop.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final String EXPECTED_DATE_FORMAT = "dd-MM-yyyy";

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Product add(@RequestBody Product product) {
        if (product.getCreationDate() == null) {
            product.setCreationDate(new Date());
        }

        return productRepository.save(product);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Product getById(@PathVariable long id) {
        try {
            return productRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @RequestMapping(value = "/getAllBySubscriber/{id}")
    public List<Product> getAllBySubscriberId(@PathVariable long id) {
        return productRepository.findBySubscribers_Id(id);
    }

    @RequestMapping(value = "/getTop3")
    public List<Product> getTop3() {
        List<Product> allProducts = productRepository.findAll();

        Collections.sort(allProducts);

        return ProductUtils.getTop(allProducts, 3);
    }

    @RequestMapping(value = "/get/{dateString}/{isActive}")
    public List<Product> getAllByStatus(@PathVariable String dateString, @PathVariable boolean isActive) {
        List<Product> products = productRepository.findAll();
        List<Product> productsToReturn = new ArrayList<>();

        for (Product product : products) {
            try {
                Date date = new SimpleDateFormat(EXPECTED_DATE_FORMAT).parse(dateString);

                Date dateFromDB = product.getCreationDate();

                if (isActive == product.isAvailable() && date.compareTo(ProductUtils.setTimeToZero(dateFromDB)) == 0) {
                    productsToReturn.add(product);
                }
            } catch (ParseException e){
                throw new DateFormatException();
            }
        }

        return productsToReturn;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Product update(@RequestBody Product newProduct, @PathVariable long id) {
        try {
            Product product = productRepository.findById(id).get();

            ProductUtils.updateProduct(product, newProduct);

            return productRepository.save(product);
        } catch (NoSuchElementException e) {
            return productRepository.save(newProduct);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        productRepository.deleteById(id);
    }
}
