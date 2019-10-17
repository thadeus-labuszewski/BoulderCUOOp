public abstract class Tool {

	// Variables
	public double price;
	public String name;
	public String category;

	// Methods
	public String getName(){
		return this.name;
	} // Returns name of tool
	public double getPrice(){
		return this.price;
	} // Returns price of tool
	public String getCategory() { return this.category; } // Returns category of tool
	public abstract void setPrice(); // Set price of tool (done in subclasses based off category)
}
