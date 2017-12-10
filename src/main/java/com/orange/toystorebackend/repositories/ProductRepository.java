package com.orange.toystorebackend.repositories;

import com.orange.toystorebackend.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    public Iterable<Product> findAllByCategoryId(Integer categoryId);
}
