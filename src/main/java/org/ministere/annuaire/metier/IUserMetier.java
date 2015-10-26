package org.ministere.annuaire.metier;

import java.util.List;

import org.ministere.annuaire.entities.*;

public interface IUserMetier {
	
	public List<Employe> listEmploye();

	public Employe getEmploye(Long idEmp);
	
	public List<Direction> listDirection();

	public Direction getDirection(Long idDir);
	
	public List<Service> listService();

	public Service getService(Long idServ);
	
	public List<Fonction> listFonction();

	public Fonction getFonction(Long idFonc);
	
	
	
	public List<Employe> EmployeParMotCle(String mc);

	public List<Employe> EmployeParFunction(String nomFunc);
	
	public List<Employe> EmployeParDirection(String nomDir);
	
	public List<Employe> EmployeParService(Long idServ);
	
	public List<Fonction> FonctionParMotCle(String mc);
	
	public List<Direction> DirectionParMotCle(String mc);
	
	public List<Service> ServiceParMotCle(String mc);
	
	public long getNombreFonction();
	
	

	public List<Employe> Recherche(String mc, Long idDir, Long idServ, Long idFonc);
}
