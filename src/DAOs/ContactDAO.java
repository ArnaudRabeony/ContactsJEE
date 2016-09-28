package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Contact;

public class ContactDAO {

	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;
	
	String driver="com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/pweb?autoReconnect=true&useSSL=false";
	String uid = "root";
	String passwd = "root";

	public ContactDAO()
	{
		con = this.getConnection();
	}
	
	public Connection getConnection()
	{
		try
		{
		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, passwd);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void createContact(String nom,String prenom,String email)
	{
		System.out.println("Creation du compte : "+nom+" | "+prenom+" | "+email);
		
		try
		{		
		con = this.getConnection();

		String req = "insert into contact(nom,prenom,email) values(?,?,?)";

		ps = con.prepareStatement(req);
		ps.setString(1, nom);
		ps.setString(2, prenom);
		ps.setString(3, email);
		
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
	
	public void deleteContact(String condition, Object value)
	{
		value = String.valueOf(value);
		String val = (String)value;
		
		System.out.println("Suppression : "+condition+"="+val);
		
		try
		{
		con = this.getConnection();
		String req = "delete from contact where "+condition+"=?";
	
			ps = con.prepareStatement(req);;
			
			if(condition.equals("id"))
				ps.setInt(1, Integer.parseInt(val));
			else
				ps.setString(1, val);
		
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
	
	public void updateContact(int id, String nom,String prenom,String email)
	{
		System.out.println("MAJ du compte : "+id+"\n"+nom+" "+prenom+"\n"+email);
		
		try
		{
		con = this.getConnection();
		String req = "update contact set nom=?,prenom=?,email=? where id=?";

		ps = con.prepareStatement(req);;
		ps.setString(1, nom);
		ps.setString(2, prenom);
		ps.setString(3, email);
		ps.setInt(4, id);
		
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
	
	public Contact searchContact(String condition, Object value)
	{
		value = String.valueOf(value);
		System.out.println(value);
		String val = (String)value;
		System.out.println("Recherche du compte : "+condition+"="+val);
		Contact contact = null;
		
		try
		{
			con = this.getConnection();
			String req = "select * from contact where "+condition+"=?";
	
			ps = con.prepareStatement(req);;
			
			if(condition.equals("id"))
				ps.setInt(1, Integer.parseInt(val));
			else
				ps.setString(1, val);
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			int id = rs.getInt("id");
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
			ps = con.prepareStatement(req);;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				
				list.add(new Contact(id, nom, prenom, email));
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
	
			ps = con.prepareStatement(req);;
			
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
	
	public boolean contactExists(int id)
	{
		boolean exists = false;
		try
		{
			con = this.getConnection();
			String req = "select * from contact where id=?";
	
			ps = con.prepareStatement(req);;
			
			ps.setInt(1, id);
			
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
	
}
