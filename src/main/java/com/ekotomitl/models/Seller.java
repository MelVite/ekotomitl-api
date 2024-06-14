package com.ekotomitl.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="seller")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idseller", nullable=false)
	private int idseller;
	
	@OneToOne
	@JoinColumn(name="user_iduser") //Llave foranea con user
	private User user;
	
	@OneToMany(mappedBy="seller") //Relación con product
	private Set<Product> product;
	
	@OneToMany(mappedBy="seller") //Relación con seller payment
	private Set<SellerPayment> sellerPayment;
	
	//Controlador vacio
	public Seller() {
		super();
	}

	public Seller(int idseller, User user, Set<Product> product, Set<SellerPayment> sellerPayment) {
		super();
		this.idseller = idseller;
		this.user = user;
		this.product = product;
		this.sellerPayment = sellerPayment;
	}

	public int getIdseller() {
		return idseller;
	}

	public void setIdseller(int idseller) {
		this.idseller = idseller;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public Set<SellerPayment> getSellerPayment() {
		return sellerPayment;
	}

	public void setSellerPayment(Set<SellerPayment> sellerPayment) {
		this.sellerPayment = sellerPayment;
	}

	@Override
	public String toString() {
		return "Seller [idseller=" + idseller + ", user=" + user + ", product=" + product + ", sellerPayment="
				+ sellerPayment + "]";
	}
	
	

}
