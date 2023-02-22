package ShopHoaController;

public class DoiTuongHoa {
	private String name;
	private int id;
	private float price;
	private int number;

	public DoiTuongHoa(String name, int id, float price, int number) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
		this.number = number;
	
	}
	public DoiTuongHoa() {
	}
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
