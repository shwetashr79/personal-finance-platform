package com.finance.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryRequest {

    private Long id;

    @NotBlank
    private String categoryName;
    private String categoryDescription;

}
