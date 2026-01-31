package com.galera.webservice.services;

import com.galera.webservice.dto.CategoryDTO;
import com.galera.webservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> findAll(){
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::new)
                .toList();
    }

    public Optional<CategoryDTO> findById(Long id){
        return categoryRepository.findById(id)
                .map(CategoryDTO::new);
    }
}
