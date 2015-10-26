package org.ministere.annuaire.model;

import javax.validation.Valid;

import org.ministere.annuaire.entities.Employe;

public class EmployeForm {
	
	private String codeEmploye;
	@Valid
	private Employe employe;
	private String exception;
	
	
	
	
	
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(String codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
	
	
	

}
