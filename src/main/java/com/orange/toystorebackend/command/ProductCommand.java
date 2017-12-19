package com.orange.toystorebackend.command;


import com.orange.toystorebackend.entities.Product;

public class ProductCommand {
    public String name;
    public String description;
    public Integer availableStock;
    public Double price;
    public Integer categoryId;

    public Product getProduct(){
        Product p = new Product();
        p.setName(this.name);
        p.setAvailableStock(this.availableStock);
        p.setPrice(this.price);
        p.setDescription(this.description);
        return p;
    }
}
