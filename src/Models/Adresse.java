package Models;

public class Adresse {
	
	private int id;
	private String rue;
	private String ville;
	private String codePostal;
	private String pays;
	private int idContact;
	
	public Adresse(String rue, String ville, String codePostal, String pays) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
	}
	
	public Adresse(int id, String rue, String ville, String codePostal,
			String pays) {
		super();
		this.id = id;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
	}
	
	public Adresse(int id, String rue, String ville, String codePostal,
			String pays, int idContact) {
		super();
		this.id = id;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
		this.idContact = idContact;
	}
	
	public int getIdContact() {
		return idContact;
	}

	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
}
