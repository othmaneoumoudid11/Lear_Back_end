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
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import proj.lear.Learcorporation.DAO.ILicenceDAO;
import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Licence;

@RestController
@RequestMapping("/Licences")
public class LicenceController {
	
	@Autowired
	private ILicenceDAO liceneDao;
	
	@GetMapping("/liste")
	@ApiOperation(value = "Liste des licence",
    notes="rien comme parametere")
	public ResponseEntity<List<Licence>> ListeLicences(){
		List<Licence> l = liceneDao.ListLicences();
		return new ResponseEntity<>(l,HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	@ApiOperation(value = "Ajouter une Licence",
    notes="vous devez entrez l'objet licence sous forme JSON sans id")
	public ResponseEntity<Licence> AjouterLicence(@ApiParam(value = "Objet licence",required = true) @RequestBody Licence licence){
		Licence L = liceneDao.AjouterLicence(licence);
		System.out.println("hhh"+ licence.getCurrency() + licence.getLic_BO_alloc());

		System.out.println("hhh1"+ L.getCurrency() + L.getLic_BO_alloc());
		return new ResponseEntity<>(L,HttpStatus.CREATED);
	}
	
	@PutMapping("/modifier")
	@ApiOperation(value = "Modifier une licence",
    notes="vous devez entrez l'objet licence sous forme JSON avec id")
	public ResponseEntity<Licence> ModifierLicence(@ApiParam(value = "Objet licence",required = true) @RequestBody Licence licence){
		Licence L = liceneDao.ModifierLicence(licence);
		System.out.println("modifier licence ");
		return new ResponseEntity<>(L,HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	@ApiOperation(value = "Supprimer une licence",
    notes="vous devez specifier l'id de licence a supprimer")
	public ResponseEntity<?> SupprimerLicence(@ApiParam(value = "ID licence",required = true) @PathVariable("id") Long id){
		liceneDao.SupprimerLicence(id);
		System.out.println("supprimer licence");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/licence/{id}")
	@ApiOperation(value = "Chercher licence",
    notes="id_licence comme parametere")
	public ResponseEntity<Licence> ChercherLicence(@ApiParam(value = "ID licence",required = true) @PathVariable("id") Long id){
		Licence l = liceneDao.ChercherLicence(id);
		return new ResponseEntity<>(l,HttpStatus.OK);
	}
	
	@PostMapping("/aprovlic")
	@ApiOperation(value = "Ajouter une Licence",
    notes="vous devez entrez l'objet Aprov licence sous forme JSON sans id")
	public ResponseEntity<Aprov_Lic> AprovLicence(@ApiParam(value = "Objet aprov licence",required = true) @RequestBody Aprov_Lic aprlic){
		Aprov_Lic apl = liceneDao.Request_Lic(aprlic);
		return new ResponseEntity<>(apl,HttpStatus.CREATED);
	}
	
	
	

}
