package org.ministere.annuaire;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.ministere.annuaire.entities.*;
import org.ministere.annuaire.metier.IAdminMetier;

public class TestJPA {

	
	ClassPathXmlApplicationContext context ;
	

	@Before
	public void setUp() throws Exception {
		
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}

	@Test
	public void test1() {
		
		try {
			
			IAdminMetier metier = (IAdminMetier) context.getBean("metier");
			List<Direction> dirs = metier.listDirection();
			metier.ajouterDirection(new Direction("  ", "ALL", "ALL", "ALL", "Ministere"  ));
			metier.ajouterDirection(new Direction("DIP", "Direction de l'Informatique et du Prearchivage", "Simple", "Centrle", "Ministere"  ));
			metier.ajouterDirection(new Direction("DPP", "Direction de la Programmation et de la Prospective", "Simple", "Centrle", "Ministere"));
			List<Direction> dirs2 = metier.listDirection();
			assertTrue(dirs.size()+3==dirs2.size());
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		} 
		
	}
	
	
	@Test
	public void test3() {
		
		try {
			
			IAdminMetier metier = (IAdminMetier) context.getBean("metier");
			List<Fonction> foncs = metier.listFonction();
			metier.ajouterFonction(new Fonction("  ", "ALL", " "));
			metier.ajouterFonction(new Fonction("DIP", "Directeur du Service Informatique et Pre-Archivage", "Directeur"));
			metier.ajouterFonction(new Fonction("CSD", "Secretaire de Direction", "Chef Service"));
			List<Fonction> foncs2 = metier.listFonction();
			assertTrue(foncs.size()+3==foncs2.size());
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		} 
		
	}
	 
	@Test
	public void test() {
		
		try {
			
			IAdminMetier metier = (IAdminMetier) context.getBean("metier");
			List<Employe> emps = metier.listEmploye();
			metier.ajouterEmploye( new Employe("Mme", "FRANCISCO", "Joela","", "64 02 01 38", "C009", "RDC", "OZONE"));
			metier.ajouterEmploye( new Employe("Mr", "HOUNKANRIN", "Conrad", "","98 02 02 38", "C011", "RDC", "OZONE"));

			List<Employe> emps2 = metier.listEmploye();
			assertTrue(emps.size()+2==emps2.size());
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		} 
		
	}
	
	
	@Test
	public void test2() {
		
		try {
			
			IAdminMetier metier = (IAdminMetier) context.getBean("metier");
			List<Service> servs = metier.listService();
			metier.ajouterService(new Service("    ", "ALL"));
			metier.ajouterService(new Service("SI", "Service Informatique"));
			metier.ajouterService(new Service("SD", "Secretariat de Direction"));
			List<Service> servs2 = metier.listService();
			assertTrue(servs.size()+3==servs2.size());
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		} 
		
	}
	
	
	/*@Test
	public void test1() {
		
		try {
			ClassPathXmlApplicationContext app =
	new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		} 
		
	}*/

}
