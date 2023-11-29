package com.example.banque.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CE")

public class CompteEpargne extends Comptes {
	
	private double taux;

	public CompteEpargne() {
		super();
	}


	public double getTaux() {
		return taux;
	}


	public void setTaux(double taux) {
		this.taux = taux;
	}


	public CompteEpargne(String codecompte, Date datecreation, double solde, Client client, double taux) {
		super(codecompte, datecreation, solde, client);
		this.taux = taux;
	}





	


}
