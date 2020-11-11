package com.online.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.api.dto.TransactionRequest;
import com.online.api.dto.TransactionResponse;
import com.online.api.entity.Order;
import com.online.api.service.OrderService;

@RestController
@RequestMapping("/onlineorder")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public TransactionResponse doOrder(@RequestBody TransactionRequest request) {
		
		return orderService.placeOrder(request); 
	}
	
	@GetMapping("/getOrdersById/{orderId}")
	public Order getOrderById(@PathVariable int orderId) {
		
		return orderService.getOrderById(orderId);
	}
}
