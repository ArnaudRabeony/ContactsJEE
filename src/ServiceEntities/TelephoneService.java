package ServiceEntities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAOs.TelephoneDAO;
import Models.Contact;
import Models.Telephone;

public class TelephoneService 
{
	TelephoneDAO td = new TelephoneDAO();
	
	public Telephone createTelephone(String type, String numero, Contact contact)
	{
		return td.createTelephone(type, numero, contact);
	}
	
	public void deleteTelephone(String numero)
	{
		td.deleteTelephone(numero);
	}
	
	public void updateNumero(int idTelephone, String newType, String newNumero)
	{
		td.updateNumero(idTelephone, newType, newNumero);
	}
	
	public ArrayList<Telephone> getTelephonesByContact(Contact contact)
	{
		return td.getTelephonesByContact(contact);
	}
	
	public String getNumberById(int id)
	{
		return td.getNumberById(id);
	}
	
	public int getIdByNumber(String numero)
	{
		return td.getIdByNumber(numero);
	}
}
