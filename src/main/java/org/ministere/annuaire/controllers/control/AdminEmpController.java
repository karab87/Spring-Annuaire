package org.ministere.annuaire.controllers.control;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


import org.ministere.annuaire.editor.FonctionEditor;
import org.ministere.annuaire.entities.Employe;
import org.ministere.annuaire.entities.Fonction;
import org.ministere.annuaire.metier.IAdminMetier;
import org.ministere.annuaire.model.EmployeForm;




@Controller
@RequestMapping("/adminEmp")
public class AdminEmpController implements HandlerExceptionResolver{
	@Autowired
	private IAdminMetier metier;
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Fonction.class, new FonctionEditor(metier));
	}
    
	
	
	@RequestMapping(value="/index")
	public String index(Model model){
		
		model.addAttribute("employeForm", new EmployeForm());
		model.addAttribute("employes", metier.listEmploye());
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());
		
		return "employes";
		
	}
	
	@RequestMapping(value="/saveEmp")
	public String saveEmp(@Valid EmployeForm e,BindingResult bindingResult, Model model, MultipartFile file ) throws IOException{
		
		if(bindingResult.hasErrors()){
			
			model.addAttribute("employes", metier.listEmploye());
			model.addAttribute("direction", metier.listDirection());
			model.addAttribute("service", metier.listService());
			model.addAttribute("fonction", metier.listFonction());
			
			return "employes";
		}
		
		if(!file.isEmpty()){
			String path=System.getProperty("java.io.tmpdir");
			e.getEmploye().setPhoto(file.getOriginalFilename());
			BufferedImage bi = ImageIO.read(file.getInputStream());
			
			Long idEmp=null;
			if(e.getEmploye().getIdEmploye()==null){
				idEmp = metier.ajouterEmploye(e.getEmploye(), e.getEmploye().getDirection().getIdDirection(), e.getEmploye().getService().getIdService()); 
			}
			else {
				metier.modifierEmploye(e.getEmploye());
				idEmp=e.getEmploye().getIdEmploye();
			}
			//Long idP = metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
			file.transferTo(new File(path+"/"+"EMP_"+idEmp+"_"+file.getOriginalFilename()));
		}
		else{
			if(e.getEmploye().getIdEmploye()==null){
				metier.ajouterEmploye(e.getEmploye(), e.getEmploye().getDirection().getIdDirection(), e.getEmploye().getService().getIdService());
			
			}else metier.modifierEmploye(e.getEmploye());
			
			
		}
		model.addAttribute("employeForm", new EmployeForm());
		model.addAttribute("employes", metier.listEmploye());
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());
		return "employes";
	}
		
		@RequestMapping(value="photoEmp", produces=MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public byte[] photoEmp(Long idEmp) throws IOException{
			Employe e = metier.getEmploye(idEmp);
			File f = new File(System.getProperty("java.io.tmpdir")+"/EMP_"+idEmp+"_"+e.getPhoto());
			return IOUtils.toByteArray(new FileInputStream(f));
		
	}
	
	@RequestMapping(value="/suppEmp")
	public String supp(Long idEmp, Model model){
		metier.supprimerEmploye(idEmp);
		model.addAttribute("employeForm", new EmployeForm());
		model.addAttribute("employes", metier.listEmploye());
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());
		return "employes";
	}
	
	@RequestMapping(value="/editEmp")
	public String edit(@Valid EmployeForm ef, Long idEmp, Model model){
		Employe e = metier.getEmploye(idEmp);
		ef.setEmploye(e);
		model.addAttribute("employeForm", ef);
		model.addAttribute("employes", metier.listEmploye());
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());
		return "employes";
	}
	
	@RequestMapping(value="/rechEmp")
	public String recherche(@Valid EmployeForm empf, Model model ){
		if(empf.getCodeEmploye()==null){
			
			model.addAttribute("employes", metier.listEmploye());
			model.addAttribute("direction", metier.listDirection());
			model.addAttribute("service", metier.listService());
			model.addAttribute("fonction", metier.listFonction());
			
			return"employes";
		}
		else{
		model.addAttribute("employeForm", new EmployeForm());
		model.addAttribute("employes", metier.EmployeParMotCle(empf.getCodeEmploye()));
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());
		return "employes";
		
	}
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", ex.getMessage());
		mv.addObject("employeForm", new EmployeForm());
		mv.addObject("employes", metier.listEmploye());
		mv.setViewName("employes");
		return mv;
	}
	
	
	

	
	


}
