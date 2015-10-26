package org.ministere.annuaire.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.ministere.annuaire.editor.FonctionEditor;
import org.ministere.annuaire.entities.Employe;
import org.ministere.annuaire.entities.Fonction;
import org.ministere.annuaire.metier.IAdminMetier;
import org.ministere.annuaire.model.RechercheForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/recherche")
public class RechercheController {

	/*@PersistenceContext
	private EntityManager em;*/

	@Autowired
	private IAdminMetier metier;

	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Fonction.class, new FonctionEditor(metier));
	}*/

	
	
	@RequestMapping(value = "/index")
	public String index(Model model) {

		model.addAttribute("rechercherForm", new RechercheForm());
		model.addAttribute("employes", metier.listEmploye());
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());

		return "annuaire";
	}

	@RequestMapping(value = "/rechEmp")
	public String recherche(@Valid RechercheForm empf, Model model) {
		if ((empf.getCodeEmploye().isEmpty())&&(empf.getCodeDirection() <2)&& (empf.getCodeService() <2)&& (empf.getCodeFonction() <2) )
		{
			model.addAttribute("rechercherForm", new RechercheForm());
			model.addAttribute("employes", metier.listEmploye());
			model.addAttribute("direction", metier.listDirection());
			model.addAttribute("service", metier.listService());
			model.addAttribute("fonction", metier.listFonction());

			return "annuaire";
		} else{
			try {
				model.addAttribute("employes", metier.Recherche(empf.getCodeEmploye(),
						empf.getCodeDirection(), empf.getCodeService(),
						empf.getCodeFonction()));
			} catch (Exception e) {
				empf.setException(e.getMessage());
			}
		
		
		model.addAttribute("rechercherForm", new RechercheForm());
		// model.addAttribute("employes",
		// metier.EmployeParMotCle(empf.getCodeEmploye()));
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());

		return "annuaire";
		}

	}

	@RequestMapping(value = "photoEmp", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoEmp(Long idEmp) throws IOException {
		Employe e = metier.getEmploye(idEmp);
		File f = new File(System.getProperty("java.io.tmpdir") + "/EMP_"
				+ idEmp + "_" + e.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));

	}

}
