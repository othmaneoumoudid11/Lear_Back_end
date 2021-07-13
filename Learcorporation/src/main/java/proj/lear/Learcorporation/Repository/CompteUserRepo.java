package proj.lear.Learcorporation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proj.lear.Learcorporation.Entity.Compte_Utilisateur;

public interface CompteUserRepo extends JpaRepository<Compte_Utilisateur, Long>{

}
