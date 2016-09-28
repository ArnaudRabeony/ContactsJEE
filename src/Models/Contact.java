package Models;

import java.util.ArrayList;

public class Contact {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	
	private ArrayList<Telephone> telephonesListe;
	private ArrayList<Groupe> groupesListe;
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

	public ArrayList<Telephone> getTelephonesListe() {
		return telephonesListe;
	}

	public void setTelephonesListe(ArrayList<Telephone> telephonesListe) {
		this.telephonesListe = telephonesListe;
	}
	
	public ArrayList<Groupe> getGroupesListe() {
		return groupesListe;
	}

	public void setGroupesListe(ArrayList<Groupe> groupesListe) {
		this.groupesListe = groupesListe;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public void addTelephone(Telephone t)
	{
		this.telephonesListe.add(t);
	}
	
	public void addGroupe(Groupe g)
	{
		this.groupesListe.add(g);
	}

	public void removeTelephone(String numero) {
		this.telephonesListe.remove(numero);
	}
}
