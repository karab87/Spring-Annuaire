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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="service")
public class Service implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4359018654487638029L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idService;
	/**
	 * 
	 */
	
	@NotEmpty(message="Entrez une valeur SVP")
	@Length(max = 10, message="10 carracteres au Maximum")
    @Pattern(regexp = "[A-Z]*", message="Rien que des Majuscules")
	private String nomService;
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
	@OneToMany(mappedBy="service")
	private List<Employe> employes = new ArrayList<Employe>();
	
	
	/**
	 * 
	 */
	@ManyToMany
	@JoinTable(name="DIR_SERV", joinColumns=@JoinColumn(name="CODE_SERV"),
	inverseJoinColumns=@JoinColumn(name="CODE_DIR"))
	private List<Direction> directions = new ArrayList<Direction>();
	
	
	
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdService() {
		return idService;
	}

	public void setIdService(Long idService) {
		this.idService = idService;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	

	

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public List<Direction> getDirections() {
		return directions;
	}

	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}

	public Service(String nomService, String description) {
		super();
		this.nomService = nomService;
		this.description = description;
	}

	
	
	
	
	
	

}



