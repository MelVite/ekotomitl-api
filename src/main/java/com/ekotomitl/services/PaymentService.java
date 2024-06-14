package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.Payment;
import com.ekotomitl.repositories.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	//Get todos los pagos
	public List<Payment> findAllPayment() {
		return paymentRepository.findAll();
	}
	
	//Get un solo pago
	public Optional<Payment> findPaymentById(Long id) {
		return paymentRepository.findById(id);
	}
	
	//Post
	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	//Put
	public Payment replaceUser(Payment newPayment, Long id) {
		return paymentRepository.findById(id)
				.map(payment -> {
					payment.setPaymentDate(newPayment.getPaymentDate());
					payment.setAmount(newPayment.getAmount());
					payment.setStatus(newPayment.getStatus());
					return paymentRepository.save(payment);
				}) 
				.orElseGet(() -> {
					return paymentRepository.save(newPayment);
				});	
	}
	
	//Delete un pago
	public void deletePaymentById(Long id) {
		paymentRepository.deleteById(id);
	}
	
}
