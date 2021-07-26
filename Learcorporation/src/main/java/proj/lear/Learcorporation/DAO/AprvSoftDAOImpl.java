package proj.lear.Learcorporation.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.lear.Learcorporation.Entity.Approv_Soft;
import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Compte_Utilisateur;
import proj.lear.Learcorporation.Entity.Software;
import proj.lear.Learcorporation.Repository.ApproSofRepo;
import proj.lear.Learcorporation.Repository.CompteUserRepo;


@Service
public class AprvSoftDAOImpl implements IAprSofDAO{
	
	@Autowired
	private ApproSofRepo approvsoft;
	
	@Autowired
	private CompteUserRepo compteusrepo;

	@Override
	public List<Software> ListeSoftwaresApprovedUser(Long id_user) {
		// TODO Auto-generated method stub
		Compte_Utilisateur CU = compteusrepo.findById(id_user).orElse(null);
		return CU.getSoftwares();
	}

	@Override
	public void Approv_Software_Use(Long id_dem_software) {
		// TODO Auto-generated method stub
		Approv_Soft AL = approvsoft.findById(id_dem_software).orElse(null);
		AL.setAcceptee(true);
		AL.setDate_Approv(new Date());
		approvsoft.save(AL);
	}

}
