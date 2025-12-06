package com.finance.app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryRequest {

    private Long id;
    private String categoryName;
    private String categoryDescription;

}
