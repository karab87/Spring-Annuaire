package org.ministere.annuaire.entities;

import java.io.Serializable;
import java.util.Collection;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;
@Entity 
@Table(name="admin ")
public class Admin  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/**
	 * 
	 */
	private Long idAdmin;
	/**
	 * 
	 */
	@NotEmpty
	private String username;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private boolean actived;
	@OneToMany
	@JoinColumn(name="user_id")
	private Collection<Role> roles;
	
	public Long getIdAdmin() {
		return idAdmin;
	}
	
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String username, String password, boolean actived) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
	}
	   
	
	  
	
}
