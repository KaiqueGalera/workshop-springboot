package com.galera.webservice.dto;

import com.galera.webservice.domain.OrderItem;

public record OrderItemDTO(Long id, Integer quantity, Double price) {

    public OrderItemDTO(OrderItem orderItem){
        this(
                orderItem.getOrder().getId(),
                orderItem.getQuantity(),
                orderItem.getPrice());
    }
}
