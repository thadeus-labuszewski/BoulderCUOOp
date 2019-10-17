import java.util.ArrayList;
import java.util.List;

public class CustomerFactory {

	// List of Customers
	public List<Customer> ListOfCustomers;

	// Default Constructor
	public CustomerFactory(){
		ListOfCustomers = new ArrayList<Customer>();
		this.ListOfCustomers = createListOfCustomers();
	}

	// Getter method for List of Customers
	public List<Customer> getListOfCustomers(){
		return this.ListOfCustomers;
	}

	// Factory
	public static Customer getCustomer(String type,String name) {

		if(type.equals("regular")) {
			return new Regular("regular", name);
		}
		if(type.equals("business")){
			return new Business("business",name);
		}
		if(type.equals("casual")) {
			return new Casual("casual", name);
		}
		else
			return null;
	}

	// Create list of Customers
	public List<Customer> createListOfCustomers(){

		Customer tom = CustomerFactory.getCustomer("casual", "Tom");
		Customer jon = CustomerFactory.getCustomer("casual", "Jon");
		Customer bon = CustomerFactory.getCustomer("casual", "Bon");
		Customer zon = CustomerFactory.getCustomer("casual", "Zon");

		Customer julie = CustomerFactory.getCustomer("regular", "Julie");
		Customer stacy = CustomerFactory.getCustomer("regular", "Stacy");
		Customer emily = CustomerFactory.getCustomer("regular", "Emily");
		Customer charlotte = CustomerFactory.getCustomer("regular", "Charlotte");

		Customer caleb = CustomerFactory.getCustomer("business", "Caleb");
		Customer ali = CustomerFactory.getCustomer("business", "Ali");
		Customer thad = CustomerFactory.getCustomer("business", "Thad");
		Customer jason = CustomerFactory.getCustomer("business", "Jason");

		ListOfCustomers.add(tom);
		ListOfCustomers.add(jon);
		ListOfCustomers.add(bon);
		ListOfCustomers.add(zon);
		ListOfCustomers.add(julie);
		ListOfCustomers.add(stacy);
		ListOfCustomers.add(emily);
		ListOfCustomers.add(charlotte);
		ListOfCustomers.add(caleb);
		ListOfCustomers.add(ali);
		ListOfCustomers.add(thad);
		ListOfCustomers.add(jason);

		return this.ListOfCustomers;
	}

	// Method for printing
	public String toString(){
		String str = "In the customer list : ";
		for(Customer customer: ListOfCustomers){
			str += "( " + customer.getType() + ", " + customer.getName() + ", "+ customer.getRentalDaysPerCustomer() + " )";
		}
		return str;
	}
}
