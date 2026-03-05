package com.galera.webservice.dto;

import com.galera.webservice.domain.Category;

public record CategoryDTO(Long id, String name) {
    public CategoryDTO(Category entity){
        this(
                entity.getId(),
                entity.getName());
    }
}
