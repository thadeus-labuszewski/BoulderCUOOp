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

		// Loop through list of customers and pick one based off a random int
		for(Customer customer: customerList){
			int randomInt = getRandomInt(2);
			int toolListLength = toolList.size();
			int rentalDaysLeftPerCustomer = customer.getRentalDaysLeft();
			String customerType = customer.getType();


			if(randomInt != 0){
				System.out.println(customerInStoreToString(customer));

				// Business customer case
				if(customerType.equals("business") && toolListLength >=3){
					//System.out.println("a BUSINESS customer came in and about to rent 3 tools");
					// pick up three tools
					// get first three things out of the tool list (do the remove option three times)
					rentOneTool(customer, 7);
					rentOneTool(customer, 7);
					rentOneTool(customer, 7);
					
				}else if(((rentalDaysLeftPerCustomer) >0) && (toolList.size()>0)){
					if(customerType.equals("casual")){
						// randomize daysRentedForUniqueTool
						int daysRentedForUniqueTool = getRandomInt(3);
						// randomize the number of tools wanted to rent
						int m = getRandomInt(3);
						int a = Math.min(Math.min(rentalDaysLeftPerCustomer, m), toolListLength);
						for(int i=0; i< a; i++){
							rentOneTool(customer, daysRentedForUniqueTool);
						}
					}else if (customerType.equals("regular")){
						// randomize days
						int days = getRandomInt(6);
						// randomize the number of tools wanted to rent
						int m = getRandomInt(4);
						int a = Math.min(Math.min(rentalDaysLeftPerCustomer, m), toolListLength);;
						for(int i=0; i< m; i++){
							rentOneTool(customer, days);
						}
					}
				}
			}
		} 

		// iterate the rental list to check the tools that need to be returned
		Iterator<Rental> iter = currentRentalsList.iterator();
		while (iter.hasNext()) {
		    Rental rental = iter.next();
		    if(rental.getRemainingDays() == 0){
				rental.getCustomer().returnRental(); // customer does not need to know what tool they have rented or returned
				// get the tool back to the list
				toolList.add(rental.getTool());
				// how to remove the current rental
				iter.remove();
				System.out.println(rental.getToolName() + " is returned by ["+ rental.getCustomerName()+"]");
			}else{
				rental.deductOneDay();
			}
		}
	}

	public void rentOneTool(Customer customer, int days){
		if(toolList.size() == 0) // prevent the randomization requires the positive number
			return;
		
		customer.rent(1);
		
		// get a random tool from the available tool list
		Random rand = new Random();
		int index = rand.nextInt(this.toolList.size());
		Tool tool = toolList.remove(index);
	
		// add to rental record
		double amount = tool.getPrice()*days;
		this.profit += amount;
		Rental newRental = new Rental(customer, tool, days, amount); // choose days to rent
		System.out.println(customer.getName() + " [" +customer.getType() + "] rents out "+ tool.getName() + " for " + days + " days with $" + amount + " amount");
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
	
	public String customerToString(){
		String str = "In the customer list : ";
		for(Customer customer: customerList){
			str += "( " + customer.getType() + ", " + customer.getName() + ", "+ customer.getRentalDaysLeft() + " )";
		}
		
		return str;
	}

	public String customerInStoreToString(Customer customer){
		String str = customer.getName()+ " [" +customer.getType() + "] walks into our the store...";
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
