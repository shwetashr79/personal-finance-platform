package com.finance.app.controller;

import com.finance.app.dto.CategoryRequest;
import com.finance.app.entity.Category;
import com.finance.app.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Category create(@Valid  @RequestBody CategoryRequest request){

        return categoryService.create(request);
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getAll();
    }

}
