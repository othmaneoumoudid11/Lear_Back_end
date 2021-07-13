package proj.lear.Learcorporation.Entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CU")
public class Compte_Utilisateur extends Compte implements Serializable {

	public Compte_Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte_Utilisateur(String u_ID, String user_name, String email, String motpasse) {
		super(user_name, email, motpasse);
		// TODO Auto-generated constructor stub
	}
	
		
}
