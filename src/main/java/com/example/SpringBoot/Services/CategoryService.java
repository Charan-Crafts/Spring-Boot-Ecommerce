package com.example.SpringBoot.Services;

import com.example.SpringBoot.Model.Category;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface CategoryService {

    public List<Category> getAllCategories();

    public String addCategory(Category category);

    public String deleteCategory(long categoryId);

    public String updateCategory(long categoryId, Category category);

}
