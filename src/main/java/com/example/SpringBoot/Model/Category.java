package com.example.SpringBoot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="Categories")
public class Category {
    private String categoryName;

    @Id
    private long categoryId;

    public Category(String categoryName,long categoryId){
        this.categoryId=categoryId;
        this.categoryName=categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
