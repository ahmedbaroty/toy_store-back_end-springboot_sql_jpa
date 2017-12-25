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

    public List<ProductUpdateCommand> getAllProducts() {
        List <Product> list = (List<Product>)productRepository.findAll();
        List <ProductUpdateCommand> listTOReturn = new ArrayList<>();
        for(Product p : list) {
            listTOReturn.add(ProductUpdateCommand.fromProduct(p));
        }
        System.out.println(list.get(0).getCategory().getCategoryId());

        return listTOReturn;
    }

//    public List<Product> getAllProductsByCategoryId(Integer categoryId) {
//        List <Product> list = new ArrayList<>();
//        productRepository.findAllByCategoryId(categoryId).forEach(list::add);
//        return list;
//    }

    public ProductUpdateCommand getProduct(Integer productId) {
        Product p = productRepository.findOne(productId);

        System.out.println(p.getCategory().getCategoryId()
         + " " + p.getCategory().getName());

        return ProductUpdateCommand.fromProduct(productRepository.findOne(productId));
    }

    public Product updateProduct(ProductUpdateCommand productCommand) {
        Category category =  categoryRepository.findOne(productCommand.categoryId);
        if(category != null) {
            Product product = productCommand.toProduct();
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
