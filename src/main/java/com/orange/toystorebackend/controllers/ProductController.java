package com.orange.toystorebackend.controllers;

import com.orange.toystorebackend.command.ProductCommand;
import com.orange.toystorebackend.command.ProductUpdateCommand;
import com.orange.toystorebackend.entities.Product;
import com.orange.toystorebackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET , value="/products")
    public List<ProductUpdateCommand> getAllProducts(){
        return productService.getAllProducts();
    }

//    @RequestMapping(method = RequestMethod.GET , value="/products/{categoryId}")
//    public List<Product> getAllProductsByCategoryId(@PathVariable Integer categoryId){
//        return productService.getAllProductsByCategoryId(categoryId);
//    }

    @RequestMapping(method=RequestMethod.GET , value="/products/product/{productId}")
    public ProductUpdateCommand getProduct(@PathVariable Integer productId) {
        return productService.getProduct(productId);
    }

    @CrossOrigin ("http://localhost:8080")
    @RequestMapping(method=RequestMethod.PUT , value="/products/update")
    public Product updateProduct(@RequestBody ProductUpdateCommand product) {

        System.out.println("----------------------");
        System.out.println(product.productId);
        System.out.println(product.name);
        System.out.println(product.description);
        System.out.println(product.availableStock);
        System.out.println(product.price);
        System.out.println(product.categoryId);
        System.out.println("----------------------");

        return productService.updateProduct(product);
    }

    @CrossOrigin ("http://localhost:8080")
    @RequestMapping(method=RequestMethod.DELETE , value="/products/delete/{productId}")
    public void deleteProduct(@PathVariable  Integer productId) {
        productService.deleteProduct(productId);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/products/add")
    public Product addProduct(@RequestBody ProductCommand product) {
        return productService.addProduct(product);
    }
}
