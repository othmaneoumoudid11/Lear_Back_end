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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Licence implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long id_licence;
	
	private String Lic_ref;
	
	private long Lic_serial;
	private String Lic_type;
	private long Lic_cost;
	private String Currency;
	private String Lic_BO_alloc;
	private String Lic_vend_cont_ref;
	
	
	
	@ManyToOne (fetch = FetchType.LAZY) 
	@JoinColumn( name="id_software" )
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Software Software;
	
	
	
	@ManyToMany
    @JoinTable( name = "Licences_clients",
                joinColumns = @JoinColumn( name = "id_licence" ),
                inverseJoinColumns = @JoinColumn( name = "id_compte"))
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Compte_Utilisateur> clients = new ArrayList<>();
	
    
    
    @OneToMany(mappedBy = "licence", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Aprov_Lic> aprlicences;
	
    
    
	public Licence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Licence(String lic_ref, long lic_serial, String lic_type, long lic_cost, String currency,
			String lic_BO_alloc, String lic_vend_cont_ref, Software software) {
		super();
		this.Lic_ref = lic_ref;
		this.Lic_serial = lic_serial;
		this.Lic_type = lic_type;
		this.Lic_cost = lic_cost;
		this.Currency = currency;
		this.Lic_BO_alloc = lic_BO_alloc;
		this.Software = software;
		this.Lic_vend_cont_ref = lic_vend_cont_ref;
	}

	public long getId_licence() {
		return id_licence;
	}

	public void setId_licence(long id_licence) {
		this.id_licence = id_licence;
	}

	public String getLic_ref() {
		return Lic_ref;
	}

	public void setLic_ref(String lic_ref) {
		Lic_ref = lic_ref;
	}

	public long getLic_serial() {
		return Lic_serial;
	}

	public void setLic_serial(long lic_serial) {
		Lic_serial = lic_serial;
	}

	public String getLic_type() {
		return Lic_type;
	}

	public void setLic_type(String lic_type) {
		Lic_type = lic_type;
	}

	public long getLic_cost() {
		return Lic_cost;
	}

	public void setLic_cost(long lic_cost) {
		Lic_cost = lic_cost;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getLic_BO_alloc() {
		return Lic_BO_alloc;
	}

	public void setLic_BO_alloc(String lic_BO_alloc) {
		Lic_BO_alloc = lic_BO_alloc;
	}

	public Software getSoftware() {
		return Software;
	}

	public void setSoftware(Software software) {
		Software = software;
	}

	public String getLic_vend_cont_ref() {
		return Lic_vend_cont_ref;
	}

	public void setLic_vend_cont_ref(String lic_vend_cont_ref) {
		Lic_vend_cont_ref = lic_vend_cont_ref;
	}

	
	

}
