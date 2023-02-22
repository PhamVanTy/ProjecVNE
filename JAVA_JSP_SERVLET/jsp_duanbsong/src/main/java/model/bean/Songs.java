package model.bean;

public class Songs {
	private int idSong;
	private String songName;
	private String preview_text;
	private String detail_text;
	private String date_create;
	private String picture;
	private int counter;
	private int id_cat;
	public int getIdSong() {
		return idSong;
	}
	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getPreview_text() {
		return preview_text;
	}
	public void setPreview_text(String preview_text) {
		this.preview_text = preview_text;
	}
	public String getDetail_text() {
		return detail_text;
	}
	public void setDetail_text(String detail_text) {
		this.detail_text = detail_text;
	}
	public String getDate_create() {
		return date_create;
	}
	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public Songs(int idSong, String songName, String preview_text, String detail_text, String date_create,
			String picture, int counter, int id_cat) {
		super();
		this.idSong = idSong;
		this.songName = songName;
		this.preview_text = preview_text;
		this.detail_text = detail_text;
		this.date_create = date_create;
		this.picture = picture;
		this.counter = counter;
		this.id_cat = id_cat;
	}
	public Songs() {
		super();
	}
	
}
