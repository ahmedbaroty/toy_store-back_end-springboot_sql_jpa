package com.orange.toystorebackend.controllers;

import com.orange.toystorebackend.entities.Category;
import com.orange.toystorebackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories/{categoryId}")
    public Category getCategory(@PathVariable Integer categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @CrossOrigin("http://localhost:8080")
    @RequestMapping(method = RequestMethod.PUT, value = "/categories/update")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @CrossOrigin("http://localhost:8080")
    @RequestMapping(method = RequestMethod.DELETE, value = "/categories/delete/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/categories")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
}
