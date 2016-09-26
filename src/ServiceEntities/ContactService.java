package ServiceEntities;

import DAOs.ContactDAO;
import Models.Contact;

public class ContactService {

	ContactDAO cd = new ContactDAO();
	
	public void createContact(String nom,String prenom,String email)
	{
		cd.createContact(nom,prenom,email);
	}
	
	public void deleteContact(String condition, Object value)
	{
		cd.deleteContact(condition, value);
	}
	
	public void updateContact(int id, String nom,String prenom,String email)
	{
		cd.updateContact(id,nom,prenom,email);
	}
	
	public Contact searchContact(String condition, Object value)
	{
		return cd.searchContact(condition, value);
	}
	
	public boolean contactExists(String nom, String prenom)
	{
		return cd.contactExists(nom, prenom);
	}
	
	public boolean contactExists(int id)
	{
		return cd.contactExists(id);
	}
}
