package proj.lear.Learcorporation.DAO;

import java.util.List;

import proj.lear.Learcorporation.Entity.Compte;
import proj.lear.Learcorporation.Entity.Compte_Gérants;
import proj.lear.Learcorporation.Entity.Compte_Utilisateur;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Entity.Software;


public interface ICompteDAO {
	
	public Compte AjouterCompte(Compte C);
	public void ModifierCompte(Compte C);
	public void SupprimerCompte(Long id_compte);
	public Compte ChercherCompte(Long id_compte);
	public Compte VerifierCompte(String Email, String motpasse);
	
	public  List<Compte_Utilisateur> ListeCompteUtilisateurs();
	public  List<Compte_Gérants> ListeCompteGerants();
	public List<Licence> ListeLicencesReqCompte(Long id_compte);
	public List<Software> ListeSoftwaresReqCompte(Long id_compte);

}
