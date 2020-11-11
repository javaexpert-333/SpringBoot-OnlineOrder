package com.online.api.dto;

public class TransactionResponse {
	private int orderId;
	private double amount;
	private String product;
	private Payment payment;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public TransactionResponse(int orderId, double amount, String product, Payment payment) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.product = product;
		this.payment = payment;
	}
	
	public TransactionResponse() {
	}
	
	
}
