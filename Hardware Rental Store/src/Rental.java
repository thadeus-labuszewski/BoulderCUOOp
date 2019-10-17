// Creates a unique rental record for each transaction
public class Rental {

	// Variables
	private Customer customer; // Customer object
	private Tool tool; // Tool object
	private int remainingDays; // Days left for particular tool rental
	private int initialDays; // Days tool can be rented out based on customer
	private double toolPrice; // Price of tool


	// Constructor: takes in a Customer, Tool, Rental Period and Tool Cost
	public Rental(Customer customer, Tool tool, int initialDays, double toolPrice){
		this.customer = customer;
		this.tool = tool;
		this.initialDays = initialDays;
		this.remainingDays = this.initialDays;
		this.toolPrice = toolPrice;
	}

	// Methods
	public void deductOneDay(){
		this.remainingDays -= 1;
	} // Decrement remainingDays
	public int getRemainingDays(){
		return this.remainingDays;
	} // Return days left in rental period
	public int getInitialDays(){
		return this.initialDays;
	} // Return initial days
	public Tool getTool(){
		return this.tool;
	} // Return tool
	public String getToolName(){
		return this.tool.getName();
	} // Return tool name
	public String getCustomerName(){
		return this.customer.getName();
	} // Return customer name
	public Customer getCustomer(){
		return this.customer;
	} // Return customer
	public Double getToolPrice(){
		return this.toolPrice;
	} // Return cost of tool
}
