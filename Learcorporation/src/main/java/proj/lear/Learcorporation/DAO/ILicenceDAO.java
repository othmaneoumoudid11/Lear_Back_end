package proj.lear.Learcorporation.DAO;

import java.util.List;

import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Entity.Software;

public interface ILicenceDAO {
	
	public Licence AjouterEquipement(Licence L);
	public void SupprimerLicence(Long id_licence);
	public Licence ModifierLicence(Licence L);
	public List<Licence> ListLicences();
	public Licence ChercherLicence(Long id_licence);
	public void Request_Lic(Long id_licence);

}
