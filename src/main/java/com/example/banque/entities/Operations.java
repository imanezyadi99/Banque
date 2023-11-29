package com.example.banque.entities;

import java.io.Serializable;
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


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OPT",discriminatorType=DiscriminatorType.STRING,length=2)
public  abstract class Operations implements Serializable {
	

    @Id @GeneratedValue
	private Long numoperation;
	private Date datecreation;
	private double montant;
    private String codecompte;

	
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Comptes compte;

	public Operations() {
		super();
	}

	public Operations(Date datecreation, double montant, Comptes compte) {
		super();
		this.numoperation=numoperation;
		this.datecreation = datecreation;
		this.montant = montant;
		this.compte = compte;
	}

	public Long getNumoperation() {
		return numoperation;
	}

	public void setNumoperation(Long numoperation) {
		this.numoperation = numoperation;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Comptes getCompte() {
		return compte;
	}

	public String getCodecompte() {
		return codecompte;
	}

	public void setCodecompte(String codecompte) {
		this.codecompte = codecompte;
	}

	public void setCompte(Comptes compte) {
		this.compte = compte;
	}

	

}
