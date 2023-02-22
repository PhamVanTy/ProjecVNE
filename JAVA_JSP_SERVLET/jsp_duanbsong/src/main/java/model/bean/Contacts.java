package model.bean;

public class Contacts {
	private int idContact;
	private String contactName;
	private String email;
	private String website;
	private String message;
	public int getIdContact() {
		return idContact;
	}
	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Contacts(int idContact, String contactName, String email, String website, String message) {
		super();
		this.idContact = idContact;
		this.contactName = contactName;
		this.email = email;
		this.website = website;
		this.message = message;
	}
	public Contacts() {
		super();
	}
	
	
}
