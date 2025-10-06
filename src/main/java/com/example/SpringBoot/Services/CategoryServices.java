package com.example.SpringBoot.Services;

import com.example.SpringBoot.Model.Category;

import java.util.List;

public interface CategoryServices {

    List<Category> getAllCategories();

    void addCategory(Category category);

}
