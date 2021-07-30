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
import proj.lear.Learcorporation.DAO.ISoftwareDAO;
import proj.lear.Learcorporation.Entity.Approv_Soft;
import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Entity.Software;

@RestController
@RequestMapping("/Softwares")
public class SoftwareController {
	
	@Autowired
	private ISoftwareDAO softwaredao;
	
	@GetMapping("/liste")
	@ApiOperation(value = "Liste des Softwares",
    notes="rien comme parametere")
	public ResponseEntity<List<Software>> ListeLicences(){
		List<Software> s = softwaredao.ListSoftwares();
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	
	@PostMapping("/ajouter")
	@ApiOperation(value = "Ajouter une Software",
    notes="vous devez entrez l'objet software sous forme JSON sans id")
	public ResponseEntity<Software> AjouterLicence(@ApiParam(value = "Objet Software",required = true) @RequestBody Software software){
		Software S = softwaredao.AjouterSoftware(software);
		return new ResponseEntity<>(S,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/supprimer/{id}")
	@ApiOperation(value = "Supprimer une software",
    notes="vous devez specifier l'id de software a supprimer")
	public ResponseEntity<?> SupprimerLicence(@ApiParam(value = "ID software",required = true) @PathVariable("id") Long id){
		softwaredao.SupprimerSoftware(id);
		System.out.println("supprimer software");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@PutMapping("/modifier")
	@ApiOperation(value = "Modifier une software",
    notes="vous devez entrez l'objet software sous forme JSON avec id")
	public ResponseEntity<Software> ModifierLicence(@ApiParam(value = "Objet software",required = true) @RequestBody Software software){
		Software S = softwaredao.ModifierSoftware(software);
		System.out.println("modifier software ");
		return new ResponseEntity<>(S,HttpStatus.OK);
	}
	
	
	@GetMapping("/software/{id}")
	@ApiOperation(value = "Chercher software",
    notes="id_software comme parametere")
	public ResponseEntity<Software> ChercherLicence(@ApiParam(value = "ID software",required = true) @PathVariable("id") Long id){
		Software s = softwaredao.ChercherSoftware(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	
	@PostMapping("/aprovsoft")
	@ApiOperation(value = "Ajouter un software",
    notes="vous devez entrez l'objet Aprov software sous forme JSON sans id")
	public ResponseEntity<Approv_Soft> AprovLicence(@ApiParam(value = "Objet aprov software",required = true) @RequestBody Approv_Soft aprsoft){
		Approv_Soft aps = softwaredao.Request_Soft(aprsoft);
		return new ResponseEntity<>(aps,HttpStatus.CREATED);
	}
	
	
	
}
