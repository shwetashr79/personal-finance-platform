package com.finance.app.service;

import java.util.List;
import com.finance.app.dto.CategoryRequest;
import com.finance.app.entity.Category;


public interface CategoryService {
    Category create(CategoryRequest request);
    List<Category> getAll();
}
