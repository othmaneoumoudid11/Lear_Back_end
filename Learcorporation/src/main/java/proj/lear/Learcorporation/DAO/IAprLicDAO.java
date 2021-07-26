package proj.lear.Learcorporation.DAO;

import java.util.List;

import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Licence;

public interface IAprLicDAO {
	
	public List<Licence> ListeLicencesApprovedUser(Long id_user);
	public void Approv_Licences_Use(Long id_dem_apro);

}
