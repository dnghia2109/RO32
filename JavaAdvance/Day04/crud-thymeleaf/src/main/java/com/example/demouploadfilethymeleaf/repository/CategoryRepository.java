package com.example.demouploadfilethymeleaf.repository;

import com.example.demouploadfilethymeleaf.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    private List<Category> list = new ArrayList<>();

    public CategoryRepository() {
        list.add(new Category(1, "Laptop"));
        list.add(new Category(1, "Phụ kiện"));
        list.add(new Category(1, "Điện thoại"));
    }

    public List<Category> getAll() {
        return list;
    }

    public Category getCateById(int id) {
        return list.stream().filter(category -> category.getId() == id).findFirst().get();
    }
}
