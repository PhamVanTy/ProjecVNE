package model.bean;

import java.util.Date;

public class Lands {
	private int lId;
	private String lName;
	private String descript;
	private String date_create;
	private int cId;
	private String picture;
	private int area;
	private String address;
	private int count;
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getDate_create() {
		return date_create;
	}
	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Lands(int lId, String lName, String descript, String date_create, int cId, String picture, int area,
			String address, int count) {
		super();
		this.lId = lId;
		this.lName = lName;
		this.descript = descript;
		this.date_create = date_create;
		this.cId = cId;
		this.picture = picture;
		this.area = area;
		this.address = address;
		this.count = count;
	}
	public Lands() {
		super();
	}
	
	
	
}
