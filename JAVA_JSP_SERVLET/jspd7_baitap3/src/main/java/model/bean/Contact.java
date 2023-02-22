package model.bean;

public class Contact {
	private String name;
	private String email;
	private int phone;
	private String content;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Contact(String name, String email, int phone, String content) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.content = content;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
