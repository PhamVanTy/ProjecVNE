package bean;

public class DoiTuongHoa {
	private String name;
	private int id;
	private int number;
	private float price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public DoiTuongHoa(String name, int id, int number, float price) {
		super();
		this.name = name;
		this.id = id;
		this.number = number;
		this.price = price;
	}
	public DoiTuongHoa() {
	}
	
}
