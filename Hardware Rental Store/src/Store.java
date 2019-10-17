import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// Main class for running store, all of our store logic is built here
public class Store {

	// Store Variables
	private CustomerFactory customerFactory;
	private ToolFactory toolFactory;
	private List<Customer> customerList;
	private List<Tool> toolList; 
	private List<Rental> currentRentalsList;
	private List<Rental> completedRentalList;
	private float profit;

	// Default store constructor
	public Store(){
		this.profit = 0;
		init();
	}

	// Init
	private void init(){
		customerFactory = new CustomerFactory();
		toolFactory = new ToolFactory();
		customerList = customerFactory.getListOfCustomers();
		toolList = toolFactory.getListOfTools();
		currentRentalsList = new ArrayList<Rental>();
		completedRentalList = new ArrayList<Rental>();
	}

	// Return Store profit
	public float getProfit(){
		return this.profit;
	}

	// Return random int based on bound
	public int getRandomInt(int bound){
		Random rand = new Random();
		int randomInteger = rand.nextInt(bound);
		return randomInteger;
	}

	// One Day Simulation
	public void daySimulation(){
		System.out.println("Number of tools currently in our store: "+ toolList.size());
		System.out.println(toolToString());

		// Loop through list of customers and pick them based off a random int
		for(Customer customer: customerList){
			int randomInt = getRandomInt(2);
			int toolListLength = toolList.size();
			int rentalDaysLeftPerCustomer = customer.getRentalDaysPerCustomer();
			String customerType = customer.getType();

			if(randomInt != 0){
				System.out.println(customerInStoreToString(customer));
				// Business customer case
				if(customerType.equals("business") && toolListLength >=3){
					// Business customers rent always rent 3 tools for 7 days
					for(int i = 0; i <= 2; i ++){
						rentSingleTool(customer, 7);
					}
					
				}else if(((rentalDaysLeftPerCustomer) > 0) && (toolListLength > 0)){

					if(customerType.equals("casual")){

						// Casual customer can rent 1-2 days
						int daysRentedForUniqueCustomer = getRandomInt(2);
						while (daysRentedForUniqueCustomer == 0){
							daysRentedForUniqueCustomer = getRandomInt(2);
						}

						// Casual customer can rent 1-2 tools
						int daysRentedForUniqueTool = getRandomInt(2);
						while (daysRentedForUniqueTool == 0){
							daysRentedForUniqueTool = getRandomInt(2);
						}

						// rentOneTool a random amount of times based on casual customer requirements
						for(int i=0; i< daysRentedForUniqueCustomer; i++){
							rentSingleTool(customer, daysRentedForUniqueTool);
						}
					}else if (customerType.equals("regular")){

						// Regular customers can rent 3-5 days
						int daysRentedForUniqueCustomer = getRandomInt(5);
						while (daysRentedForUniqueCustomer <=2){
							daysRentedForUniqueCustomer = getRandomInt(5);
						}
						// Regular customers can rent 1-3 tools
						int daysRentedForUniqueTool = getRandomInt(3);
						while (daysRentedForUniqueTool == 0){
							daysRentedForUniqueTool = getRandomInt(3);
						}
						// rentOneTool a random amount of times based on regular customer requirements
						for(int i=0; i< daysRentedForUniqueCustomer; i++){
							rentSingleTool(customer, daysRentedForUniqueTool);
						}
					}
				}
			}
		}
		// Update our list of active rentals
		updateRentalList();
	}

	// Update rental list after each day
	public void updateRentalList(){
		Iterator<Rental> rentalListIterator = currentRentalsList.iterator();
		while (rentalListIterator.hasNext()) {
			Rental currentRental = rentalListIterator.next();
			// Check to see if we need to return a particular tool
			if(currentRental.getRemainingDays() == 0){
				// Return rental
				currentRental.getCustomer().returnRental();
				// Add tool back to the list
				toolList.add(currentRental.getTool());
				// Remove the currentRental from our iterator
				rentalListIterator.remove();
				System.out.println(customerRentToString(currentRental));
			}else{
				// Subtract a day from tool rental if we still have days left
				currentRental.deductOneDay();
			}
		}
	}

	public Tool pickRandomToolFromAvailableList(int toolListLength){
		Random rand = new Random();
		int index = rand.nextInt(toolListLength);
		Tool tool = toolList.remove(index);
		return tool;
	}

	public void rentSingleTool(Customer customer, int days){


		int toolListLength = this.toolList.size();
		// If we dont have any tools left then we cant rent anything out
		if(toolListLength == 0){ return;}

		// Call rent method
		customer.rent(1);

		// Get random currentTool
		Tool currentTool = pickRandomToolFromAvailableList(toolListLength);

		// Calculate money related variables
		double totalCost = currentTool.getPrice()*days;
		this.profit += totalCost;
		// Create a new rental record
		Rental newRental = new Rental(customer, currentTool, days, totalCost);
		System.out.println(rentalRecordCreationToString(customer, currentTool, days, totalCost));
		currentRentalsList.add(newRental);
		completedRentalList.add(newRental);
	}

	public String toolToString(){
		String str = "In the tool list : ";
		for(Tool tool: toolList){
			str += "[ " + tool.getName() + ", $"+ tool.getPrice() + " ], ";
		}
		return str;
	}

	// Printing methods
	public String customerToString(){
		String str = "In the customer list : ";
		for(Customer customer: customerList){
			str += "( " + customer.getType() + ", " + customer.getName() + ", "+ customer.getRentalDaysPerCustomer() + " )";
		}
		return str;
	}

	public String customerInStoreToString(Customer customer){
		String str = customer.getName()+ " [" +customer.getType() + "] walks into our the store...";
		return str;
	}

	public String customerRentToString(Rental rental){
		String str =rental.getCustomerName()+ " [" +rental.getCustomerType() + "]" + "  returns " + rental.getToolName();
		return str;
	}

	public String rentalRecordCreationToString(Customer customer, Tool currentTool, int days, double totalCost){
		String str = customer.getName() + " [" +customer.getType() + "] rents out "+ currentTool.getName() + " for " + days + " days with $" + totalCost + " totalCost";
		return str;
	}
	
	public String activeRentalToString(){
		String str = "Active rental list :\n";
		for(Rental rental: currentRentalsList){
			str += "( " + rental.getCustomerName() + " rented " + rental.getToolName() + " for "+ rental.getRemainingDays() + " days with amount $"+rental.getToolPrice()+" )\n";
		}
		return str;
	}
	
	public String completedRentalToString(){
		String str = "Completed rental list :\n";
		for(Rental rental: completedRentalList){
			str += "( " + rental.getCustomerName() + " rented " + rental.getToolName() + " for "+ rental.getInitialDays() + " days with amount $"+rental.getToolPrice()+" )\n";
		}
		return str;
	}
}
