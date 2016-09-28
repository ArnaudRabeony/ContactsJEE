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
	
	public void deleteTelephone(String nom)
	{
		gd.deleteTelephone(nom);
	}
	
	public void updateGroupe(int idGroupe, String newNom)
	{
		gd.updateGroupe(idGroupe, newNom);
	}
	
	public ArrayList<Contact> getContacts(Contact contact)
	{
		return gd.getContacts(contact);
	}
}
