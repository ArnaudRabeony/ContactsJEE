package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Contact;
import Models.Groupe;
import Models.Telephone;
import ServiceEntities.ContactService;

public class TelephoneDAO 
{
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;
	
	public TelephoneDAO()
	{
		con = GlobalConnexion.getConnection();
	}
	
	public Connection getConnection()
	{
		return GlobalConnexion.getConnection();
	}
	
	public Telephone createTelephone(String type, String numero, Contact contactOwner)
	{
		Telephone t = null;
		
		System.out.println("Creation du tel : "+type+" | "+numero+" idContact "+contactOwner.getId());
		
		try
		{		
		con = this.getConnection();

		String req = "insert into telephone(type,numero,idContact) values(?,?,?)";

		ps = con.prepareStatement(req);
		ps.setString(1, type);
		ps.setString(2, numero);
		ps.setInt(3, contactOwner.getId());
		
		System.out.println(ps);
		ps.execute();
		
		t = new Telephone(type, numero);
		contactOwner.addTelephone(t);
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
		
		return t;
	}
	
	public void deleteTelephone(String numero)
	{
		System.out.println("Suppression : "+numero);
		
		try
		{
		con = this.getConnection();
		String req = "delete from telephone where numero=?";
	
		ps = con.prepareStatement(req);;
		ps.setString(1, numero);
		
		System.out.println(ps);
		
		ContactService cs = new ContactService();
		Contact owner = cs.getContactOwnerByNumber(numero);
		owner.removeTelephone(numero);
		
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
	
	public void updateNumero(int idTelephone, String newType, String newNumero)
	{
		System.out.println("MAJ du tel : "+idTelephone+"\n"+newNumero);
		
		try
		{
		con = this.getConnection();
		String req = "update contact set type=?,numero=? where idTelephone=?";

		ps = con.prepareStatement(req);;
		ps.setString(1, newType);
		ps.setString(2, newNumero);
		ps.setInt(3, idTelephone);
		
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
	
	public ArrayList<Telephone> getTelephonesByContact(Contact contact)
	{
		ArrayList<Telephone> list = new ArrayList<Telephone>();
		
		try
		{
			con = this.getConnection();
			String req = "select type,numero from telephone where idContact=?";
			
			ps = con.prepareStatement(req);
			ps.setInt(1, contact.getId());

			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String type = rs.getString("type");
				String numero = rs.getString("numero");
				
				list.add(new Telephone(type, numero, contact));
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
	
	public String getNumberById(int id)
	{
		String number = null;
		try
		{
			con = this.getConnection();
			String req = "select number from telephone where idTelephone=?";
	
			ps = con.prepareStatement(req);;
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			number=rs.getString("number");
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

		return number;
	}
	
	public int getIdByNumber(String numero)
	{
		int id = -1;
		try
		{
			con = this.getConnection();
			String req = "select idTelephone from telephone where numero=?";
	
			ps = con.prepareStatement(req);;
			ps.setString(1, numero);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			id=Integer.valueOf(rs.getString("idTelephone"));
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

		return id;
	}
}
