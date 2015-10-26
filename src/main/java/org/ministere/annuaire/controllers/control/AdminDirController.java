package org.ministere.annuaire.controllers.control;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


import org.ministere.annuaire.entities.Direction;
import org.ministere.annuaire.metier.IAdminMetier;
import org.ministere.annuaire.model.DirectionForm;



@Controller
@RequestMapping("/adminDir")
public class AdminDirController  {
	@Autowired
	private IAdminMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		
		model.addAttribute("directionForm", new DirectionForm());
		model.addAttribute("directions", metier.listDirection());
		return "directions";
		
	}
	
	

	@RequestMapping(value="/saveDir")
	public String saveDir(@Valid DirectionForm fd,BindingResult bindingResult, Model model ){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("directions", metier.listDirection());
			return"directions";
		}
		
		
		if(fd.getDirection().getIdDirection()!=null){
			metier.modifierDirection(fd.getDirection());
		}
		else
		metier.ajouterDirection(fd.getDirection());
		model.addAttribute("directionForm", new DirectionForm());
		model.addAttribute("directions", metier.listDirection());
		return "directions";
		
	}
	@RequestMapping(value="/suppDir")
	public String supp(Long idDir, Model model ){
		
		metier.supprimerDirection(idDir);
		model.addAttribute("directionForm", new DirectionForm());
		model.addAttribute("directions", metier.listDirection());
		return "directions";
		
	}
	
	@RequestMapping(value="/editDir")
	public String edit(@ Valid DirectionForm df, Long idDir, Model model ){
		Direction d = metier.getDirection(idDir);
		df.setDirection(d);
		model.addAttribute("directionForm", df);
		model.addAttribute("directions", metier.listDirection());
		return "directions";
		
	}
	
	@RequestMapping(value="/rechDir")
	public String recherche(DirectionForm df, Model model ){
		if(df.getCodeDirection()==null){
			model.addAttribute("directions", metier.listDirection());
			return"directions";
		}
		else{
		
		try {
			model.addAttribute("directions", metier.DirectionParMotCle(df.getCodeDirection()));
		} catch (Exception e) {
			df.setException(e.getMessage());
			
		}
		model.addAttribute("directionForm", df);
		return "directions";
		
	}
	}
	
	
	
}