package proj.lear.Learcorporation.DAO;

import java.util.List;

import proj.lear.Learcorporation.Entity.Approv_Soft;
import proj.lear.Learcorporation.Entity.Software;


public interface ISoftwareDAO {

	public Software AjouterSoftware(Software S);
	public void SupprimerSoftware(Long id_software);
	public Software ModifierSoftware(Software S);
	public List<Software> ListSoftwares();
	public Software ChercherSoftware(Long id_software);
	public Approv_Soft Request_Soft(Approv_Soft SD);
}
