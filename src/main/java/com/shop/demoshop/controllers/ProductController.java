package com.shop.demoshop.controllers;

import com.shop.demoshop.exceptions.CustomEntityNotFoundException;
import com.shop.demoshop.models.Product;
import com.shop.demoshop.repositories.ProductRepository;
import com.shop.demoshop.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

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
    public Product getById(@PathVariable int id) {
        try {
            return productRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new CustomEntityNotFoundException();
        }
    }

    @RequestMapping(value = "/getAllBySubscriber/{id}")
    public List<Product> getAllBySubscriberId(@PathVariable int id) {
        return productRepository.findBySubscribers_Id(id);
    }

    @RequestMapping(value = "/getTop/{size}")
    public List<Product> getMostPopular(@PathVariable int size) {
        List<Product> allProducts = productRepository.findAll();

        return ProductUtils.getTop(allProducts, size);
    }

    @RequestMapping(value = "/get/{dateString}/{isActive}")
    public int getAllByStatusAndDate(@PathVariable String dateString, @PathVariable boolean isActive) {
        List<Product> products = productRepository.findAll();

        return ProductUtils.filterProducts(products, dateString, isActive);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Product update(@RequestBody Product newProduct, @PathVariable int id) {
        try {
            Product product = productRepository.getById(id);

            ProductUtils.updateProduct(product, newProduct);

            return productRepository.save(product);
        } catch (EntityNotFoundException e) {
            throw new CustomEntityNotFoundException();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        productRepository.deleteById(id);
    }
}
