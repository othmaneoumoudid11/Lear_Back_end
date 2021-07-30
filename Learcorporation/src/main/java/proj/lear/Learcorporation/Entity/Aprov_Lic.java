package proj.lear.Learcorporation.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Aprov_Lic implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id_Approv;
	
	private Date date_Request;
	private Date date_Approv;
	private boolean acceptee;
	
	@ManyToOne  (fetch = FetchType.EAGER)
	@JoinColumn( name="id_licence" )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Licence licence;
	

	@ManyToOne  (fetch = FetchType.LAZY)
	@JoinColumn( name="id_compte" )
	private Compte_Utilisateur user;


	public Aprov_Lic() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Aprov_Lic(Date date_Request, Date date_Approv, boolean acceptee, Licence licence, Compte_Utilisateur user) {
		super();
		this.date_Request = date_Request;
		this.date_Approv = date_Approv;
		this.acceptee = acceptee;
		this.licence = licence;
		this.user = user;
	}


	public Date getDate_Request() {
		return date_Request;
	}


	public void setDate_Request(Date date_Request) {
		this.date_Request = date_Request;
	}


	public Date getDate_Approv() {
		return date_Approv;
	}


	public void setDate_Approv(Date date_Approv) {
		this.date_Approv = date_Approv;
	}


	public boolean isAcceptee() {
		return acceptee;
	}


	public void setAcceptee(boolean acceptee) {
		this.acceptee = acceptee;
	}


	public Licence getLicence() {
		return licence;
	}


	public void setLicence(Licence licence) {
		this.licence = licence;
	}


	public Compte_Utilisateur getUser() {
		return user;
	}


	public void setUser(Compte_Utilisateur user) {
		this.user = user;
	}


	public Long getId_Approv() {
		return id_Approv;
	}
	
	

}
