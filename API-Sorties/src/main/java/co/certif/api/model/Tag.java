package co.certif.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="tag")
public class Tag {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank
	@Column(name = "idTag")
	Long idTag;
	@Column(name = "intituleTag")
	@NotBlank
	String intituleTag;
	
	public Long getIdTag() {
		return idTag;
	}
	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}
	public String getIntituleTag() {
		return intituleTag;
	}
	public void setIntituleTag(String intituleTag) {
		this.intituleTag = intituleTag;
	}
}
