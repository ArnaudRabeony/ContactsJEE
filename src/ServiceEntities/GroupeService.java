package ServiceEntities;

import java.util.ArrayList;

import DAOs.GroupeDAO;
import Models.Contact;
import Models.Groupe;

public class GroupeService {

	GroupeDAO gd = new GroupeDAO();
	
	public Groupe createGroupe(String nom, Contact contact)
	{
		return gd.createGroupe(nom, contact);
	}
	
	public Groupe createGroupe(String nom)
	{
		return gd.createGroupe(nom);
	}
	
	public void deleteTelephone(String nom)
	{
		gd.deleteTelephone(nom);
	}
	
	public boolean updateGroupe(int idGroupe, String newNom)
	{
		return gd.updateGroupe(idGroupe, newNom);
	}
	
	public ArrayList<Contact> getContacts(Contact contact)
	{
		return gd.getContacts(contact);
	}
	
	public boolean exists(String nom)
	{
		return gd.exists(nom);
	}
}
