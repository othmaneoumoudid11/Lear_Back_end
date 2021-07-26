package proj.lear.Learcorporation.DAO;

import java.util.List;

import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Entity.Software;

public interface ILicenceDAO {
	
	public Licence AjouterLicence(Licence L);
	public void SupprimerLicence(Long id_licence);
	public Licence ModifierLicence(Licence L);
	public List<Licence> ListLicences();
	public Licence ChercherLicence(Long id_licence);
	public Aprov_Lic Request_Lic(Aprov_Lic LD);

}
