package org.ministere.annuaire.controllers.control;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;



import org.ministere.annuaire.entities.*;
import org.ministere.annuaire.metier.IAdminMetier;
import org.ministere.annuaire.model.FonctionForm;

@Controller
@RequestMapping("/adminFonc")
public class AdminFoncController {
	@Autowired
	private IAdminMetier metier;
	
	@RequestMapping(value="/index")
	public String index( Model model){
		
		model.addAttribute("fonctionForm", new FonctionForm());
		model.addAttribute("fonctions", metier.listFonction());
		return "fonctions";
		
	}
	
	@RequestMapping(value="/saveFonc")
	public String save(@Valid FonctionForm f,BindingResult bindingResult, Model model ){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("fonctions", metier.listFonction());
			return("fonctions");
		}
		if(f.getFonction().getIdFonction()!=null){
			metier.modifierFonction(f.getFonction());
		}
		else
		metier.ajouterFonction(f.getFonction());
		model.addAttribute("fonctionForm", new FonctionForm());
		model.addAttribute("fonctions", metier.listFonction());
		return "fonctions";
		
	}
	@RequestMapping(value="/suppFonc")
	public String supp(Long idFonc, Model model ){
		
		metier.supprimerFonction(idFonc);
		model.addAttribute("fonctionForm", new FonctionForm());
		model.addAttribute("fonctions", metier.listFonction());
		return "fonctions";
		
	}
	
	@RequestMapping(value="/editFonc")
	public String edit(@Valid FonctionForm f, Long idFonc, Model model ){
		Fonction fc = metier.getFonction(idFonc);
		f.setFonction(fc);
		model.addAttribute("fonctionForm", f);
		model.addAttribute("fonctions", metier.listFonction());
		return "fonctions";
		
	}
	
	@RequestMapping(value="/rechFonc")
	public String recherche(@Valid FonctionForm f,BindingResult bindingResult, Model model ){
		
		if(f.getCodeFonction()==null){
			model.addAttribute("fonctions", metier.listFonction());
			return"fonctions";
		}
		else{
		
		try {
			model.addAttribute("fonctions", metier.FonctionParMotCle(f.getCodeFonction()));
		} catch (Exception e) {
			
			f.setException(e.getMessage());
			
		}
		model.addAttribute("fonctionForm", f);
		return "fonctions";
		}
		
	}
	
	

	

}
