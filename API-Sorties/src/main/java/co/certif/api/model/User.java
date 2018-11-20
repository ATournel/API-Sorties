package co.certif.api.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank
	@Column(name = "idUser")
	int idUser;
	String nomUser;
	String prenomUser;
	String urlPhotoProfil;
	String mailUser;
	@OneToMany
	private Collection<Tag> tags;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPrenomUser() {
		return prenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}
	public String getUrlPhotoProfil() {
		return urlPhotoProfil;
	}
	public void setUrlPhotoProfil(String urlPhotoProfil) {
		this.urlPhotoProfil = urlPhotoProfil;
	}
	public String getMailUser() {
		return mailUser;
	}
	public void setMailUser(String mailUser) {
		this.mailUser = mailUser;
	}
	
}
