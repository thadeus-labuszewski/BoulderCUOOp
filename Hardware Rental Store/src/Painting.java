
public class Painting extends Tool {

	// Constructor
	Painting(String name, String category) {
		this.name = name;
		this.category = category;
		setPrice();
	}


	@Override
	public void setPrice() {
		this.price = 2.0;
		
	}


}
