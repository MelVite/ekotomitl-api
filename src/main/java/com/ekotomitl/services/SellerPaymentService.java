package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.SellerPayment;
import com.ekotomitl.repositories.SellerPaymentRepository;

@Service
public class SellerPaymentService {
	@Autowired
	private SellerPaymentRepository sellerPaymentRepository;
	
	//Get todos los pagos de usuario
	public List<SellerPayment> findAllSellerPayment() {
		return sellerPaymentRepository.findAll();
	}

	//Get un solo pago de usuario
	public Optional<SellerPayment> findSellerPaymentById(Long id) {
		return sellerPaymentRepository.findById(id);
	}
	
	//Post
	public SellerPayment saveSellerPayment(SellerPayment sellerPayment) {
		return sellerPaymentRepository.save(sellerPayment);
	}
	
	//Put
	public SellerPayment replaceSellerPayment(SellerPayment newSellerPayment, Long id) {
		return sellerPaymentRepository.findById(id)
				.map(sellerPayment -> {
					sellerPayment.setPaymentDate(newSellerPayment.getPaymentDate());
					sellerPayment.setAmount(newSellerPayment.getAmount());
					sellerPayment.setStatus(newSellerPayment.getStatus());
					return sellerPaymentRepository.save(sellerPayment);
				})
				.orElseGet(() -> {
					return sellerPaymentRepository.save(newSellerPayment);
				});
	}
	
	//Delete un pago de usuario
	public void deleteSellerPaymentById(Long id) {
		sellerPaymentRepository.deleteById(id);
	}
		

}
