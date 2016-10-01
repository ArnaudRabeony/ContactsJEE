package ServiceEntities;

import java.util.ArrayList;

import DAOs.ContactDAO;
import Models.Contact;

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
	
	public String createUpdateForm(int idContact)
	{
		Contact c = this.getContactById(idContact);
		
		String form ="<div id='indexFormContainer' class='col-sm-offset-1 col-md-offset-1 col-md-5 col-sm-5' <%= display %>>";
		form+="<form class='form-group form-group-sm' method='post' action='Update'>";
		form+="<input class='inputPadding form-control' type='number' name='idContact' id='idContact' value='"+idContact+"' placeholder='ID...'><br>";	
		form+="<input class='inputPadding form-control' type='text' name='nom' id='nom' value='"+c.getNom()+"' placeholder='Nouveau nom...'><br>";	
		form+="<input class='inputPadding form-control' type='text' name='prenom' id='prenom' value='"+c.getPrenom()+"' placeholder='Nouveau prénom...'><br>";	
		form+="<input class='inputPadding form-control' type='text' name='email' id='email' value='"+c.getAdresse()+"' placeholder='Nouvelle adresse mail...'><br>";	
		form+="<span id='errorMessage' data-type='${errorType}'><i>${errorMessage}</i></span><br>";
		form+="<button class='btn btn-primary' type='submit'>Modifier le contact</button></form></div>";
		
		return form;
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
}
