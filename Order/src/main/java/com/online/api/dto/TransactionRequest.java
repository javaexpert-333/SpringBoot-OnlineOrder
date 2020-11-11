package com.online.api.dto;

import com.online.api.entity.Order;

public class TransactionRequest {
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public TransactionRequest(Order order) {
		super();
		this.order = order;
	}
	
	public TransactionRequest() {
		
	}
}
