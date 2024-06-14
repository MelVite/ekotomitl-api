package com.ekotomitl.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="seller_payment")
public class SellerPayment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idseller_payment", nullable=false)
	private int idseller_payment;
	 
	@ManyToOne
	@JoinColumn(name="seller_idseller", nullable=false) //LLave foranea de seller
	private Seller seller;
	  
	@Column (name="payment_date", nullable=false)
	private LocalDate paymentDate;
	  
	@Column (name="amount", nullable=false)
	private double amount;
	  
	@Column (name="status", nullable=false)
	private String status;

	//Constructor vacío
	public SellerPayment() {
		super();
	}

	public SellerPayment(int idseller_payment, Seller seller, LocalDate paymentDate, double amount, String status) {
		super();
		this.idseller_payment = idseller_payment;
		this.seller = seller;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.status = status;
	}

	public int getIdseller_payment() {
		return idseller_payment;
	}

	public void setIdseller_payment(int idseller_payment) {
		this.idseller_payment = idseller_payment;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SellerPayment [idseller_payment=" + idseller_payment + ", seller=" + seller + ", paymentDate="
				+ paymentDate + ", amount=" + amount + ", status=" + status + "]";
	}
	
	
}
