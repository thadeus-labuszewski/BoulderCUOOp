
public class Woodwork extends Tool{

	// Constructor
	Woodwork(String name, String category) {
		this.name = name;
		this.category = category;
		setPrice();
	}

	@Override
	public void setPrice() {
		this.price = 3.0;
	}
}
