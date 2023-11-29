package com.example.banque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.banque.entities.Comptes;
import com.example.banque.entities.Operations;
import com.example.banque.metier.IBanqueMetier;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banquemetier;
	
      @RequestMapping("/operations")
      public String index() {
    	  return "comptes";
      }
      
      
      @RequestMapping("/consulterCompte")
      public String consulter(Model model,String codecompte) {
    	  try {
    		  Comptes cp=banquemetier.consulterCompte(codecompte);
    		  Page<Operations> pageOperations=banquemetier.listOperation(codecompte, 0, 5);
    		  model.addAttribute("listOperations",pageOperations.getContent());
    		  model.addAttribute("compte",cp);
    	  }catch(Exception e) {
    		  model.addAttribute("exception",e);

    	  }
    	  return "comptes";
      }
      
      @RequestMapping(value = "/saveOperation", method = RequestMethod.POST)
      public String saveOperation(Model model, String typeOperation, String codecompte, String codecompte2, double montant) {
          try {
              if (typeOperation != null && !typeOperation.isEmpty()) {
                  if (typeOperation.equals("VERS")) {
                      banquemetier.verser(codecompte, montant);
                  } else if (typeOperation.equals("RETR")) {
                      banquemetier.retirer(codecompte, montant);
                  } else if (typeOperation.equals("VIR")) {
                      banquemetier.virement(codecompte, codecompte2, montant);
                  }

                  // Ajoutez ici d'autres traitements si nécessaire

                  // Redirigez vers la page des comptes après l'opération
                  return "redirect:/consulterCompte?codecompte=" + codecompte;

              } else {
                  // Si typeOperation est null ou vide, gérer cela ici (par exemple, renvoyer un message d'erreur)
                  return "redirect:/erreur";
              }
          } catch (Exception e) {
              e.printStackTrace();
              model.addAttribute("exception", e);
              // Gérez l'exception comme vous le souhaitez, par exemple, redirigez vers une page d'erreur
              return "redirect:/erreur";
          }
      }
}
