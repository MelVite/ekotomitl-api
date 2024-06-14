package com.ekotomitl.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_profile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iduser_profile", nullable=false)
	private int idUserProfile;
	
	@OneToOne
	@JoinColumn(name="user_iduser") //Llave foranea con user
	private User user;

	//Constructor vacio
	public UserProfile() {
		super();
	}

	//Constructor
	public UserProfile(int idUserProfile, User user) {
		super();
		this.idUserProfile = idUserProfile;
		this.user = user;
	}

	public int getIdUserProfile() {
		return idUserProfile;
	}

	public void setIdUserProfile(int idUserProfile) {
		this.idUserProfile = idUserProfile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserProfile [idUserProfile=" + idUserProfile + ", user=" + user + "]";
	}
	
	

}
