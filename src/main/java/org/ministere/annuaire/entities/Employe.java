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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;












import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity 
@Table(name = "employe", uniqueConstraints ={ @UniqueConstraint(columnNames ={"nom", "prenom" })})
public class Employe implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEmploye;
	
	/**
	 * 
	 */
	
	@NotEmpty(message="Selectionnez SVP.")
	
	private String civilite;
	/**
	 * 
	 */
	
	
	@NotEmpty(message="Entrez une valeur SVP")
	@Pattern(regexp = "[A-Z\\s\\’-]*", message="Des majuscules SVP")
	private String nom;
	
	/**
	 * 
	 */
	
	@NotEmpty(message="Entrez une valeur SVP")
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\s\\’-]*", message="Des majuscules SVP")
	private String prenom;
	
	/**
	 * 
	 */
	
	@Size(max=15, message="Format Invalide")
    @Pattern(regexp = "[0-9\\s]*", message="Des majuscules SVP")
	private String telephone;
	
	/**
	 * 
	 */
	@NotEmpty(message="Entrez une valeur SVP")
	
	@Size(max=15, message="Format Invalide")
    @Pattern(regexp = "[0-9\\s]*", message="Des majuscules SVP")
	private String mobile;
	
	/**
	 * 
	 */
	
	@Size(max=15, message="Format Invalide")
    @Pattern(regexp = "[0-9\\s]*", message="Des majuscules SVP")
	private String mobile2;
	
	/**
	 * 
	 */
	
	@Size(max=15, message="Format Invalide")
    @Pattern(regexp = "[0-9\\s]*", message="Des majuscules SVP")
	private String interphone;
	
	/**
	 * 
	 */
	@NotEmpty(message="Entrez une valeur SVP")
	@Email(message="Format de l'email Invalide")
	private String mail;
	
	
	/**
	 * 
	 */
	@NotEmpty(message="Entrez une valeur SVP")
    @Pattern(regexp = "[A-z0-9]*", message="Des majuscules SVP")
	private String bureau;
	
	
	/**
	 * 
	 */
	@NotEmpty(message="Entrez une valeur SVP")
    @Pattern(regexp = "[A-z0-9]*", message="Des majuscules SVP")
	private String etage;
	
	
	/**
	 * 
	 */
	@NotEmpty(message="Entrez une valeur SVP")
    @Pattern(regexp = "[A-z0-9]*", message="Des majuscules SVP")
	private String batiment;
	
	
	/**
	 * 
	 */
	private String status;
	/**
	 * 
	 */
	private String photo;
	
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name="idService")
	private Service service;
	
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name="idDirection")
	private Direction direction;
	/**
	 * 
	 */
	@ManyToMany
	@JoinTable(name="EMP_FONC", joinColumns={@JoinColumn(name="CODE_EMP")},
	inverseJoinColumns={@JoinColumn(name="CODE_FONC")})
	private List<Fonction> fonctions = new ArrayList<Fonction>();
	
	
	
	
	
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String civilite, String nom, String prenom,
			String telephone, String mobile, String bureau, String etage,
			String batiment) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mobile = mobile;
		this.bureau = bureau;
		this.etage = etage;
		this.batiment = batiment;
	}
	
	
	
	

	

	
	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getInterphone() {
		return interphone;
	}

	public void setInterphone(String interphone) {
		this.interphone = interphone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	public String getEtage() {
		return etage;
	}

	public void setEtage(String etage) {
		this.etage = etage;
	}

	public String getBatiment() {
		return batiment;
	}

	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Fonction> getFonctions() {
		return fonctions;
	}

	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}

	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idEmploye == null) ? 0 : idEmploye.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employe))
            return false;
        Employe other = (Employe) obj;
        if (idEmploye == null) {
            if (other.idEmploye != null)
                return false;
        } else if (!idEmploye.equals(other.idEmploye))
            return false;
        if (idEmploye == null) {
            if (other.idEmploye != null)
                return false;
        } else if (!idEmploye.equals(other.idEmploye))
            return false;
        return true;
    }
    
    @Override
    public String toString()
    {
        return getNom() + " " + getPrenom();
    }
	
    
 
	

}
