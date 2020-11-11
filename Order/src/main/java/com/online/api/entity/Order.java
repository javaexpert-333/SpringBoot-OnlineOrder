package com.online.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_TBL")
public class Order {
	@Id
	private int orderId;
	private String product;
	private double amount;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Order(int orderId, String product, double amount) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.amount = amount;
	}
	
	public Order() {
	}
	
}
