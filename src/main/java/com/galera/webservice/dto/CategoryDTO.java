package com.galera.webservice.dto;

import com.galera.webservice.entities.Category;
import jakarta.persistence.Entity;

public record CategoryDTO(Long id, String name) {
    public CategoryDTO(Category entity){
        this(
                entity.getId(),
                entity.getName());
    }
}
