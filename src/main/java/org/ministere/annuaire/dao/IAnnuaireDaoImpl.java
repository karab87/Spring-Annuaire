package org.ministere.annuaire.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.ministere.annuaire.entities.*;


public class IAnnuaireDaoImpl implements IAnnuaireDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long ajouterEmploye(Employe e) {
		
		em.persist(e);
		return e.getIdEmploye();
	}

	@Override
	public List<Employe> listEmploye() {
		Query req = em.createQuery(" select e from Employe e order by e.nom asc");
		return req.getResultList();
	}

	@Override
	public Employe getEmploye(Long idEmp) {
		return em.find(Employe.class, idEmp);
		
	}

	@Override
	public void supprimerEmploye(Long idEmp) {
		Employe e = em.find(Employe.class, idEmp);
		em.remove(e);
		
	}

	@Override
	public void modifierEmploye(Employe e) {
		em.merge(e);
		
	}

	@Override
	public Long ajouterEmploye(Employe e, Long idDir, Long idServ) {
		Direction d = getDirection(idDir);
		Service s = getService(idServ);
		e.setDirection(d);
		e.setService(s);
		em.persist(e); 	
		return e.getIdEmploye();
	}

	@Override
	public Long ajouterDirection(Direction d) {


		em.persist(d);
		return d.getIdDirection();
	}

	@Override
	public List<Direction> listDirection() {
		Query req = em.createQuery(" select d from Direction d order by d.nomDirection asc");
		return req.getResultList();
	}

	@Override
	public Direction getDirection(Long idDir) {
		return em.find(Direction.class, idDir);
		
	}

	@Override
	public void supprimerDirection(Long idDir) {
		Direction d = em.find(Direction.class, idDir);
		em.remove(d);
		
	}

	@Override
	public void modifierDirection(Direction d) {
		em.merge(d);
		
	}

	@Override
	public Long ajouterDirection(Direction d, Long idDirSup) {
		if(idDirSup!=null){
			Direction dsup = getDirection(idDirSup);
			d.setDirectionsup(dsup);
		}
		em.persist(d); 	
		return d.getIdDirection();
	}

	@Override
	public Long ajouterService(Service s) {
		em.persist(s);
		return s.getIdService();
	}

	@Override
	public List<Service> listService() {
		Query req = em.createQuery("select s from Service s order by s.nomService asc");
		return req.getResultList();
	}

	@Override
	public Service getService(Long idServ) {
		return em.find(Service.class, idServ);
	}

	@Override
	public void supprimerService(Long idServ) {
		Service s = em.find(Service.class, idServ);
		em.remove(s);
		
		
	}

	@Override
	public void modifierService(Service s) {
		em.merge(s);
		
	}

	@Override
	public Long ajouterFonction(Fonction f) {
		em.persist(f);
		return f.getIdFonction();
	}

	@Override
	public List<Fonction> listFonction( ) {
		Query req = em.createQuery("select f from Fonction f order by f.nomFonction asc");
		
		
		return req.getResultList();
	}

	@Override
	public Fonction getFonction(Long idFonc) {
		return em.find(Fonction.class, idFonc);
		
	}

	@Override
	public void supprimerFonction(Long idFonc) {
		Fonction f = em.find(Fonction.class, idFonc);
		em.remove(f);
		
	}

	@Override
	public void modifierFonction(Fonction f) {
		em.merge(f);
		
	}

	@Override
	public Long ajouterAdmin(Admin a) {
		em.persist(a);
		return a.getIdAdmin();
	}

	@Override
	public List<Admin> listAdmin() {
		Query req = em.createQuery("select a from Admin a");
		return req.getResultList();
	}

	@Override
	public Admin getAdmin(Long idAdmin) {
		
		return em.find(Admin.class, idAdmin);
	}

	@Override
	public void supprimerAdmin(Long idAdmin) {
		Admin a = em.find(Admin.class, idAdmin);
		em.remove(a);
		
	}

	@Override
	public void modifierAdmin(Fonction a) {
		em.merge(a);
		
	}

	@Override
	public Long ajouterRole(Role r) {
		em.persist(r);
		return r.getIdRole();
	}

	@Override
	public List<Role> listRole() {
		Query req= em.createQuery("select r from Role r");
		return req.getResultList();
	}

	@Override
	public Role getRole(Long idRole) {
		return em.find(Role.class, idRole);
				
		
	}

	@Override
	public void supprimerRole(Long idRole) {
		Role r = em.find(Role.class, idRole);
		em.remove(r);
		
	}

	@Override
	public void modifierRole(Role r) {
		em.merge(r);
		
	}

	@Override
	public List<Employe> EmployeParMotCle(String mc) {
		Query req = em.createQuery(" select e from Employe e where e.nom like :x or e.prenom like :x order by e.nom asc");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Employe> EmployeParFunction(String nomFunc) {
		Query req = em.createQuery(" select e from Employe e where e.fonctions.nomFonction like :x or e.fonctions.description like :x");
		req.setParameter("x", "%"+nomFunc+"%");
		return req.getResultList();
	}

	@Override
	public List<Employe> EmployeParDirection(String nomDir) {
		Query req = em.createQuery(" select e from Employe e where e.direction.nomDirection. like :x like :x or e.direction.description like :x ");
		req.setParameter("x", "%"+nomDir+"%");
		return req.getResultList();
	}

	@Override
	public List<Employe> EmployeParService(Long nomServ) {
		Query req = em.createQuery(" select e from Employe e where e.service.nomService like :x like :x or e.service.description like :x ");
		req.setParameter("x", "%"+nomServ+"%");
		return req.getResultList();
	}

	@Override
	public void attribuerRole(Role r, Long adminID) {
		Admin a = em.find(Admin.class, adminID);
		a.getRoles().add(r);
		em.persist(r);
		
	}

	@Override
	public List<Fonction> FonctionParMotCle(String mc) {
		Query req = em.createQuery(" select f from Fonction f where f.nomFonction like :x order by f.nomFonction asc ");
		req.setParameter("x", "%"+mc+"%");
		
		
		if(req.getResultList().isEmpty()) throw new RuntimeException("Fonction "+mc+" introuvable");
		 return req.getResultList();
			
	}

	@Override
	public List<Direction> DirectionParMotCle(String mc) {
		Query req = em.createQuery(" select d from Direction d where d.nomDirection like :x order by d.nomDirection asc ");
		req.setParameter("x", "%"+mc+"%");
		
		
		if(req.getResultList().isEmpty()) throw new RuntimeException("Direction "+mc+" introuvable");
		else return req.getResultList();
			
	}
	
	@Override
	public List<Direction> DirectionPresentParMotCle(String mc) {
		Query req = em.createQuery(" select d from Direction d where d.nomDirection like :x  ");
		req.setParameter("x", "%"+mc+"%");
		
		
		if(req.getResultList().isEmpty()) throw new RuntimeException("Direction "+mc+" introuvable");
		else return req.getResultList();
			
	}
	
	@Override
	public Direction DirectionUniqueParMotCle(String mc) {
		Query req = em.createQuery(" select d from Direction d where d.nomDirection like :x  ");
		req.setParameter("x", "'"+mc+"'");
		
		
		return (Direction) req.getResultList().get(0);
			
	}
	
	@Override
	public Service ServiceUniqueParMotCle(String mc) {
		Query req = em.createQuery(" select s from Service s where s.nomService like :x  ");
		req.setParameter("x", mc);
		
		
		return (Service) req.getResultList().get(0);
			
	}

	@Override
	public Fonction FonctionUniqueParMotCle(String mc) {
		Query req = em.createQuery(" select f from Fonction f where f.nomFonction like :x  ");
		req.setParameter("x", mc);
		
		
		return (Fonction) req.getResultList().get(0);
			
	}
	
	@Override
	public Employe EmployeUniqueParMotCle(String mc) {
		Query req = em.createQuery(" select e from Employe e where e.nomEmploye like :x  ");
		req.setParameter("x", mc);
		
		
		return (Employe) req.getResultList().get(0);
			
	}

	@Override
	public List<Service> ServiceParMotCle(String mc) {
		
		
		Query req = em.createQuery(" select s from Service s where s.nomService like :x order by s.nomService asc ");
		req.setParameter("x", "%"+mc+"%");
		
		
		if(req.getResultList().isEmpty()) throw new RuntimeException("Service "+mc+" introuvable");
		else return req.getResultList();
			
	}

	@Override
	public void ajouterServiceTodDirection(Long idServ, Long idDir) {
		Service s = em.find(Service.class, idServ);
		Direction d = em.find(Direction.class, idDir);
		s.getDirections().add(d);
		d.getServices().add(s);
		
	}

	@Override
	public long getNombreFonction() {
		Query req = em.createQuery("select count(f) from Fonction f ");
		return (Long) req.getResultList().get(0);
	}

	

	@Override
	public List<Employe> Recherche(String mc, Long idDir, Long idServ,
			Long idFonc) {

		String sql = " select distinct e from Employe e JOIN e.fonctions f WHERE 1=1  ";

		
		  if (idFonc.intValue() >= 2) { 
			  sql += " AND f.idFonction=:z  ";
		 
		 }
		 

		if (!(mc.isEmpty())) {
			sql += "  AND  e.nom like :w or e.prenom like :w ";
		}

		if (idDir.intValue() >= 2) {
			sql += " AND e.direction.idDirection = :x ";
		}
		if (idServ.intValue() >= 2) {
			sql += " AND  e.service.idService = :y ";
		}

		System.out.println("requête 1\t" + sql.toString() + "\n");
		System.out.println("requête 1\t" + idDir + "\n");
		System.out.println("requête 1\t" + idServ + "\n");
		System.out.println("requête 1\t" + idFonc + "\n");
		System.out.println("requête 1\t" + mc.toString() + "\n");
		// Return current session

		Query req = em.createQuery(sql);

		
		 if ((idFonc>=2)) {
			 req.setParameter("z", idFonc); 
			 }
		 

		if (!(mc.isEmpty())) {
			req.setParameter("w", "%" + mc + "%");
		}

		if (idDir >= 2) {
			req.setParameter("x", idDir);
		}

		if (idServ >= 2) {
			req.setParameter("y", idServ);
		}

		
		  
		 

		System.out.println("mc\t" + mc + "\n");
		// System.out.println("idFonc\t"+idFonc+"\n");

		 if(req.getResultList().isEmpty()) throw new RuntimeException("Aucun resultat trouvé " );
		 else
		 
			return req.getResultList();
		
		
	}

	

}

