package proj.lear.Learcorporation.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.lear.Learcorporation.Entity.Approv_Soft;
import proj.lear.Learcorporation.Entity.Software;
import proj.lear.Learcorporation.Repository.ApproSofRepo;
import proj.lear.Learcorporation.Repository.SoftwareRepo;

@Service
public class SoftwareDAOimpl implements ISoftwareDAO {
	
	@Autowired
	private SoftwareRepo softrepo;
	
	@Autowired
	private ApproSofRepo softdemrepo;
	

	@Override
	public Software AjouterSoftware(Software S) {
		// TODO Auto-generated method stub
		return softrepo.save(S);
	}

	@Override
	public void SupprimerSoftware(Long id_software) {
		// TODO Auto-generated method stub
		softrepo.deleteById(id_software);
	}

	@Override
	public Software ModifierSoftware(Software S) {
		// TODO Auto-generated method stub
		return softrepo.save(S);
	}

	@Override
	public List<Software> ListSoftwares() {
		// TODO Auto-generated method stub
		return softrepo.findAll();
	}

	@Override
	public Software ChercherSoftware(Long id_software) {
		// TODO Auto-generated method stub
		return softrepo.findById(id_software).orElse(null);
	}

	@Override
	public Approv_Soft Request_Soft(Approv_Soft SD) {
		// TODO Auto-generated method stub
		  return softdemrepo.save(SD);

	}

	

	
	
	

}
