public abstract class Customer {

	// Variables
	public String type;
	public String name;
	public int rentalDaysLeft;

	// Methods
	public void rent(int num){
		this.rentalDaysLeft -= num;
	} // Decrement rental days left
	public int getRentalDaysLeft(){
		return this.rentalDaysLeft;
	} // Return number of days left for a tool
	public void returnRental() {
		this.rentalDaysLeft++;
	} // Increment rental days by a day
	public String getType(){
		return this.type;
	} // Return tool type
	public String getName(){
		return this.name;
	} // Return tool name
}
