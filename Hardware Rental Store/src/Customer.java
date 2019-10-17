public abstract class Customer {

	// Variables
	public String type;
	public String name;
	public int rentalDaysPerCustomer;

	// Methods
	public void rent(int num){
		this.rentalDaysPerCustomer -= num;
	} // Decrement rental days left
	public int getRentalDaysPerCustomer(){
		return this.rentalDaysPerCustomer;
	} // Return number of days left for a tool
	public void returnRental() {
		this.rentalDaysPerCustomer++;
	} // Increment rental days by a day
	public String getType(){
		return this.type;
	} // Return tool type
	public String getName(){
		return this.name;
	} // Return tool name
}
