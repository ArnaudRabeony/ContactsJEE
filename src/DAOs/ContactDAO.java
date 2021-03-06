package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Contact;
import Models.Groupe;
import ServiceEntities.GroupeService;

public class ContactDAO {

	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;
	
	public ContactDAO()
	{
		con = GlobalConnexion.getConnection();
	}
	
	public Connection getConnection()
	{
		return GlobalConnexion.getConnection();
	}
	
	public Contact createContact(String nom,String prenom,String email)
	{
		System.out.println("Creation du compte : "+nom+" | "+prenom+" | "+email);
		Contact c = null;

		try
		{		
		con = this.getConnection();

		String req = "insert into contact(nom,prenom,email) values(?,?,?)";

		ps = con.prepareStatement(req);
		ps.setString(1, nom);
		ps.setString(2, prenom);
		ps.setString(3, email);
		
		ps.execute();
		c = new Contact(nom, prenom, email);
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
		return c;	
	}
	
	public void updateContact(int idContact, String nom,String prenom,String email)
	{
		System.out.println("MAJ du compte : "+idContact+"\n"+nom+" "+prenom+"\n"+email);
		
		try
		{
		con = this.getConnection();
		String req = "update contact set nom=?,prenom=?,email=? where idContact=?";

		ps = con.prepareStatement(req);
		ps.setString(1, nom);
		ps.setString(2, prenom);
		ps.setString(3, email);
		ps.setInt(4, idContact);
		
		System.out.println(ps);
		ps.execute();
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
	}
	
	public Contact searchContact(int idContact)
	{
		System.out.println("Recherche du compte : "+idContact);
		Contact contact = null;
		
		try
		{
			con = this.getConnection();
			String req = "select * from contact where idContact=?";
	
			ps = con.prepareStatement(req);
			
			ps.setInt(1, idContact);
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			int id = rs.getInt("idContact");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			
			contact = new Contact(id,nom, prenom, email);
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

		return contact;
	}
	
	public ArrayList<Contact> getContacts()
	{
		ArrayList<Contact> list = new ArrayList<Contact>();
		
		try
		{
			con = this.getConnection();
			String req = "select * from contact";
			ps = con.prepareStatement(req);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("idContact");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				int idGroupe = rs.getInt("idGroupe");
				
				list.add(new Contact(id, nom, prenom, email,idGroupe));
			}
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
		
		return list;
	}
	
	public boolean contactExists(String nom, String prenom)
	{
		boolean exists = false;
		try
		{
			con = this.getConnection();
			String req = "select * from contact where nom=? and prenom=?";
	
			ps = con.prepareStatement(req);
			
			ps.setString(1, nom);
			ps.setString(2, prenom);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				exists=true;
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

		return exists;
	}
	
	public boolean contactExists(int idContact)
	{
		boolean exists = false;
		try
		{
			con = this.getConnection();
			String req = "select * from contact where idContact=?";
	
			ps = con.prepareStatement(req);
			
			ps.setInt(1, idContact);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				exists=true;
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

		return exists;
	}

	public Contact getContactById(int idContact)
	{
		Contact c = null;
		
		try
		{
			con = this.getConnection();
			String req = "select * from contact where idContact=?";
	
			ps = con.prepareStatement(req);
			
			ps.setInt(1, idContact);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				c = new Contact(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
				c.setId(rs.getInt("idContact"));
			}
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
		return c;
	}
	
	public Contact getContactOwnerByNumber(String numero)
	{
		Contact owner = null;
		try
		{
			con = this.getConnection();
			String req = "select idContact from telephone where numero=?";
	
			ps = con.prepareStatement(req);
			
			ps.setString(1, numero);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				owner = getContactById(rs.getInt("idContact"));
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
		return owner;
	}

	public boolean deleteContact(int idContact) 
	{
		int changes = 0;
		try
		{
			con = this.getConnection();
			String req = "delete from contact where idContact=?";
	
			ps = con.prepareStatement(req);
			
			ps.setInt(1, idContact);
			
			changes = ps.executeUpdate();
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
		return changes>0;
	}

	
	public int getIdByContact(Contact contact) {

		int idContact = 0;
		
		try
		{
			con = this.getConnection();
			String req = "select idContact from contact where nom=? and prenom=? and email=?";
	
			ps = con.prepareStatement(req);
			
			ps.setString(1, contact.getNom());
			ps.setString(2, contact.getPrenom());
			ps.setString(3, contact.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				idContact = rs.getInt("idContact");
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
		return idContact;
	}

	public ArrayList<Contact> getNoGroupContacts()
	{
		ArrayList<Contact> list = new ArrayList<Contact>();
		for(Contact c : this.getContacts())
		{	
			System.out.println(c.getNom()+" : "+c.getIdGroupe());
			if(c.getIdGroupe()==0)
				list.add(c);
			
		}
		
		return list;
	}
	
	public Groupe getGroupByContactId(int idContact) {
		
		Groupe g = null;
		try
		{
			con = this.getConnection();
			String req = "select idGroupe from contact where idContact=?";
			ps = con.prepareStatement(req);
			ps.setInt(1, idContact);
			ResultSet rs = ps.executeQuery() ;
			System.out.println(ps);
			if(rs.next())
			{
				GroupeService gs = new GroupeService();
				int idGroupe = rs.getInt("idGroupe");
				g=new Groupe(idGroupe, gs.getGroupNameById(idGroupe));
			}
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

	public boolean addContactToGroup(int idContact, int idGroupe) 
	{
		int changes = 0;
		
		try
		{
			con = this.getConnection();
			String req = "update contact set idGroupe=? where idContact=?";
			ps = con.prepareStatement(req);
			ps.setInt(1, idGroupe);
			ps.setInt(2, idContact);
			
			System.out.println(ps);
			changes = ps.executeUpdate();
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

		return changes>0;
	}
}
