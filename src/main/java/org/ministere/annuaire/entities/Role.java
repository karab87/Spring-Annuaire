package org.ministere.annuaire.entities;

import java.io.Serializable;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="role")
public class Role implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	
	@NotEmpty
	
	private String roleNome;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getRoleNome() {
		return roleNome;
	}
	public void setRoleNome(String roleName) {
		this.roleNome = roleName;
		
	}
	public Role(String roleNome) {
		super();
		this.roleNome = roleNome;
	}
	
	

}
