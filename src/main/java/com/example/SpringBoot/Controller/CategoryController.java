package com.example.SpringBoot.Controller;


import com.example.SpringBoot.Model.Category;
import com.example.SpringBoot.Services.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/api/public/getCategories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/admin/addCategory")
    public ResponseEntity<String> addCategory(@RequestBody Category newCategory){
        try{
            categoryService.addCategory(newCategory);
            return ResponseEntity.ok("Category added !! ");
        }catch (ResponseStatusException e){
            return  new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @PutMapping("/api/admin/updateCategory/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable long categoryId,@RequestBody Category category){

        try{
            categoryService.updateCategory(categoryId,category);
            return ResponseEntity.ok("Updated !!");
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @DeleteMapping("/api/admin/deleteCategory/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryId){
        try{
            categoryService.deleteCategory(categoryId);

            return ResponseEntity.ok("Deleted");
        }catch (ResponseStatusException e){

            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
