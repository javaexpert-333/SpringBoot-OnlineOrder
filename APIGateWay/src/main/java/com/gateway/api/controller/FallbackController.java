package com.gateway.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
	
	@RequestMapping("/orderServiceFallback")
	public Mono<String> orderServiceFallback() {
		return Mono.just("Order service is not available");
	}
	
	@RequestMapping("/paymentServiceFallback")
	public Mono<String> paymentServiceFallback() {
		return Mono.just("Payment service is not available");
	}
}
