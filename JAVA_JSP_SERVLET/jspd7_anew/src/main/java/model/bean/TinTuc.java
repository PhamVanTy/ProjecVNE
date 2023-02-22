package model.bean;

public class TinTuc {
	private int idNews;
	private String name;
	private String preview;
	private String detail;
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getIdNews() {
		return idNews;
	}
	public void setIdNews(int idNews) {
		this.idNews = idNews;
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
	public TinTuc(int idNews, String name, String preview) {
		super();
		this.idNews = idNews;
		this.name = name;
		this.preview = preview;
	}
	public TinTuc() {
		super();
	}
	public TinTuc(int idNews, String name, String preview, String detail) {
		super();
		this.idNews = idNews;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
	}
	
}
