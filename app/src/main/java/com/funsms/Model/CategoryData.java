package com.funsms.Model;

/**
 * Created by AVI on 03-01-2018.
 */

public class CategoryData {
    String category_name;
    String category;
    int category_img;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategory_img() {
        return category_img;
    }

    public void setCategory_img(int category_img) {
        this.category_img = category_img;
    }

    public CategoryData(String category_name, int category_img,String category) {
        this.category_name = category_name;
        this.category_img = category_img;
        this.category = category;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
