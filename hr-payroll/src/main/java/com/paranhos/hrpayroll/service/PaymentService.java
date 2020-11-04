package com.paranhos.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paranhos.hrpayroll.feignclients.WorkerFeignClient;
import com.paranhos.hrpayroll.model.Payment;
import com.paranhos.hrpayroll.model.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignCliente;

	public Payment getPayment(Long workerId, Integer days) {
		Worker worker = workerFeignCliente.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
