package com.orange.toystorebackend.services;

import com.orange.toystorebackend.command.ProductCommand;
import com.orange.toystorebackend.command.ProductUpdateCommand;
import com.orange.toystorebackend.entities.Category;
import com.orange.toystorebackend.entities.Product;
import com.orange.toystorebackend.repositories.CategoryRepository;
import com.orange.toystorebackend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    public List<Product> getAllProducts() {
        List <Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list;
    }

//    public List<Product> getAllProductsByCategoryId(Integer categoryId) {
//        List <Product> list = new ArrayList<>();
//        productRepository.findAllByCategoryId(categoryId).forEach(list::add);
//        return list;
//    }

    public Product getProduct(Integer productId) {
        return productRepository.findOne(productId);
    }

    public Product updateProduct(ProductUpdateCommand productCommand) {
        Category category =  categoryRepository.findOne(productCommand.categoryId);
        if(category != null) {
            Product product = productCommand.getProduct();
            product.setCategory(category);
            return productRepository.save(product);
        }
        return null;
    }

    public Product addProduct (ProductCommand productCommand) {

        Category category =  categoryRepository.findOne(productCommand.categoryId);
        if(category != null) {
            Product product = productCommand.getProduct();
            product.setCategory(category);
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Integer productId) {
        productRepository.delete(productId);
    }

}
