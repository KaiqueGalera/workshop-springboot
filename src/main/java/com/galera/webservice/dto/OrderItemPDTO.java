package com.galera.webservice.dto;

import com.galera.webservice.domain.OrderItem;

public record OrderItemPDTO(
        Long productId,
        String productName,
        Integer quantity,
        Double price,
        Double subTotal
) {
    public OrderItemPDTO(OrderItem entity) {
        this(
                entity.getProduct().getId(),
                entity.getProduct().getName(),
                entity.getQuantity(),
                entity.getPrice(),
                entity.getSubTotal()
        );
    }
}
