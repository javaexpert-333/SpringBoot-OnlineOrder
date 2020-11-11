package com.online.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.api.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order findAllByOrderId(int orderId);

}
