package com.example.banque.metier;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.banque.entities.Comptes;
import com.example.banque.entities.Operations;

public interface IBanqueMetier {
	
	public Comptes consulterCompte(String codecompte);
	public void verser(String codecompte,double montant);
	public void retirer(String codecompte,double montant);
	public void virement(String codecompte1,String codecompte2, double montant);
	Page<Operations> listOperation(String codecompte, int page, int size);
	


}
