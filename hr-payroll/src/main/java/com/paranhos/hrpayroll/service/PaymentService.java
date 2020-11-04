package com.paranhos.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paranhos.hrpayroll.model.Payment;
import com.paranhos.hrpayroll.model.Worker;

@Service
public class PaymentService {
	
	@Value("${hr0worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(Long workerId, Integer days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId.toString());
		
		Worker worker = restTemplate.getForObject(workerId + "/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
