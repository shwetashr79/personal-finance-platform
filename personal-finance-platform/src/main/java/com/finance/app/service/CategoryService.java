package com.finance.app.service;

import com.finance.app.dto.CategoryRequest;


public interface CategoryService {
    void addCategory(CategoryRequest cat, String email);
}
