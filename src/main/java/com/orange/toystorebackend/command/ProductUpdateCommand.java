package com.orange.toystorebackend.command;

import com.orange.toystorebackend.entities.Product;

public class ProductUpdateCommand {
    public Integer productId;
    public String name;
    public String description;
    public Integer availableStock;
    public Double price;
    public Integer categoryId;

    public ProductUpdateCommand(){}

    public ProductUpdateCommand(Integer productId, String name, String description,
                                Integer availableStock, Double price, Integer categoryId) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.availableStock = availableStock;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Product toProduct() {
        Product p = new Product();
        p.setProductId(this.productId);
        p.setName(this.name);
        p.setAvailableStock(this.availableStock);
        p.setPrice(this.price);
        p.setDescription(this.description);
        return p;
    }

    public static ProductUpdateCommand fromProduct(Product product) {
        System.out.println(product.getCategory().getCategoryId());
        return new ProductUpdateCommand(
                product.getProductId() , product.getName() , product.getDescription()
                ,product.getAvailableStock() , product.getPrice() , product.getCategory().getCategoryId()
        );
    }
}

