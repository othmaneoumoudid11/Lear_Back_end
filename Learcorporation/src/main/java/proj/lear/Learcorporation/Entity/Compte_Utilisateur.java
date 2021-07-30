package proj.lear.Learcorporation.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@DiscriminatorValue("cu")
public class Compte_Utilisateur extends Compte implements Serializable {
	
	@ManyToMany(mappedBy = "clients")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Licence> licences;
	
	
	@ManyToMany(mappedBy = "clients")
	@LazyCollection(LazyCollectionOption.FALSE)	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Software> softwares;
	

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Aprov_Lic> aprlicences;
    

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Approv_Soft> aprsofts;

	public Compte_Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte_Utilisateur(String user_name, String email, String motpasse) {
		super(user_name, email, motpasse);
		
		// TODO Auto-generated constructor stub
	}

	public List<Licence> getLicences() {
		return licences;
	}

	public void setLicences(List<Licence> licence) {
		this.licences = licence;
	}

	public List<Software> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(List<Software> softwares) {
		this.softwares = softwares;
	}
	
	
		
}
