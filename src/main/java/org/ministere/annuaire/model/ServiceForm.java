package org.ministere.annuaire.model;

import java.util.List;

import javax.validation.Valid;

import org.ministere.annuaire.entities.Direction;
import org.ministere.annuaire.entities.Service;

public class ServiceForm {
	
	private String codeService;
	
	private Direction direct;
	@Valid
	private Service service;
	private String exception;
	private List<Direction> direction;
	public String getCodeService() {
		return codeService;
	}
	
	
	public String getException() {
		return exception;
	}


	public Direction getDirect() {
		return direct;
	}


	public void setDirect(Direction direct) {
		this.direct = direct;
	}


	public void setException(String exception) {
		this.exception = exception;
	}


	public void setCodeService(String codeService) {
		this.codeService = codeService;
	}
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}


	public List<Direction> getDirection() {
		return direction;
	}


	public void setDirection(List<Direction> direction) {
		this.direction = direction;
	}
	
	
	
	

}
