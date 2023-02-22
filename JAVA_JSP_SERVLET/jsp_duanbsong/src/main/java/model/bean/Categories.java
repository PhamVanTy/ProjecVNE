package model.bean;

public class Categories {
	private int id_cat;
	private String cat_name;
	public int getIdCat() {
		return id_cat;
	}
	public void setIdCat(int id_cat) {
		this.id_cat = id_cat;
	}
	public String getCatName() {
		return cat_name;
	}
	public void setCatName(String cat_name) {
		this.cat_name = cat_name;
	}
	public Categories(int id_cat, String cat_name) {
		super();
		this.id_cat = id_cat;
		this.cat_name = cat_name;
	}
	public Categories() {
		super();
	}

	
}
