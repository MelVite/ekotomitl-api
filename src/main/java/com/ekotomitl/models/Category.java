package com.ekotomitl.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategory", nullable=false)
    private int idcategory; //Llave primaria
	
	@Column(name="category_name", nullable=false, length=45)
	private String category_name;
	
	@OneToMany(mappedBy = "category") //Relación con product
    private Set<Product> product;

	//Constructor vacío
	public Category() {
		super();
	}
	
	// Constructor que acepta solo idcategory
    @JsonCreator
    public Category(@JsonProperty("idcategory") int idcategory) {
        this.idcategory = idcategory;
    }

	public Category(int idcategory, String category_name, Set<Product> product) {
		super();
		this.idcategory = idcategory;
		this.category_name = category_name;
		this.product = product;
	}

	public int getIdcategory() {
		return idcategory;
	}

	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [idcategory=" + idcategory + ", category_name=" + category_name + ", product=" + product + "]";
	}
	

}
