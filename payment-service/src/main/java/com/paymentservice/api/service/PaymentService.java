package com.paymentservice.api.service;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentservice.api.entity.Payment;
import com.paymentservice.api.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return repository.save(payment);
		
	}
	
	public String paymentProcessing() {
		//api should be 3rd party payment gatway (paypal, paytm or anyother)
		return new Random().nextBoolean()?"success":"false";
		
	}
	
	public Payment findPaymentHistoryByOrderId(int orderId) {
		return repository.findByOrderId(orderId);
	}
}
