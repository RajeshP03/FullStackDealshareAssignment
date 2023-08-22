package com.MRajApp.MRajeshApp.DAO;

import com.MRajApp.MRajeshApp.Model.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);

    List<Category> fetchCategoryList();

    void deleteCategoryById(Long categoryId);
}
