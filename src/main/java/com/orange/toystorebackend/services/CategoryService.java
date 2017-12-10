package com.orange.toystorebackend.services;

import com.orange.toystorebackend.entities.Category;
import com.orange.toystorebackend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        categoryRepository.findAll().forEach(list::add);
        return list;
    }

    public void addCategory (Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory (Integer categoryId) {
        categoryRepository.delete(categoryId);
    }

    public Category updateCategory (Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategory(Integer categoryId) {
        return categoryRepository.findOne(categoryId);
    }

}
