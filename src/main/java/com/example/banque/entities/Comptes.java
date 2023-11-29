package com.example.banque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
public  abstract class Comptes implements Serializable {
	@Id
	private String codecompte;
	private Date datecreation;
	private double solde;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
	@OneToMany(mappedBy="compte")
	private Collection<Operations>operations;

	public Comptes() {
		super();
	}

	public Comptes(String codecompte, Date datecreation, double solde, Client client) {
		super();
		this.codecompte = codecompte;
		this.datecreation = datecreation;
		this.solde = solde;
		this.client = client;
	}

	public String getCodecompte() {
		return codecompte;
	}

	public void setCodecompte(String Codecompte) {
		this.codecompte = Codecompte;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double d) {
		this.solde = d;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Operations> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operations> operations) {
		this.operations = operations;
	}
	

}
