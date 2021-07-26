package proj.lear.Learcorporation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import proj.lear.Learcorporation.Entity.Compte;

public interface CompteRepo extends JpaRepository<Compte, Long>{
	
	Compte findByEmailAndMotpasse(String Email, String motdepasse);

}
