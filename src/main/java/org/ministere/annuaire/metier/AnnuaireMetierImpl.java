package org.ministere.annuaire.metier;

import java.util.List;

import org.ministere.annuaire.dao.IAnnuaireDao;
import org.springframework.transaction.annotation.Transactional;


import org.ministere.annuaire.entities.*;

@Transactional
public class AnnuaireMetierImpl implements IAdminMetier {
	
	
	
	 
		private IAnnuaireDao dao;
		
		
		

		public void setDao(IAnnuaireDao dao) {
			this.dao = dao;
		}

		@Override
		public List<Employe> listEmploye() {
			
			
			return dao.listEmploye();
		}

		@Override
		public Employe getEmploye(Long idEmp) {
			
			return dao.getEmploye(idEmp);
		}

		@Override
		public List<Direction> listDirection() {
			
			return dao.listDirection();
		}

		@Override
		public Direction getDirection(Long idDir) {
			
			return dao.getDirection(idDir);
		}

		@Override
		public List<Service> listService() {
			
			return dao.listService();
		}

		@Override
		public Service getService(Long idServ) {
			
			return dao.getService(idServ);
		}

		@Override
		public List<Fonction> listFonction() {
			
			return dao.listFonction();
		}

		@Override
		public Fonction getFonction(Long idFonc) {
			
			return dao.getFonction(idFonc);
		}

		@Override
		public List<Employe> EmployeParMotCle(String mc) {
			
			return dao.EmployeParMotCle(mc);
		}

		@Override
		public List<Employe> EmployeParFunction(String nomFunc) {
			
			return dao.EmployeParFunction(nomFunc);
		}

		@Override
		public List<Employe> EmployeParDirection(String nomDir) {
			
			return dao.EmployeParDirection(nomDir);
		}

		@Override
		public List<Employe> EmployeParService(Long idServ) {
			
			return dao.EmployeParService(idServ);
		}
		
		@Override
		public List<Fonction> FonctionParMotCle(String mc) {
			
			return dao.FonctionParMotCle(mc);
		}

		@Override
		public List<Direction> DirectionParMotCle(String mc) {
			
			return dao.DirectionParMotCle(mc);
		}

		@Override
		public List<Service> ServiceParMotCle(String mc) {
			return dao.ServiceParMotCle(mc);
		}

		@Override
		public Long ajouterEmploye(Employe e) {
			
			return dao.ajouterEmploye(e);
		}

		@Override
		public void supprimerEmploye(Long idEmp) {
			dao.supprimerEmploye(idEmp);
			
		}

		@Override
		public void modifierEmploye(Employe e) {
			dao.modifierEmploye(e);
			
		}

		@Override
		public Long ajouterEmploye(Employe p, Long idDir,Long idServ) {
			
			return dao.ajouterEmploye(p, idDir, idServ);
		}

		@Override
		public Long ajouterDirection(Direction d) {
			
			return dao.ajouterDirection(d);
		}

		@Override
		public void supprimerDirection(Long idDir) {
			dao.supprimerDirection(idDir);
			
		}

		@Override
		public void modifierDirection(Direction d) {
			dao.modifierDirection(d);
			
		}

		@Override
		public Long ajouterDirection(Direction p, Long idDirSup) {
			
			return dao.ajouterDirection(p, idDirSup);
		}

		@Override
		public Long ajouterService(Service s) {
			
			return dao.ajouterService(s);
		}

		@Override
		public void supprimerService(Long idServ) {
			dao.supprimerService(idServ);
			
		}

		@Override
		public void modifierService(Service s) {
			dao.modifierService(s);
			
		}

		@Override
		public Long ajouterFonction(Fonction f) {
			
			return dao.ajouterFonction(f);
		}

		@Override
		public void supprimerFonction(Long idFonc) {
			dao.supprimerFonction(idFonc);
			
		}

		@Override
		public void modifierFonction(Fonction f) {
			dao.modifierFonction(f);
			
		}

		@Override
		public Long ajouterAdmin(Admin a) {
			
			return dao.ajouterAdmin(a);
		}

		@Override
		public List<Admin> listAdmin() {
			
			return dao.listAdmin();
		}

		@Override
		public Admin getAdmin(Long idAdmin) {
			
			return dao.getAdmin(idAdmin);
		}

		@Override
		public void supprimerAdmin(Long idAdmin) {
			dao.supprimerAdmin(idAdmin);
			
		}

		@Override
		public void modifierAdmin(Fonction a) {
			dao.modifierAdmin(a);
			
		}

		@Override
		public Long ajouterRole(Role r) {
			
			return dao.ajouterRole(r);
		}

		@Override
		public List<Role> listRole() {
			
			return dao.listRole();
		}

		@Override
		public Role getRole(Long idRole) {
			
			return dao.getRole(idRole);
		}

		@Override
		public void supprimerRole(Long idRole) {
			dao.supprimerRole(idRole);
			
		}

		@Override
		public void modifierRole(Role r) {
			dao.modifierRole(r);
			
		}

		

		@Override
		public void attribuerRole(Role r, Long adminID) {
			dao.attribuerRole(r, adminID);
			
		}

		@Override
		public void ajouterServiceTodDirection(Long idServ, Long idDir) {
			dao.ajouterServiceTodDirection(idServ, idDir);
			
		}

		@Override
		public long getNombreFonction() {
			
			return dao.getNombreFonction();
		}

		

		@Override
		public List<Employe> Recherche(String mc, Long idDir, Long idServ,
				Long idFonc) {
			
			return dao.Recherche(mc, idDir, idServ, idFonc);
		}

		@Override
		public Direction DirectionUniqueParMotCle(String mc) {
			
			return dao.DirectionUniqueParMotCle(mc);
		}

		@Override
		public Service ServiceUniqueParMotCle(String mc) {
			// TODO Auto-generated method stub
			return dao.ServiceUniqueParMotCle(mc);
		}

		@Override
		public Fonction FonctionUniqueParMotCle(String mc) {
			// TODO Auto-generated method stub
			return dao.FonctionUniqueParMotCle(mc);
		}

		@Override
		public Employe EmployeUniqueParMotCle(String mc) {
			// TODO Auto-generated method stub
			return dao.EmployeUniqueParMotCle(mc);
		}

}
