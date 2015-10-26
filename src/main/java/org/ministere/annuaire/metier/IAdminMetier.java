package org.ministere.annuaire.metier;

import java.util.List;

import org.ministere.annuaire.entities.*;

public interface  IAdminMetier  extends IUserMetier{
	
	public Long ajouterEmploye(Employe e);

	public void supprimerEmploye(Long idEmp);

	public void modifierEmploye(Employe e);
	
	public Long ajouterEmploye(Employe p, Long idDir, Long idServ);

	
	
	
	public Long ajouterDirection(Direction d);
	
	public void supprimerDirection(Long idDir);

	public void modifierDirection(Direction d);
	
	public Long ajouterDirection(Direction p, Long idDirSup);
	
	
	public Long ajouterService(Service s);

	public void supprimerService(Long idServ);

	public void modifierService(Service s);
	
	
	public Long ajouterFonction(Fonction f);

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
	

	public void ajouterServiceTodDirection(Long idServ, Long idDir);
	

	public void attribuerRole(Role r, Long adminID);
	
	public Direction DirectionUniqueParMotCle(String mc);

	public Service ServiceUniqueParMotCle(String mc);
	
	public Fonction FonctionUniqueParMotCle(String mc);
	
	public Employe EmployeUniqueParMotCle(String mc);
	
}
