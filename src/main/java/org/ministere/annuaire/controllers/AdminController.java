package org.ministere.annuaire.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.ministere.annuaire.editor.DirectionEditor;
import org.ministere.annuaire.editor.FonctionEditor;
import org.ministere.annuaire.entities.Direction;
import org.ministere.annuaire.entities.Employe;
import org.ministere.annuaire.entities.Fonction;
import org.ministere.annuaire.entities.Service;
import org.ministere.annuaire.metier.IAdminMetier;
import org.ministere.annuaire.model.DirectionForm;
import org.ministere.annuaire.model.EmployeForm;
import org.ministere.annuaire.model.FonctionForm;
import org.ministere.annuaire.model.ServiceForm;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController implements HandlerExceptionResolver {

	@Autowired
	private IAdminMetier metier;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Fonction.class, new FonctionEditor(metier));
		binder.registerCustomEditor(Direction.class, new DirectionEditor(metier));
	}
	
	
	@RequestMapping("/dirDoubons")
	@org.springframework.web.bind.annotation.ResponseBody
	public String presentDir(@org.springframework.web.bind.annotation.RequestParam String nom) {
		Boolean presentDir = metier.DirectionUniqueParMotCle(nom) == null;
		return presentDir.toString();
	}
	@RequestMapping("/servDoubons")
	@org.springframework.web.bind.annotation.ResponseBody
	public String presentServ(@org.springframework.web.bind.annotation.RequestParam String nom) {
		Boolean presentServ = metier.ServiceUniqueParMotCle(nom) == null;
		return presentServ.toString();
	}
	
	@RequestMapping("/foncDoubons")
	@org.springframework.web.bind.annotation.ResponseBody
	public String presentFonc(@org.springframework.web.bind.annotation.RequestParam String nom) {
		Boolean presentFonc = metier.FonctionUniqueParMotCle(nom) == null;
		return presentFonc.toString();
	}
	@RequestMapping("/empDoubons")
	@org.springframework.web.bind.annotation.ResponseBody
	public String presentEmp(@org.springframework.web.bind.annotation.RequestParam String nom) {
		Boolean presentEmp = metier.EmployeUniqueParMotCle(nom) == null;
		return presentEmp.toString();
	}
	
	
	

	@RequestMapping(value = "/directions")
	public String indexDir(Model model) {
		model.addAttribute("directionForm", new DirectionForm());
		model.addAttribute("direction", new Direction());
		model.addAttribute("directions", metier.listDirection());
		return "directions";

	}
	
	
	@RequestMapping(value = "/saveDir")
	public String saveDir(@Valid Direction fd, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("directionForm", new DirectionForm());
			model.addAttribute("directions", metier.listDirection());
			return "directions";
		}

		if (fd.getIdDirection() != null) {
			metier.modifierDirection(fd);
			
		} else
			metier.ajouterDirection(fd);
		redirectAttributes.addFlashAttribute("save", true);
		model.addAttribute("directionForm", new DirectionForm());
		model.addAttribute("direction", new Direction());
		model.addAttribute("directions", metier.listDirection());
		return "redirect:/admin/directions";

	}
	
	

	@RequestMapping(value = "/suppDir")
	public String suppDir(Long idDir, Model model, RedirectAttributes redirectAttributes) {

		metier.supprimerDirection(idDir);
		redirectAttributes.addFlashAttribute("suppr", true);
		model.addAttribute("directionForm", new DirectionForm());
		model.addAttribute("direction", new Direction());
		model.addAttribute("directions", metier.listDirection());
		return "redirect:/admin/directions";
		

	}

	@RequestMapping(value = "/editDir")
	public String editDir( Long idDir, Model model) {
		Direction d = metier.getDirection(idDir);
		
		model.addAttribute("direction", d);
		model.addAttribute("directions", metier.listDirection());
		model.addAttribute("directionForm", new DirectionForm());
		return "directions";

	}

	@RequestMapping(value = "/rechDir")
	public String rechercheDir(DirectionForm df, Model model) {
		if (df.getCodeDirection() == null) {
			model.addAttribute("directions", metier.listDirection());
			return "directions";
		} else {

			try {
				model.addAttribute("directions",
						metier.DirectionParMotCle(df.getCodeDirection()));
			} catch (Exception e) {
				df.setException(e.getMessage());

			}
			model.addAttribute("directionForm", df);
			model.addAttribute("direction", new Direction());
			return "directions";

		}
	}
	
	
	

	@RequestMapping(value = "/nouvelEmp")
	public String nouvelEmp(Model model) {

		model.addAttribute("employe", new Employe());
		
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());
		return "ajoutemploye";

	}
	
	@RequestMapping(value="/employes")
	public String indexEmp(Model model){
		
		model.addAttribute("employeForm", new EmployeForm());
		model.addAttribute("employe", new Employe());
		model.addAttribute("employes", metier.listEmploye());
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());
		
		return "employes";
		
	}
	
	@RequestMapping(value="/saveEmp")
	public String saveEmp(@Valid Employe e,BindingResult bindingResult, Model model, MultipartFile file, RedirectAttributes redirectAttributes ) throws IOException{
		
		if(bindingResult.hasErrors()){
			
			model.addAttribute("employe", new Employe());
			model.addAttribute("direction", metier.listDirection());
			model.addAttribute("service", metier.listService());
			model.addAttribute("fonction", metier.listFonction());
			
			return "ajoutemploye";
		}
		
		if(!file.isEmpty()){
			String path=System.getProperty("java.io.tmpdir");
			e.setPhoto(file.getOriginalFilename());
			int width =60, height = 60;
			BufferedImage bi = ImageIO.read(file.getInputStream());
			BufferedImage thumbnail = Scalr.resize(bi, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
                    width, height , Scalr.OP_ANTIALIAS);
			
			
			
			Long idEmp=null;
			if(e.getIdEmploye()==null){
				idEmp = metier.ajouterEmploye(e, e.getDirection().getIdDirection(), e.getService().getIdService()); 
				redirectAttributes.addFlashAttribute("save", true);
			}
			else {
				metier.modifierEmploye(e);
				idEmp=e.getIdEmploye();
			}
			//Long idP = metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
			ImageIO.write(thumbnail, "jpg", new File(path+"/"+"EMP_"+idEmp+"_"+file.getOriginalFilename()));
			//file.transferTo(new File(path+"/"+"EMP_"+idEmp+"_"+file.getOriginalFilename()));
		}
		else{
			if(e.getIdEmploye()==null){
				metier.ajouterEmploye(e, e.getDirection().getIdDirection(), e.getService().getIdService());
				
			
			}else metier.modifierEmploye(e);
			
			
		}
		redirectAttributes.addFlashAttribute("save", true);
		model.addAttribute("employeForm", new EmployeForm());
		model.addAttribute("employe", new Employe());
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
	public String suppEmp(Long idEmp, Model model, RedirectAttributes redirectAttributes){
		metier.supprimerEmploye(idEmp);
		redirectAttributes.addFlashAttribute("suppr", true);
		model.addAttribute("employeForm", new EmployeForm());
		model.addAttribute("employe", new Employe());
		model.addAttribute("employes", metier.listEmploye());
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());
		return "employes";
	}
	
	@RequestMapping(value="/editEmp")
	public String editEmp(Long idEmp, Model model, RedirectAttributes redirectAttributes){
		Employe e = metier.getEmploye(idEmp);
		
		model.addAttribute("employe", e);
		model.addAttribute("employeForm", new EmployeForm());
		model.addAttribute("employes", metier.listEmploye());
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());
		return "ajoutemploye";
	}
	
	@RequestMapping(value="/rechEmp")
	public String rechercheEmp(@Valid EmployeForm empf, Model model ){
		if(empf.getCodeEmploye()==null){
			
			model.addAttribute("employes", metier.listEmploye());
			model.addAttribute("direction", metier.listDirection());
			model.addAttribute("service", metier.listService());
			model.addAttribute("fonction", metier.listFonction());
			
			return"employes";
		}
		else{
		model.addAttribute("employeForm", new EmployeForm());
		model.addAttribute("employe", new Employe());
		model.addAttribute("employes", metier.EmployeParMotCle(empf.getCodeEmploye()));
		model.addAttribute("direction", metier.listDirection());
		model.addAttribute("service", metier.listService());
		model.addAttribute("fonction", metier.listFonction());
		return "employes";
		
	}
	}
	
	@RequestMapping(value="/fonctions")
	public String indexFonc( Model model){
		
		model.addAttribute("fonctionForm", new FonctionForm());
		model.addAttribute("fonction", new Fonction());
		model.addAttribute("fonctions", metier.listFonction());
		return "fonctions";
		
	}
	
	@RequestMapping(value="/saveFonc")
	public String saveFonc(@Valid Fonction f,BindingResult bindingResult, Model model , RedirectAttributes redirectAttributes){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("fonctions", metier.listFonction());
			model.addAttribute("fonctionForm", new FonctionForm());
			return("fonctions");
			
		}
		if(f.getIdFonction()!=null){
			metier.modifierFonction(f);
		}
		else
		metier.ajouterFonction(f);
		redirectAttributes.addFlashAttribute("save", true);
		model.addAttribute("fonctionForm", new FonctionForm());
		model.addAttribute("fonction", new Fonction());
		model.addAttribute("fonctions", metier.listFonction());
		return "redirect:/admin/fonctions";
		
	}
	@RequestMapping(value="/suppFonc")
	public String suppFonc(Long idFonc, Model model, RedirectAttributes redirectAttributes ){
		
		metier.supprimerFonction(idFonc);
		redirectAttributes.addFlashAttribute("suppr", true);
		model.addAttribute("fonctionForm", new FonctionForm());
		model.addAttribute("fonction", new Fonction());
		model.addAttribute("fonctions", metier.listFonction());
		return "redirect:/admin/fonctions";
		
	}
	
	@RequestMapping(value="/editFonc")
	public String editFonc( Long idFonc, Model model ){
		Fonction fc = metier.getFonction(idFonc);
		
		model.addAttribute("fonction", fc);
		model.addAttribute("fonctionForm", new FonctionForm());
		model.addAttribute("fonctions", metier.listFonction());
		return "fonctions";
		
	}
	
	@RequestMapping(value="/rechFonc")
	public String rechercheFonc(@Valid FonctionForm f,BindingResult bindingResult, Model model ){
		
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
		model.addAttribute("fonction", new Fonction());
		return "fonctions";
		}
		
	}
	
	
	@RequestMapping(value="/services")
	public String indexServ(Model model){
		
		model.addAttribute("serviceForm", new ServiceForm());
		model.addAttribute("service", new Service());
		model.addAttribute("directions", metier.listDirection());
		model.addAttribute("services", metier.listService());
		return "services";
		
	}
	
	@RequestMapping(value="/saveServ")
	public String saveServ(@Valid Service s,BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes ){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("services", metier.listService());
			model.addAttribute("serviceForm", new ServiceForm());
			return"services";
		}
		if(s.getNomService()!=null){
			metier.modifierService(s);
			
			
		}
		else
			metier.ajouterService(s);
			redirectAttributes.addFlashAttribute("save", true);
			
		
		
		model.addAttribute("serviceForm", new ServiceForm());
		model.addAttribute("service", new Service());
		model.addAttribute("directions", metier.listDirection());
		model.addAttribute("services", metier.listService());
		return "redirect:/admin/services";
		
	}
	@RequestMapping(value="/suppServ")
	public String suppServ(Long idServ, Model model , RedirectAttributes redirectAttributes){
		
		metier.supprimerService(idServ);
		redirectAttributes.addFlashAttribute("suppr", true);
		model.addAttribute("serviceForm", new ServiceForm());
		model.addAttribute("service", new Service());
		model.addAttribute("directions", metier.listDirection());
		model.addAttribute("services", metier.listService());
		return "redirect:/admin/services";
		
	}
	
	@RequestMapping(value="/editServ")
	public String editServ( Long idServ, Model model ){
		Service s = metier.getService(idServ);
		
		model.addAttribute("service", s);
		model.addAttribute("serviceForm", new ServiceForm());
		model.addAttribute("directions", metier.listDirection());
		model.addAttribute("services", metier.listService());
		return "services";
		
	}
	
	@RequestMapping(value="/rechServ")
	public String rechercheServ(@Valid ServiceForm sf,BindingResult bindingResult, Model model ){
		
		if(sf.getCodeService()==null){
			model.addAttribute("services", metier.listService());
			return"redirect:/admin/services";
		}
		else{
		
		try {
			model.addAttribute("services", metier.ServiceParMotCle(sf.getCodeService()));
		} catch (Exception e) {
			sf.setException(e.getMessage());
		}
		model.addAttribute("serviceForm", sf);
		model.addAttribute("service", new Service());
		model.addAttribute("directions", metier.listDirection());
		return "services";
		}
		
	}

	
	public void charger(@Valid FonctionForm f, Model model){
		
		int pos=f.getNbLigne()*f.getPage();
		
		model.addAttribute("fonctions", metier.listFonction());
		long nbfc = metier.getNombreFonction();
		f.setNbPages((int)(nbfc/f.getNbLigne())+1);
		
		
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
