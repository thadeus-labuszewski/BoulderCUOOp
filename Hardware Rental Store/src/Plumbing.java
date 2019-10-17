
public class Plumbing extends Tool{

	// Constructor
	Plumbing(String name, String category) {
		this.name = name;
		this.category = category;
		setPrice();
	}

	@Override
	public void setPrice() {
		this.price = 3.0;
		
	}

}
