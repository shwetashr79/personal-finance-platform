package com.finance.app.service.impl;

import com.finance.app.dto.CategoryRequest;
import com.finance.app.entity.Category;
import com.finance.app.repository.CategoryRepository;
import com.finance.app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    @Override
    public void addCategory(CategoryRequest cat, String email) {
        Category category = new Category();
        category.setName(cat.getCategoryName());
        category.setDescription(cat.getCategoryDescription());
        categoryRepo.save(category);
    }
}
