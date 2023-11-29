package com.example.banque.metier;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.banque.dao.CompteRepository;
import com.example.banque.dao.OperationsRepository;
import com.example.banque.entities.CompteCourant;
import com.example.banque.entities.Comptes;
import com.example.banque.entities.Operations;
import com.example.banque.entities.Retrait;
import com.example.banque.entities.Versement;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Banquemetier implements IBanqueMetier {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationsRepository operationsrepository;
	
	@Override
	public Comptes consulterCompte(String codecompte) {
	    Optional<Comptes> optionalComptes = compteRepository.findById(codecompte);
	    return optionalComptes.orElseThrow(() -> new RuntimeException("Compte Introuvable"));
	}
	
	@Override
	public void verser(String codecompte, double montant) {
	    Comptes cp = consulterCompte(codecompte);
	    Versement v = new Versement(new Date(),montant,cp);
	    operationsrepository.save(v);
	    cp.setSolde(cp.getSolde() + montant);
	    compteRepository.save(cp);
	}

	@Override
	public void retirer(String codecompte, double montant) {
	    Comptes cp=consulterCompte(codecompte);
	    double facilitesCaisse=0;
	    if(cp instanceof CompteCourant)
	    	facilitesCaisse=((CompteCourant) cp).getDecouvert();
	    if(cp.getSolde()+facilitesCaisse<montant)
	    	throw new RuntimeException("Solde insuffisant");
	       Retrait r=new Retrait(new Date(),montant,cp);
	       operationsrepository.save(r);
	       cp.setSolde(cp.getSolde()-montant);
	       compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codecompte1, String codecompte2, double montant) {
		retirer(codecompte1,montant);
		verser(codecompte2,montant);
		
	}

	@Override
	
	public Page<Operations> listOperation(String codecompte, int page, int size) {
	    return operationsrepository.listOperation(codecompte, PageRequest.of(page, size));
	}
}



 

