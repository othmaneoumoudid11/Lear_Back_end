package proj.lear.Learcorporation.Entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


	@Entity
	@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
	@DiscriminatorColumn( name="type_Compte", discriminatorType = DiscriminatorType.STRING )
	public abstract class  Compte {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable = false, updatable = false)
		private Long id_compte ;
		
		private String User_name;
		private String email;
		private String motpasse;
        private String Num_telephone;	
	    private String ImageUrl;

		
		
		public Compte() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Compte(String user_name, String email, String motpasse) {
			super();
			User_name = user_name;
			this.email = email;
			this.motpasse = motpasse;
		}


		public Long getId_compte() {
			return id_compte;
		}


		public void setId_compte(Long id_compte) {
			this.id_compte = id_compte;
		}

		public String getUser_name() {
			return User_name;
		}


		public void setUser_name(String user_name) {
			User_name = user_name;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getMotpasse() {
			return motpasse;
		}


		public void setMotpasse(String motpasse) {
			this.motpasse = motpasse;
		}
		
		
		
		
	
}
