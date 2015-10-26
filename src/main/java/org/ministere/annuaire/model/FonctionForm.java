package org.ministere.annuaire.model;

import java.util.List;

import javax.validation.Valid;

import org.ministere.annuaire.entities.Fonction;

public class FonctionForm {
	
	private String codeFonction;
	@Valid
	private Fonction fonction;
	private String exception;
	private List<Fonction> fonctions;
	private int page=0;
	private int nbLigne=5;
	private int nbPages;
	
	
	
	
	
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNbLigne() {
		return nbLigne;
	}
	public void setNbLigne(int nbLigne) {
		this.nbLigne = nbLigne;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getCodeFonction() {
		return codeFonction;
	}
	public void setCodeFonction(String codeFonction) {
		this.codeFonction = codeFonction;
	}
	public Fonction getFonction() {
		return fonction;
	}
	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}
	public List<Fonction> getFonctions() {
		return fonctions;
	}
	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}
	
	

}
