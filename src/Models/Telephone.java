package Models;

public class Telephone {

	private int id;
	private String phoneKind;
	private String number;
	private Contact contact;

	public Telephone(String phoneKind, String number) {
		super();
		this.phoneKind = phoneKind;
		this.number = number;
	}
	
	public Telephone(String phoneKind, String number, Contact contact) {
		super();
		this.phoneKind = phoneKind;
		this.number = number;
		this.contact = contact;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoneKind() {
		return phoneKind;
	}
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
