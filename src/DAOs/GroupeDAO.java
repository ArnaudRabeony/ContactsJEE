package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Contact;
import Models.Groupe;
import Models.Telephone;

public class GroupeDAO {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;
	
	public GroupeDAO()
	{
		con = GlobalConnexion.getConnection();
	}
	
	public Connection getConnection()
	{
		return GlobalConnexion.getConnection();
	}

	public Groupe createGroupe(String nom, Contact contactOwner){
		
		Groupe g = null;
		
		System.out.println("Creation du groupe : "+nom+" | idContact "+contactOwner.getId());
		
		try
		{		
			con = this.getConnection();
	
			String req = "insert into groupe(nom,idContact) values(?,?)";
	
			ps = con.prepareStatement(req);
			ps.setString(1, nom);
			ps.setInt(2, contactOwner.getId());
			
			System.out.println(ps);
			ps.execute();
			
			g = new Groupe(nom);
			contactOwner.addGroupe(g);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return g;
	}

	public ArrayList<Contact> getContacts(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateGroupe(int idGroupe, String newNom) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTelephone(String nom) {
		// TODO Auto-generated method stub
		
	}
}
