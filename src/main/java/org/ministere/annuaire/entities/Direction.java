package org.ministere.annuaire.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.ministere.annuaire.annotation.UniqueDirection;

@Entity
@Table(name="direction")
public class Direction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDirection;
	/**
	 * 
	 */
	
	@NotEmpty(message="Entrez une valeur SVP")
	@Length(min = 2, message="Entre 3 et 10 carracteres")
    @Pattern(regexp = "[A-Z]*", message="Des majuscules SVP")
	private String nomDirection;
	/**
	 * 
	 */
	@NotEmpty(message="Entrez une valeur SVP")
	@Length(min = 10, message="10 carracteres au Minimum")
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\s\\’-]*", message="Rien que des Lettres")
	
	private String description;
	/**
	 * 
	 */
	
	@NotEmpty(message="Entrez une valeur SVP")
	private String categorie;
	/**
	 * 
	 */
	@NotEmpty(message="Entrez une valeur SVP")
	private String nature;
	/**
	 * 
	 */
	
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\s\\’-]*", message="Rien que des Lettres")
	@NotEmpty(message="Entrez une valeur SVP")
	private String localisation;
	
    /**
	 * 
	 */
	@ManyToOne(optional=true)
	
	@JoinColumn(name="dir_sup", nullable=true)
	private Direction directionsup;
	/**
	 * 
	 */
	
	
	@ManyToMany(mappedBy="directions")
	private List<Service> services = new ArrayList<Service>();
	/**
	 * 
	 */
	@OneToMany(mappedBy="direction")
	private List<Employe> employes = new ArrayList<Employe>();
	
	
	
	
	
	public Long getIdDirection() {
		return idDirection;
	}
	public void setIdDirection(Long idDirection) {
		this.idDirection = idDirection;
	}
	public String getNomDirection() {
		return nomDirection;
	}
	public void setNomDirection(String nomDirection) {
		this.nomDirection = nomDirection;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public Direction getDirectionsup() {
		return directionsup;
	}
	public void setDirectionsup(Direction directionsup) {
		this.directionsup = directionsup;
	}
	
	
	
	public List<Service> getServices() {
		return services;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public Direction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Direction(String nomDirection, String description, String categorie,
			String nature, String localisation
			) {
		super();
		this.nomDirection = nomDirection;
		this.description = description;
		this.categorie = categorie;
		this.nature = nature;
		this.localisation = localisation;
		
		
	}
	
	
	
	
	
	

}
