package model.bean;

public class Categories {
	private String cName;
	private int cid;
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Categories(String cName) {
		super();
		this.cName = cName;
	}
	public Categories(String cName, int cid) {
		super();
		this.cName = cName;
		this.cid = cid;
	}

	public Categories() {
		super();
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}
	
}
