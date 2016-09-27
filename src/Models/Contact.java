package Models;

import java.util.ArrayList;

public class Contact {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	
	private ArrayList<Telephone> telephoneListe;
	private Adresse adresse;
	
	public Contact(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Contact(String nom, String prenom, String email)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Telephone> getTelephoneListe() {
		return telephoneListe;
	}

	public void setTelephoneListe(ArrayList<Telephone> telephoneListe) {
		this.telephoneListe = telephoneListe;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public void addTelephone(Telephone t)
	{
		this.telephoneListe.add(t);
	}
}
