 package org.ministere.annuaire.dao;

import java.util.List;

import org.ministere.annuaire.entities.*;



public interface IAnnuaireDao {
	
	public Long ajouterEmploye(Employe e);

	public List<Employe> listEmploye();

	public Employe getEmploye(Long idEmp);

	public void supprimerEmploye(Long idEmp);

	public void modifierEmploye(Employe e);
	
	public Long ajouterEmploye(Employe p, Long idDir, Long Serv);

	
	
	
	public Long ajouterDirection(Direction d);

	public List<Direction> listDirection();

	public Direction getDirection(Long idDir);

	public void supprimerDirection(Long idDir);

	public void modifierDirection(Direction d);
	
	public Long ajouterDirection(Direction p, Long idDirSup);
	
	
	public void ajouterServiceTodDirection(Long idServ, Long idDir);
	
	public Long ajouterService(Service s);

	public List<Service> listService();

	public Service getService(Long idServ);

	public void supprimerService(Long idServ);

	public void modifierService(Service s);
	
	
	public Long ajouterFonction(Fonction f);

	public List<Fonction> listFonction();

	public Fonction getFonction(Long idFonc);

	public void supprimerFonction(Long idFonc);

	public void modifierFonction(Fonction f);
	
	
	public Long ajouterAdmin(Admin a);

	public List<Admin> listAdmin();

	public Admin getAdmin(Long idAdmin);

	public void supprimerAdmin(Long idAdmin);

	public void modifierAdmin(Fonction a);
	
	
	public Long ajouterRole(Role r);

	public List<Role> listRole();

	public Role getRole(Long idRole);

	public void supprimerRole(Long idRole);

	public void modifierRole(Role r);
	
	
	

	public List<Employe> EmployeParMotCle(String mc);

	public List<Employe> EmployeParFunction(String nomFunc);
	
	public List<Employe> EmployeParDirection(String nomDir);
	
	public List<Employe> EmployeParService(Long idServ);
	
	public List<Fonction> FonctionParMotCle(String mc);
	
	public List<Direction> DirectionParMotCle(String mc);
	
	public Direction DirectionUniqueParMotCle(String mc);
	
	public Service ServiceUniqueParMotCle(String mc);
	
	public Fonction FonctionUniqueParMotCle(String mc);
	
	public Employe EmployeUniqueParMotCle(String mc);
	
	public List<Service> ServiceParMotCle(String mc);
	
	public void attribuerRole(Role r, Long adminID);
	
	public long getNombreFonction();
	
	
	
	public List<Employe> Recherche(String mc, Long idDir, Long idServ, Long idFonc);

	
}