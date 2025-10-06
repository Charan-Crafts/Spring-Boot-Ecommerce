package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Model.Category;
import com.example.SpringBoot.Services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/api/public/categories")

    public List<Category> getAllCategories(){

        return categoryServiceImpl.getAllCategories();

    }

    @PostMapping("/api/admin/add")
    public String addCategory(@RequestBody Category category){
        categoryServiceImpl.addCategory(category);
        return "Category added Successfully";
    }

}
