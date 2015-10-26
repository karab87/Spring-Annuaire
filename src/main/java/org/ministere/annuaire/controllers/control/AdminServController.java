package org.ministere.annuaire.controllers.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;


import org.ministere.annuaire.editor.DirectionEditor;
import org.ministere.annuaire.entities.*;
import org.ministere.annuaire.metier.IAdminMetier;
import org.ministere.annuaire.model.ServiceForm;

@Controller
@RequestMapping("/adminServ")
public class AdminServController {
	@Autowired
	private IAdminMetier metier;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Direction.class, new DirectionEditor(metier));
	}
	
	@RequestMapping(value="/index")
	public String index(Model model){
		
		model.addAttribute("serviceForm", new ServiceForm());
		model.addAttribute("directions", metier.listDirection());
		model.addAttribute("services", metier.listService());
		return "services";
		
	}
	
	@RequestMapping(value="/saveServ")
	public String saveDir(@Valid ServiceForm s,BindingResult bindingResult, Model model ){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("services", metier.listService());
			return("services");
		}
		if(s.getService().getNomService()!=null){
			metier.modifierService(s.getService());
			
		}
		else{
			metier.ajouterService(s.getService());
			metier.ajouterServiceTodDirection(s.getService().getIdService(), s.getDirect().getIdDirection());
		
		}
		model.addAttribute("serviceForm", new ServiceForm());
		model.addAttribute("directions", metier.listDirection());
		model.addAttribute("services", metier.listService());
		return "services";
		
	}
	@RequestMapping(value="/suppServ")
	public String supp(Long idServ, Model model ){
		
		metier.supprimerService(idServ);
		model.addAttribute("serviceForm", new ServiceForm());
		model.addAttribute("directions", metier.listDirection());
		model.addAttribute("services", metier.listService());
		return "services";
		
	}
	
	@RequestMapping(value="/editServ")
	public String edit(@Valid ServiceForm s, Long idServ, Model model ){
		Service sv = metier.getService(idServ);
		s.setService(sv);
		model.addAttribute("serviceForm", s);
		model.addAttribute("directions", metier.listDirection());
		model.addAttribute("services", metier.listService());
		return "services";
		
	}
	
	@RequestMapping(value="/rechServ")
	public String recherche(@Valid ServiceForm sf,BindingResult bindingResult, Model model ){
		
		if(sf.getCodeService()==null){
			model.addAttribute("services", metier.listService());
			return"services";
		}
		else{
		
		try {
			model.addAttribute("services", metier.ServiceParMotCle(sf.getCodeService()));
		} catch (Exception e) {
			sf.setException(e.getMessage());
		}
		model.addAttribute("serviceForm", sf);
		model.addAttribute("directions", metier.listDirection());
		return "services";
		}
		
	}


	

}