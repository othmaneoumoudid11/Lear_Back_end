package proj.lear.Learcorporation.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Software implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long id_software;
	
	private String soft_ref;
	
	private String soft_manif;
	private String soft_suppl;
	private String soft_familly;
	private String soft_version;
	private String soft_Desc;
    private String ImageUrl;
	
	@OneToMany(mappedBy = "software", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Licence> licences;
	
	
	
	@ManyToMany
    @JoinTable( name = "Software_clients",
                joinColumns = @JoinColumn( name = "id_software" ),
                inverseJoinColumns = @JoinColumn( name = "id_compte"))
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Compte_Utilisateur> clients = new ArrayList<>();
	
    @OneToMany(mappedBy = "software", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Approv_Soft> aprsoftwares;
   
	public Software() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Software(String soft_ref, String soft_manif, String soft_suppl, String soft_familly, String soft_version,
			String soft_Desc, String ImageUrl) {
		super();
		this.soft_ref = soft_ref;
		this.soft_manif = soft_manif;
		this.soft_suppl = soft_suppl;
		this.soft_familly = soft_familly;
		this.soft_version = soft_version;
		this.soft_Desc = soft_Desc;
		this.ImageUrl = ImageUrl;
	}


	public String getSoft_ref() {
		return soft_ref;
	}


	public void setSoft_ref(String soft_ref) {
		this.soft_ref = soft_ref;
	}


	public String getSoft_manif() {
		return soft_manif;
	}


	public void setSoft_manif(String soft_manif) {
		this.soft_manif = soft_manif;
	}


	public String getSoft_suppl() {
		return soft_suppl;
	}


	public void setSoft_suppl(String soft_suppl) {
		this.soft_suppl = soft_suppl;
	}


	public String getSoft_familly() {
		return soft_familly;
	}


	public String getImageUrl() {
		return ImageUrl;
	}


	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}


	public List<Licence> getLicences() {
		return licences;
	}


	public void setLicences(List<Licence> licences) {
		this.licences = licences;
	}


	public List<Compte_Utilisateur> getClients() {
		return clients;
	}


	public void setClients(List<Compte_Utilisateur> clients) {
		this.clients = clients;
	}


	public List<Approv_Soft> getAprsoftwares() {
		return aprsoftwares;
	}


	public void setAprsoftwares(List<Approv_Soft> aprsoftwares) {
		this.aprsoftwares = aprsoftwares;
	}


	public void setId_software(long id_software) {
		this.id_software = id_software;
	}


	public void setSoft_familly(String soft_familly) {
		this.soft_familly = soft_familly;
	}


	public String getSoft_version() {
		return soft_version;
	}


	public void setSoft_version(String soft_version) {
		this.soft_version = soft_version;
	}


	public String getSoft_Desc() {
		return soft_Desc;
	}


	public void setSoft_Desc(String soft_Desc) {
		this.soft_Desc = soft_Desc;
	}


	public long getId_software() {
		return id_software;
	}
	
	
	

}
