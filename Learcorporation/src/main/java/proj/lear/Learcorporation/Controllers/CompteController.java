package proj.lear.Learcorporation.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import proj.lear.Learcorporation.DAO.ICompteDAO;
import proj.lear.Learcorporation.Entity.Compte;
import proj.lear.Learcorporation.Entity.Compte_Gérants;
import proj.lear.Learcorporation.Entity.Compte_Utilisateur;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Entity.Software;


@RestController
@RequestMapping("/comptes")
public class CompteController {
	
	@Autowired
	private ICompteDAO comptedao;
	
	@PostMapping("/ajouterCU")
	@ApiOperation(value = "Ajouter un compte utilisateur",
    notes="vous devez specifier toutes les champs de compte utilisateur")
	public ResponseEntity<Compte_Utilisateur> AjouterCompteC(@ApiParam(value = "Compte utilisateur",required = true) @RequestBody Compte_Utilisateur CU){
		comptedao.AjouterCompte(CU);
		return new ResponseEntity<>(CU,HttpStatus.CREATED);
	}
	
	@PostMapping("/ajouterCM")
	@ApiOperation(value = "Ajouter un compte manager",
    notes="vous devez specifier toutes les champs de compte manager")
	public ResponseEntity<Compte_Gérants> AjouterCompteM(@ApiParam(value = "Compte manager",required = true) @RequestBody Compte_Gérants CM){
		comptedao.AjouterCompte(CM);
		return new ResponseEntity<>(CM,HttpStatus.CREATED);
	}
	@PutMapping("/modifierCC")
	@ApiOperation(value = "Modifier un compte utilisateur",
    notes="vous devez specifier le nouveau compte avec id pour etre modifier sinon il sera ajouter")
	public ResponseEntity<?> ModifierCC(@ApiParam(value = "le compte utilisateur",required = true) @RequestBody Compte_Utilisateur CU){
		comptedao.ModifierCompte(CU);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/modifierCM")
	@ApiOperation(value = "Modifier un compte manager",
    notes="vous devez specifier le nouveau compte avec id pour etre modifier sinon il sera ajouter")
	public ResponseEntity<?> ModifierCM(@ApiParam(value = "le compte client",required = true) @RequestBody Compte_Gérants CM){
		comptedao.ModifierCompte(CM);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	@ApiOperation(value = "Supprimer un compte",
    notes="vous devez specifier le ID de  compte")
	public ResponseEntity<?> SupprimerCompte(@ApiParam(value = "ID de compte",required = true) @PathVariable("id") Long id){
		comptedao.SupprimerCompte(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/chercher")
	@ApiOperation(value = "chercher un compte ",
    notes="vous devez specifier l'email et le mot de passe")
	public ResponseEntity<Compte> ChercherCompte(@ApiParam(value = "l'email de l'utilisateur",required = true)  @RequestParam String email , @ApiParam(value = "le mot de passe de l'utilisateur",required = true) @RequestParam  String MDP){
	    Compte C = comptedao.VerifierCompte(email, MDP);
		return new ResponseEntity<>(C,HttpStatus.OK);
	}
	
	
	@GetMapping("/verifier")
	@ApiOperation(value = "Verifier un compte ",
    notes="vous devez specifier l'email et le mot de passe")
	public ResponseEntity<Integer> VerifierCompte(@ApiParam(value = "l'email de l'utilisateur",required = true)  @RequestParam String email , @ApiParam(value = "le mot de passe de l'utilisateur",required = true) @RequestParam  String MDP){
	    Compte C = comptedao.VerifierCompte(email, MDP);
	    int type_compte = 0;
	    if(C==null) type_compte= -1;
	    else if(C instanceof Compte_Utilisateur)  type_compte= 1;
	    else if(C instanceof Compte_Gérants) type_compte=2;
		return new ResponseEntity<>(type_compte,HttpStatus.OK);
	}
	
	@GetMapping("/listeCC")
	@ApiOperation(value = "Liste des compte client",
    notes="rien comme parametere")
	public ResponseEntity<List<Compte_Utilisateur>> ListeCompteClient(){
		System.out.println("dddddddd");
		List<Compte_Utilisateur> CU = comptedao.ListeCompteUtilisateurs();
		return new ResponseEntity<>(CU,HttpStatus.OK);
	}
	
	@GetMapping("/listeCM")
	@ApiOperation(value = "Liste des comptes manager",
    notes="rien comme parametere")
	public ResponseEntity<List<Compte_Gérants>> ListeCompteManager(){
		List<Compte_Gérants> CM = comptedao.ListeCompteGerants();
		return new ResponseEntity<>(CM,HttpStatus.OK);
	}


	@GetMapping("/licences/{id}")
	@ApiOperation(value = "les licences  d'un utilisateur donner par leur id ",
    notes="vous devez specifier l'ID de compte")
	public ResponseEntity<List<Licence>> LicencesCompte(@ApiParam(value = "ID de compte",required = true) @PathVariable("id") Long id){
		List<Licence> L = comptedao.ListeLicencesReqCompte(id);
		return new ResponseEntity<>(L,HttpStatus.OK);
	}
	

	@GetMapping("/softwares/{id}")
	@ApiOperation(value = "les softwares d'un utilisateur donner par leur id ",
    notes="vous devez specifier l'ID de compte")
	public ResponseEntity<List<Software>> SoftwaresCompte(@ApiParam(value = "ID de compte",required = true) @PathVariable("id") Long id){
		List<Software> S = comptedao.ListeSoftwaresReqCompte(id);
		return new ResponseEntity<>(S,HttpStatus.OK);
   }
}
