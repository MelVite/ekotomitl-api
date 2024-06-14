package com.ekotomitl.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_has_product")
public class CartHasProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcart_has_product", nullable=false)
	private int idCartHasProduct; //LLave primaria de la tabla
	
	@ManyToOne
    @JoinColumn(name = "cart_idcart") //Llave foranea con cart
    private Cart cart;
	
	@ManyToOne
    @JoinColumn(name = "cart_buyer_idbuyer") //Llave foranea del carrito y a su vez del buyer
    private Buyer buyer;
	
	@ManyToOne
    @JoinColumn(name = "product_idproduct") //Llave foranea con product
    private Product product;
	
	@ManyToOne
    @JoinColumn(name = "product_category_idcategory1") //Llave foranea con product y a su vez con categoría
    private Category category;

	//Constructor vacío
	public CartHasProduct() {
		super();
	}

	//Constructor
	public CartHasProduct(int id, Cart cart, Buyer buyer, Product product, Category category) {
		super();
		this.idCartHasProduct = id;
		this.cart = cart;
		this.buyer = buyer;
		this.product = product;
		this.category = category;
	}

	public int getId() {
		return idCartHasProduct;
	}

	public void setId(int id) {
		this.idCartHasProduct = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CartHasProduct [idCartHasProduct=" + idCartHasProduct + ", cart=" + cart + ", buyer=" + buyer
				+ ", product=" + product + ", category=" + category + "]";
	}
	

}
