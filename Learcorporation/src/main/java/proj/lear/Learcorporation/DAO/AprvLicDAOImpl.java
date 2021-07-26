package proj.lear.Learcorporation.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Compte_Utilisateur;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Repository.AprovLicRep;
import proj.lear.Learcorporation.Repository.CompteRepo;
import proj.lear.Learcorporation.Repository.CompteUserRepo;
import proj.lear.Learcorporation.Repository.LicenceRepo;


@Service
public class AprvLicDAOImpl implements IAprLicDAO{
	
	@Autowired
	private CompteUserRepo compterepo;
	
	@Autowired
	private LicenceRepo licencerepo;
	
	@Autowired
	private AprovLicRep aprovlicrepo;

	@Override
	public List<Licence> ListeLicencesApprovedUser(Long id_user) {
		// TODO Auto-generated method stub
		Compte_Utilisateur CU = compterepo.findById(id_user).orElse(null);
		return CU.getLicences();
	}

	@Override
	public void Approv_Licences_Use(Long id_dem_apro) {
		// TODO Auto-generated method stub
		Aprov_Lic AL = aprovlicrepo.findById(id_dem_apro).orElse(null);
		AL.setAcceptee(true);
		AL.setDate_Approv(new Date());
		aprovlicrepo.save(AL);
	}

	
	

}
