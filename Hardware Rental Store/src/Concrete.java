
public class Concrete extends Tool {

	// Constructor
	Concrete(String name, String category) {
		this.name = name;
		this.category = category;
		setPrice();
	}

	@Override
	public void setPrice() {
		this.price = 1.0;
	}
}