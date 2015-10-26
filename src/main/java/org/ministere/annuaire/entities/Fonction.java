package org.ministere.annuaire.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="fonction")
public class Fonction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFonction;
	/**
	 * 
	 */
	
	@NotEmpty(message="Entrez une valeur SVP")
	@Length(min = 3, max = 10, message="Entre 3 et 10 carracteres")
    @Pattern(regexp = "[A-Z]*", message="Des majuscules SVP")
	private String nomFonction;
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
	@Length(min = 5, message="10 carracteres au Minimum")
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\s\\’-]*", message="Rien que des Lettres")
	private String level;
	/**
	 * 
	 */
	@ManyToMany(mappedBy="fonctions")
	private List<Employe> employes = new ArrayList<Employe>();
	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fonction(String nomFonction, String description, String level) {
		super();
		this.nomFonction = nomFonction;
		this.description = description;
		this.level = level;
	}
	
	
	public Long getIdFonction() {
		return idFonction;
	}
	public void setIdFonction(Long idFonction) {
		this.idFonction = idFonction;
	}
	public String getNomFonction() {
		return nomFonction;
	}
	public void setNomFonction(String nomFonction) {
		this.nomFonction = nomFonction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idFonction == null) ? 0 : idFonction.hashCode());
        result = prime * result + ((nomFonction == null) ? 0 : nomFonction.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Fonction))
            return false;
        Fonction other = (Fonction) obj;
        if (idFonction == null) {
            if (other.idFonction != null)
                return false;
        } else if (!idFonction.equals(other.idFonction))
            return false;
        if (idFonction == null) {
            if (other.idFonction != null)
                return false;
        } else if (!idFonction.equals(other.idFonction))
            return false;
        return true;
    }
	
    @Override
    public String toString()
    {
        return getIdFonction()+ " " + getNomFonction() + " " ;
    }
    

}

