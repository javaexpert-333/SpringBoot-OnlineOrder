package com.online.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_TBL")
public class Payment {
	@Id
	@GeneratedValue
	private int paymentId;
	private String transactionId;
	private double amount;
	private int orderId;
	private String paymentStatus;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Payment(int paymentId, String transactionId, double amount, int orderId, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.transactionId = transactionId;
		this.amount = amount;
		this.orderId = orderId;
		this.paymentStatus = paymentStatus;
	}
	public Payment() {
		super();
	}
	
	
	
}
