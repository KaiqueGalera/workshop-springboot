package com.galera.webservice.repositories;

import com.galera.webservice.entities.OrderItem;
import com.galera.webservice.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
