package com.galera.webservice.dto;

import com.galera.webservice.entities.OrderItem;

public record OrderItemPDTO(
        Long productId,
        String productName,
        Integer quantity,
        Double price
) {
    public OrderItemPDTO(OrderItem entity) {
        this(
                entity.getProduct().getId(),
                entity.getProduct().getName(),
                entity.getQuantity(),
                entity.getPrice()
        );
    }
}
