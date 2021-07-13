package proj.lear.Learcorporation.DAO;

import java.util.List;

import proj.lear.Learcorporation.Entity.Software;


public interface ISoftwareDAO {

	public Software AjouterEquipement(Software S);
	public void SupprimerSoftware(Long id_software);
	public Software ModifierSoftware(Software S);
	public List<Software> ListSoftwares();
	public Software ChercherSoftware(Long id_software);
	public void Request_Soft(Long id_software);
}