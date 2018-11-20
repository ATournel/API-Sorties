package co.certif.api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="activite")
public class Activite {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank
	@Column(name = "idActivite")
	private Long idActivite;
	@Column(name = "nomActivite")
	@NotBlank
	String nomActivite;
	@Column(name = "descriptionActivite")
	@NotBlank
	String descriptionActivite;
	@Column(name = "dateActivite")
	@NotBlank
	Date dateActivite;
	@Column(name = "urlImageActivite")
	@NotBlank
	String urlImageActivite;
	@OneToOne
	private Tag tag;
		
	public Long getIdActivite() {
		return idActivite;
	}
	public void setIdActivite(Long idActivite) {
		this.idActivite = idActivite;
	}
	public String getNomActivite() {
		return nomActivite;
	}
	public void setNomActivite(String nomActivite) {
		this.nomActivite = nomActivite;
	}
	public String getDescriptionActivite() {
		return descriptionActivite;
	}
	public void setDescriptionActivite(String descriptionActivite) {
		this.descriptionActivite = descriptionActivite;
	}
	public Date getDateActivite() {
		return dateActivite;
	}
	public void setDateActivite(Date dateActivite) {
		this.dateActivite = dateActivite;
	}
	public String getUrlImageActivite() {
		return urlImageActivite;
	}
	public void setUrlImageActivite(String urlImageActivite) {
		this.urlImageActivite = urlImageActivite;
	}
	
}
