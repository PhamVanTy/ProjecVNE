package model.bean;

public class Contacts {

	private String fullName;
	private String email;
	private String subject;
	private String content;

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Contacts( String fullName, String email, String subject, String content) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.subject = subject;
		this.content = content;
	}
	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
