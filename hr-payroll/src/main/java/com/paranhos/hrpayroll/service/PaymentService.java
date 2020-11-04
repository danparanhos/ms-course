package com.paranhos.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.paranhos.hrpayroll.model.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {
		 return new Payment("Bob", 200.0, days);
	}
	
}
