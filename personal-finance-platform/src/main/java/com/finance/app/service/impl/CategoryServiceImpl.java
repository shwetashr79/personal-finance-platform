package com.finance.app.service.impl;

import com.finance.app.dto.CategoryRequest;
import com.finance.app.entity.Category;
import com.finance.app.repository.CategoryRepository;
import com.finance.app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    @Override
    public Category create(CategoryRequest request) {

        if(categoryRepo.existsByName(request.getCategoryName())){
            throw new RuntimeException("Category already exists");
        }
        Category category = new Category();
        category.setName(request.getCategoryName());
        category.setDescription(request.getCategoryDescription());
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }
}
