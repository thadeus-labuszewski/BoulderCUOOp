public class Main {

	public static void main(String args[]){

		// Simulation store
		Store BoulderHardware = new Store();

		// Run through 35 days of simulation
		for(int i=1; i<=35; i++){
			System.out.println("---------------------Current Day: "+ i + " -----------------------------");
			BoulderHardware.daySimulation();
			System.out.println("---------------------End of day " + i + " ----------------------------\n");
		}

		// Create a report at the end of the season
		System.out.println("-----------------------End of season report------------------------");
		System.out.println("The completed rentals: " + BoulderHardware.completedRentalToString());
		System.out.println("The active rentals: "+BoulderHardware.activeRentalToString() );
		System.out.println("The money earned is: $"+ BoulderHardware.getProfit());
	}
}
