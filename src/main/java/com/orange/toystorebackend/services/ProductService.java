package com.orange.toystorebackend.services;

import com.orange.toystorebackend.entities.Product;
import com.orange.toystorebackend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List <Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list;
    }

    public List<Product> getAllProductsByCategoryId(Integer categoryId) {
        List <Product> list = new ArrayList<>();
        productRepository.findAllByCategoryId(categoryId).forEach(list::add);
        return list;
    }

    public Product getProduct(Integer productId) {
        return productRepository.findOne(productId);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Product addProduct (Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
        productRepository.delete(productId);
    }

}
