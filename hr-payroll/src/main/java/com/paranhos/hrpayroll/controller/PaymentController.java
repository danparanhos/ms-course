package com.paranhos.hrpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.paranhos.hrpayroll.model.Payment;
import com.paranhos.hrpayroll.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentError")
	@GetMapping(value = "{workerid}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerid, @PathVariable Integer days) {
		Payment obj = service.getPayment(workerid, days);
		return ResponseEntity.ok(obj);
	}
	
	public ResponseEntity<Payment> getPaymentError(Long workerid, @PathVariable Integer days){
		Payment obj = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok(obj);
	}
	
}
