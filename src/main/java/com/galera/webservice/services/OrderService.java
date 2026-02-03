package com.galera.webservice.services;

import com.galera.webservice.dto.OrderDTO;
import com.galera.webservice.entities.Order;
import com.galera.webservice.repositories.OrderRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional (readOnly = true)
    public List<OrderDTO> findAll(){
        return orderRepository.findAll()
                .stream().map(OrderDTO::new)
                .toList();
    }

    @Transactional (readOnly = true)
    public OrderDTO findById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found"));
        return new OrderDTO(order);
    }
}
