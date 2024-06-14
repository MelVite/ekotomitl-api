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
@Table(name = "product")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idproduct", nullable=false)
    private int idproduct;

	@ManyToOne
    @JoinColumn(name="category_idcategory") //Se elimina nullable
    private Category category; //Referencia a la tabla Category -> Forean Key

    @Column(name="product_name", nullable=false, length=45)
    private String product_name;

    @Column(name="description", nullable=false, length=45)
    private String descripcion;

    @Column(name="price", nullable=false)
    private double price;

    @Column(name="discount")
    private double discount;

    @ManyToOne
    @JoinColumn(name="seller_idseller") //Llave foranea con seller
    private Seller seller;

    //Constructor vacio
	public Product() {
		super();
	}

	public Product(int idproduct, Category category, String product_name, String descripcion, double price,
			double discount, Seller seller) {
		super();
		this.idproduct = idproduct;
		this.category = category;
		this.product_name = product_name;
		this.descripcion = descripcion;
		this.price = price;
		this.discount = discount;
		this.seller = seller;
	}

	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [idproduct=" + idproduct + ", category=" + category + ", product_name=" + product_name
				+ ", descripcion=" + descripcion + ", price=" + price + ", discount=" + discount + ", seller=" + seller
				+ "]";
	}
	
    
}
