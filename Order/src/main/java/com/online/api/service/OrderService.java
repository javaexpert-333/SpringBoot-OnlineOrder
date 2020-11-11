package com.online.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.online.api.dto.Payment;
import com.online.api.dto.TransactionRequest;
import com.online.api.dto.TransactionResponse;
import com.online.api.entity.Order;
import com.online.api.repository.OrderRepository;

@Service
@RefreshScope
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	@Lazy
	RestTemplate restTemplate;
	
	//@Value("${microservice.payment-service.end-point.uri}")
	//private String ENDPOINT_URI;
	
	public TransactionResponse placeOrder(TransactionRequest request) {
		
		Order order = orderRepo.save(request.getOrder());
		
		Payment payment = new Payment();
		payment.setAmount(order.getAmount());
		payment.setOrderId(order.getOrderId());
		
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/onlinepayment/payment", payment, Payment.class);
		//Payment paymentResponse = restTemplate.postForObject(ENDPOINT_URI, payment, Payment.class);

		TransactionResponse res = new TransactionResponse();
		
		res.setAmount(paymentResponse.getAmount());
		res.setOrderId(paymentResponse.getOrderId());
		res.setProduct(order.getProduct());
		res.setPayment(paymentResponse);
		
		return res;
	}

	public Order getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderRepo.findAllByOrderId(orderId);
	}
}
