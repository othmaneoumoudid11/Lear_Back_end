package proj.lear.Learcorporation.DAO;

import java.util.List;

import proj.lear.Learcorporation.Entity.Approv_Soft;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Entity.Software;

public interface IAprSofDAO {

	
	public List<Software> ListeSoftwaresApprovedUser(Long id_user);
	public void Approv_Software_Use(Long id_dem_software);

}
