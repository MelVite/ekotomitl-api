package com.ekotomitl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekotomitl.models.Payment;
import com.ekotomitl.services.PaymentService;

@RestController
@RequestMapping("/payment/")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	//Get all
	@GetMapping
	public List<Payment> getAllPayment() {
		return paymentService.findAllPayment();
	}
	
	//Get regresa un JSON valido
	@GetMapping("{id}") //Solicita una id para filtrar
	public ResponseEntity<Payment> getPaymentById (@PathVariable Long id) {
		return paymentService.findPaymentById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Post
	@PostMapping
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}
	
	//Put
	@PutMapping("{id}")
	public Payment updatePayment(@RequestBody Payment newPayment, @PathVariable Long id) {
		return paymentService.replaceUser(newPayment, id);
	}
	
	//Delete
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable("id") Long id) {
		return paymentService.findPaymentById(id)
				.map(payment -> {
					paymentService.deletePaymentById(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
