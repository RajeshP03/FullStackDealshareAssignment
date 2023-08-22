package com.MRajApp.MRajeshApp.controller;

import com.MRajApp.MRajeshApp.Model.Category;
import com.MRajApp.MRajeshApp.DAO.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save-category")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/get-categories")
    public List<Category> fetchCategoryList() {
        return categoryService.fetchCategoryList();
    }

    @DeleteMapping("delete/{id}")
    public String deleteCategoryById(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return "Delete Operation Successful!";
    }
}
