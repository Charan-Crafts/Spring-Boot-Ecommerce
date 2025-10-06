package com.example.SpringBoot.Services;

import com.example.SpringBoot.Model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements  CategoryService{

    List<Category> allCategories = new ArrayList<>();

    long categoryId = 1L;
    @Override
    public List<Category> getAllCategories() {
        return allCategories;
    }

    @Override
    public String addCategory(Category category) {
        category.setCategoryId(categoryId++);
        allCategories.add(category);
        return "Category added Successfully !!";
    }

    @Override
    public String deleteCategory(long categoryId) {

        // Find the category through the Category

        Optional<Category> category = allCategories.stream()
                .filter(c->c.getCategoryId()==categoryId)
                .findFirst();
        if(category.isPresent()){
            allCategories.remove(category);
            return "Category is Deleted";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Item is not founded with ID"+categoryId);
        }

    }

    @Override
    public String updateCategory(long categoryId, Category category) {

        // Check wheather the Category isExists or Not

        Optional<Category> isFound = allCategories.stream()
                .filter(c->c.getCategoryId()==categoryId).findFirst();

        if(isFound.isPresent()){
            Category presentCategory = isFound.get();
            presentCategory.setCategoryName(category.getCategoryName());

            return "Category is updated";

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category with Id "+categoryId+" is not founded");
        }

    }
}
