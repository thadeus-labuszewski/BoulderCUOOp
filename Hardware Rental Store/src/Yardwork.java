
public class Yardwork extends Tool{

	// Constructor
	Yardwork(String name, String category) {
		this.name = name;
		this.category = category;
		setPrice();
	}

	@Override
	public void setPrice() {
		this.price = 4.0;
	}
}
