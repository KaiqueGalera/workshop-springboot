package com.galera.webservice.services;

import com.galera.webservice.dto.ProductDTO;
import com.galera.webservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Set<ProductDTO> findAll(){
        return productRepository.findAll()
                .stream().map(ProductDTO::new)
                .collect(Collectors.toSet());
    }

    public Optional<ProductDTO> findById(Long id){
        return productRepository.findById(id)
                .map(ProductDTO::new);
    }
}
