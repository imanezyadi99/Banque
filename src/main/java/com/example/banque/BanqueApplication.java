package com.example.banque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.banque.dao.ClientRepository;
import com.example.banque.dao.CompteRepository;
import com.example.banque.dao.OperationsRepository;
import com.example.banque.entities.Client;
import com.example.banque.entities.CompteCourant;
import com.example.banque.entities.CompteEpargne;
import com.example.banque.entities.Comptes;
import com.example.banque.entities.Operations;
import com.example.banque.entities.Retrait;
import com.example.banque.entities.Versement;
import com.example.banque.metier.IBanqueMetier;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner {
	
  @Autowired
  private ClientRepository clientrepository;
  
  @Autowired
  private CompteRepository compterepository;
  
  @Autowired
  private OperationsRepository operationrepository;
  
  @Autowired
  private IBanqueMetier banquemetier;
  
	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	Client c1=	clientrepository.save(new Client("imane","imane@gmail.com"));
	Client c2=	clientrepository.save(new Client("zaina","zaina@gmail.com"));

	
	Comptes cp1=compterepository.save(new CompteCourant("c1",new Date(),9000,c1,6000));
	Comptes cp2=compterepository.save(new CompteEpargne("c2",new Date(),6000,c2,5.5));

	operationrepository.save(new Versement(new Date(),9000,cp1));
	 operationrepository.save(new Versement(new Date(),5000,cp1));
	operationrepository.save(new Versement(new Date(),4000,cp1));
	operationrepository.save(new Retrait(new Date(),2000,cp1));

	operationrepository.save(new Retrait(new Date(),6000,cp2));
	operationrepository.save(new Versement(new Date(),6000,cp2));
	operationrepository.save(new Versement(new Date(),8000,cp2));
	operationrepository.save(new Retrait(new Date(),1000,cp2));
	
	
	banquemetier.verser("c1",5000);
	

	

}
}
