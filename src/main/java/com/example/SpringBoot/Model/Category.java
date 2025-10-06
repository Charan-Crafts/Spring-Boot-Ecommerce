package com.example.SpringBoot.Model;

public class Category {
    private String categoryName;

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
