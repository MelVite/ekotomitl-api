package com.ekotomitl.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idorder", nullable=false)
	private int idorder;
	
	@Column(name="order_date", nullable=false )
	private LocalDate order_date;

	@Column (name="total")
	private double total;

	@Column (name="status",nullable=false,length=225)
	private String status;

	@ManyToOne
	@JoinColumn (name="buyer_idbuyer",nullable=false) //Llave foranea con buyer
	private Buyer buyer;//Llave primaria

	@OneToOne
	@JoinColumn (name="payment_idpayment") //Llave foranea con payment
	private Payment payment;

	//Constructor vacio
	public Orders() {
		super();
	}

	public Orders(int idorder, LocalDate order_date, double total, String status, Buyer buyer, Payment payment) {
		super();
		this.idorder = idorder;
		this.order_date = order_date;
		this.total = total;
		this.status = status;
		this.buyer = buyer;
		this.payment = payment;
	}

	public int getIdorder() {
		return idorder;
	}

	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Orders [idorder=" + idorder + ", order_date=" + order_date + ", total=" + total + ", status=" + status
				+ ", buyer=" + buyer + ", payment=" + payment + "]";
	}
	

}
