package com.ekotomitl.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpayment", nullable=false)
    private int idPayment;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate; //Revisar las fechas

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "status", nullable = false, length = 30)
    private String status;
    
    @OneToOne(mappedBy="payment") //Relación con order
    private Orders order;

    //Constructor vacio
	public Payment() {
		super();
	}

	public Payment(int idPayment, LocalDate paymentDate, double amount, String status, Orders order) {
		super();
		this.idPayment = idPayment;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.status = status;
		this.order = order;
	}

	public int getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
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

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Payment [idPayment=" + idPayment + ", paymentDate=" + paymentDate + ", amount=" + amount + ", status="
				+ status + ", order=" + order + "]";
	}
	

}
