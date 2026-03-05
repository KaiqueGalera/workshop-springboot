package com.galera.webservice.dto;

import com.galera.webservice.domain.Product;

import java.util.List;

public record ProductDTO(Long id, String name, String description, Double price, String imgUrl, List<OrderItemDTO> orderItemDTOS) {

    public ProductDTO(Product entity){
        this(entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getImgUrl(),
                entity.getItems()
                        .stream()
                        .map(OrderItemDTO::new).toList());
    }
}
