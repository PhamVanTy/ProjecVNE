package model.bean;

import java.util.Date;

public class Friends {
	private int fID;
	private String name;
	private String preview;
	private String detail;
	private Date dateCreate;
	private int countNum;
	private String picture;
	private int flID;
	public int getFlID() {
		return flID;
	}
	public void setFlID(int flID) {
		this.flID = flID;
	}
	public int getfID() {
		return fID;
	}
	public void setfID(int fID) {
		this.fID = fID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	public int getCountNum() {
		return countNum;
	}
	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Friends(int fID, String name, String preview, String detail, Date dateCreate, int countNum, String picture) {
		super();
		this.fID = fID;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.dateCreate = dateCreate;
		this.countNum = countNum;
		this.picture = picture;
	}
	public Friends() {
		super();
	}
	public Friends(int fID, String name, String preview, String detail, Date dateCreate, int countNum, String picture,
			int flID) {
		super();
		this.fID = fID;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.dateCreate = dateCreate;
		this.countNum = countNum;
		this.picture = picture;
		this.flID = flID;
	}
	
	
}
