package proj.lear.Learcorporation.Entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("cg")
public class Compte_Gérants extends Compte implements Serializable{

	public Compte_Gérants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte_Gérants(String user_name, String email, String motpasse, String Num_telephone, String ImageUrl) {
		super(user_name, email, motpasse, Num_telephone,ImageUrl);
		// TODO Auto-generated constructor stub
	}
	
	

}
