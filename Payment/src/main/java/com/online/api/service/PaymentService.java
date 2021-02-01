package com.online.api.service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.api.entity.Payment;
import com.online.api.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepo;
	
	public Payment doPayment(Payment payment) {
		
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(getPaymentStatus());
		
		return paymentRepo.save(payment);
	}
	
	private String getPaymentStatus() {
		return new Random().nextBoolean()?"success":"fail";
	}
}
