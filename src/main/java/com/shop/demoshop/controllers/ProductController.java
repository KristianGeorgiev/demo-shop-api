package com.shop.demoshop.controllers;

import com.shop.demoshop.models.Product;
import com.shop.demoshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

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

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Product getById(@PathVariable long id) {
        try {
            return productRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @RequestMapping(value = "getAllBySubscriber/{id}")
    public List<Product> getAllBySubscriberId(@PathVariable long id) {
        return productRepository.findBySubscribers_Id(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Product update(@RequestBody Product product, @PathVariable long id) {
        try {
            Product oldProduct = productRepository.findById(id).get();

            oldProduct.setName(product.getName());
            oldProduct.setAvailable(product.isAvailable());

            if (product.getCreationDate() != null)
                oldProduct.setCreationDate(product.getCreationDate());

            if (product.getSubscribers() != null)
                oldProduct.setSubscribers(product.getSubscribers());

            return productRepository.save(oldProduct);
        } catch (NoSuchElementException e) {
            return productRepository.save(product);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        productRepository.deleteById(id);
    }
}
