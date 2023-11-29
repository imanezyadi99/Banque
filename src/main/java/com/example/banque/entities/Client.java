package com.example.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client implements Serializable {
	
	@Id @GeneratedValue
	private Long code;
	private String nom;
	private String email;
	
	@OneToMany(mappedBy="client", cascade = CascadeType.PERSIST)
	private Collection<Comptes>comptes;

	public Client() {
		super();
	}

	public Client( String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}

	

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Comptes> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Comptes> comptes) {
		this.comptes = comptes;
	}
	

}
