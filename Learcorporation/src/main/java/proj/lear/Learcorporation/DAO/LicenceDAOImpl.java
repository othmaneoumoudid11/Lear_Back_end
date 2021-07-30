package proj.lear.Learcorporation.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Compte;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Repository.AprovLicRep;
import proj.lear.Learcorporation.Repository.CompteRepo;
import proj.lear.Learcorporation.Repository.LicenceRepo;


@Service
public class LicenceDAOImpl implements ILicenceDAO{
	
	@Autowired
	private LicenceRepo licencerepo;
	
	@Autowired
	private CompteRepo compteRepo;
	
	@Autowired
	private AprovLicRep licdemrepo;

	@Override
	public Licence AjouterLicence(Licence L) {
		// TODO Auto-generated method stub
		Licence Li = licencerepo.save(L);
		 System.out.println("xxxx"+ L.getCurrency() + L.getLic_BO_alloc());
		 System.out.println("xxxxi"+ Li.getCurrency() + Li.getLic_BO_alloc());

		 return Li;
	}

	@Override
	public void SupprimerLicence(Long id_licence) {
		// TODO Auto-generated method stub
		licencerepo.deleteById(id_licence);
	}

	@Override
	public Licence ModifierLicence(Licence L) {
		// TODO Auto-generated method stub
		return licencerepo.save(L);
	}

	@Override
	public List<Licence> ListLicences() {
		// TODO Auto-generated method stub
		return licencerepo.findAll();
	}

	@Override
	public Licence ChercherLicence(Long id_licence) {
		// TODO Auto-generated method stub
		return licencerepo.findById(id_licence).orElse(null);
	}

	@Override
	public Aprov_Lic Request_Lic(Aprov_Lic LD) {
		// TODO Auto-generated method stub
		 return licdemrepo.save(LD);
	}

	
}
