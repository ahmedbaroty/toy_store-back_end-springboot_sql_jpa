package com.orange.toystorebackend.repositories;

import com.orange.toystorebackend.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
