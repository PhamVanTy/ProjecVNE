package model.bean;

public class FriendList {
	private int flID;
	private String flName;
	public int getFlID() {
		return flID;
	}
	public void setFlID(int flID) {
		this.flID = flID;
	}
	public String getFlName() {
		return flName;
	}
	public void setFlName(String flName) {
		this.flName = flName;
	}
	public FriendList(int flID, String flName) {
		super();
		this.flID = flID;
		this.flName = flName;
	}
	public FriendList() {
		super();
	}
	
}
