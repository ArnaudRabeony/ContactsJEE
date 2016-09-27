package ServiceEntities;

import java.sql.SQLException;

import DAOs.AdresseDAO;
import Models.Adresse;

public class AdresseService {
	
	AdresseDAO ad = new AdresseDAO();

	public Adresse createTelephone(String rue, String ville, String codePostal, String pays)
	{
		return ad.createTelephone(rue, ville, codePostal, pays);
	}
	
	public void deleteAdresse(int idAdresse)
	{
		ad.deleteAdresse(idAdresse);
	}
	
	public void updateAdresse(int idAdresse, String newRue, String newVille, String newCodePostal, String newPays)
	{
		ad.updateAdresse(idAdresse, newRue, newVille, newCodePostal, newPays);
	}
	
	public Adresse getAdresseById(int idAdresse)
	{
		return ad.getAdresseById(idAdresse);
	}
}
