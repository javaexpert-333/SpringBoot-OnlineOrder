package com.online.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.api.entity.Payment;
import com.online.api.service.PaymentService;

@RestController
@RequestMapping("/onlinepayment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/payment")
	public Payment paymentController(@RequestBody Payment payment) {
		return paymentService.doPayment(payment);
	}
}
