package org.ministere.annuaire.model;

import javax.validation.Valid;

import org.ministere.annuaire.entities.Employe;

public class RechercheForm {
	
	private Long codeService;
	
	private Long codeFonction;
	
	private Long codeDirection;
	
	private String codeEmploye;
	
	private String exception;
	
	@Valid
	private Employe employe;
	
	
	
	

	
	

	
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public Long getCodeService() {
		return codeService;
	}

	public void setCodeService(Long codeService) {
		this.codeService = codeService;
	}

	public Long getCodeFonction() {
		return codeFonction;
	}

	public void setCodeFonction(Long codeFonction) {
		this.codeFonction = codeFonction;
	}

	public Long getCodeDirection() {
		return codeDirection;
	}

	public void setCodeDirection(Long codeDirection) {
		this.codeDirection = codeDirection;
	}

	public String getCodeEmploye() {
		return codeEmploye;
	}

	public void setCodeEmploye(String codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	
	
	
	

}
