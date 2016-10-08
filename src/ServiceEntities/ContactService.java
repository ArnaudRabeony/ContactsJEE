package ServiceEntities;

import java.util.ArrayList;

import DAOs.ContactDAO;
import Models.Contact;
import Models.Groupe;

public class ContactService {

	ContactDAO cd = new ContactDAO();
	
	public Contact createContact(String nom,String prenom,String email)
	{
		return cd.createContact(nom,prenom,email);
	}

	public void updateContact(int idContact, String nom,String prenom,String email)
	{
		cd.updateContact(idContact,nom,prenom,email);
	}
	
	public Contact searchContact(int idContact)
	{
		return cd.searchContact(idContact);
	}
	
	public boolean contactExists(String nom, String prenom)
	{
		return cd.contactExists(nom, prenom);
	}
	
	public boolean contactExists(int idContact)
	{
		return cd.contactExists(idContact);
	}

	public Contact getContactOwnerByNumber(String numero)
	{
		return cd.getContactOwnerByNumber(numero);
	}

	public Contact getContactById(int idContact) {
		return cd.getContactById(idContact);
	}
	
	public ArrayList<Contact> getContacts()
	{
		return cd.getContacts();
	}

	public boolean deleteContact(int idContact) {
		return cd.deleteContact(idContact);
	}
	
	public int getIdByContact(Contact contact) {
		return cd.getIdByContact(contact);
	}
	
	public Groupe getGroupByContactId(int idContact)
	{
		return cd.getGroupByContactId(idContact);
	}
	
	public ArrayList<Contact> getNoGroupContacts()
	{
		return cd.getNoGroupContacts();
	}
	
	public boolean addContactToGroup(int idContact, int idGroupe)
	{
		return cd.addContactToGroup(idContact, idGroupe);
	}
	
	public boolean listContainsContact(ArrayList<Contact> list, int idContact)
	{
		boolean contains = false;
		for(Contact c : list)
			if(c.getId()==idContact)
				contains=true;
		
		return contains;
	}
}
