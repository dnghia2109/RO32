package com.example.blog.service;

import com.example.blog.dto.projection.BlogPublic;
import com.example.blog.dto.projection.CategoryPublic;
import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.exception.BadRequestException;
import com.example.blog.exception.NotFoundException;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.CategoryRepository;
import com.example.blog.request.UpsertCategoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final BlogRepository blogRepository;

    public Page<Category> getAllCategory(Integer page, Integer pageSize) {
        Page<Category> pageInfo = categoryRepository.findCategories(PageRequest.of(page - 1, pageSize));
        return pageInfo;
    }

    public List<Category> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    public Category createCategory(UpsertCategoryRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new BadRequestException("Name is required");
        }

        if (categoryRepository.findByName(request.getName()).isPresent()) {
            throw new BadRequestException("Category is exist");
        }

        Category category = new Category();
        category.setName(request.getName());

        categoryRepository.save(category);
        return category;
    }

    public Category updateCategory(Integer id, UpsertCategoryRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found category with id = " + id);
        });

        if (request.getName() == null || request.getName().equals("")) {
            throw new BadRequestException("Name is required");
        }

        if (categoryRepository.findByName(request.getName()).isPresent()
                && !categoryRepository.findByName(request.getName()).get().getName().equals(category.getName())) {
            throw new BadRequestException("Category is exist");
        }

        category.setName(request.getName());
        categoryRepository.save(category);
        return category;
    }

    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found category with id = " + id);
        });

        List<Blog> blogList = blogRepository.findByCategories_IdOrderByIdAsc(id);
        //blogList.forEach(blog -> blog.removeCategory(category));
        for (Blog blog: blogList) {
            blog.removeCategory(category);
            blogRepository.save(blog);
        }


        categoryRepository.delete(category);
    }
}
