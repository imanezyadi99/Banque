package com.example.banque.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("R")

public class Retrait extends Operations {

	public Retrait() {
		super();
	}

	public Retrait( Date datecreation, double montant, Comptes compte) {
		super( datecreation, montant, compte);
	}

}
