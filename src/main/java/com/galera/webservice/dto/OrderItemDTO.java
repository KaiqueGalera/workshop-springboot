package com.galera.webservice.dto;

import com.galera.webservice.entities.Order;
import com.galera.webservice.entities.OrderItem;
import com.galera.webservice.entities.Product;

public record OrderItemDTO(Long id, Integer quantity, Double price) {

    public OrderItemDTO(OrderItem orderItem){
        this(
                orderItem.getOrder().getId(),
                orderItem.getQuantity(),
                orderItem.getPrice());
    }
}
