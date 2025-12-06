package com.finance.app.controller;

import com.finance.app.dto.CategoryRequest;
import com.finance.app.entity.Category;
import com.finance.app.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public String add(@RequestBody CategoryRequest cat, HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        categoryService.addCategory(cat,email);
        return "category added";
    }
}
