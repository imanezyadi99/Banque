package com.example.banque.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement  extends Operations {
	

	    
	public Versement() {
		super();
	}
	
	

	
	public Versement(Date datecreation, double montant, Comptes compte) {
		super(datecreation, montant, compte);
	}


}
