package com.ekotomitl.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iduser")
	private int iduser;
	
	@Column(name="user_fname", nullable=false, length=45)
	private String user_fname;
	
	@Column(name="user_lname", nullable=false, length=45)
	private String user_lname;
	
	@Column(name="email", nullable=false, length=45)
	private String email;
	
	@Column(name="phone", nullable=false, length=10)
	private int phone;
	
	@Column(name="adress", nullable=false, length=80)
	private String adress;
	
	@OneToOne(mappedBy="user") //Relación con user profile
	private UserProfile userProfile;
	
	@OneToOne(mappedBy="user") //Relación con buyer
	private Buyer buyer;
	
	@OneToOne(mappedBy="user") // Relación con seller
	private Seller seller;
	
	//Constructor vacío
	public User() {
		super();
	}

	public User(int iduser, String user_fname, String user_lname, String email, int phone, String adress,
			UserProfile userProfile, Buyer buyer, Seller seller) {
		super();
		this.iduser = iduser;
		this.user_fname = user_fname;
		this.user_lname = user_lname;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.userProfile = userProfile;
		this.buyer = buyer;
		this.seller = seller;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getUser_fname() {
		return user_fname;
	}

	public void setUser_fname(String user_fname) {
		this.user_fname = user_fname;
	}

	public String getUser_lname() {
		return user_lname;
	}

	public void setUser_lname(String user_lname) {
		this.user_lname = user_lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", user_fname=" + user_fname + ", user_lname=" + user_lname + ", email="
				+ email + ", phone=" + phone + ", adress=" + adress + ", userProfile=" + userProfile + ", buyer="
				+ buyer + ", seller=" + seller + "]";
	}

	
}
