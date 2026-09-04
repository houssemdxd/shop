package com.project.shop.service.category;

import com.project.shop.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long id );
    Category getCategoryByName(String name );
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategoryById(Long id,Category category);
    void deleteCtaegoryById(Long id );



}
