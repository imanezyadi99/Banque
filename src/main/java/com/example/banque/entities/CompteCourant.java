package com.example.banque.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CC")

public class CompteCourant extends Comptes {
	
	private double decouvert;

	public CompteCourant() {
		super();
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourant(String codecompte, Date datecreation, float solde, Client client, double decouvert) {
		super(codecompte, datecreation, solde, client);
		this.decouvert = decouvert;
	}

}
