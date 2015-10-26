package org.ministere.annuaire.model;

import java.util.List;

import javax.validation.Valid;

import org.ministere.annuaire.entities.Direction;

public class DirectionForm {

	private String codeDirection;
	@Valid
	private Direction direction;
	private List<Direction> directions;
	private String exception;
	private String categorie;
	
	
	
	
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getCodeDirection() {
		return codeDirection;
	}
	public void setCodeDirection(String codeDirection) {
		this.codeDirection = codeDirection;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public List<Direction> getDirections() {
		return directions;
	}
	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}
}
