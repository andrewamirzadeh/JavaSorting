import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaReviewAssignment {

	private static final int ADD_AIRCRAFT = 1;
	private static final int GET_PASSENGER_AVERAGE = 2;
	private static final int EXIT = 3;

	private static Scanner input = new Scanner(System.in);

	static ArrayList<Aircraft> aircrafts = new ArrayList<>();

	public static void main(String[] args) {


		int response;

		do {
			response = menu();
			switch(response) {
			
			case ADD_AIRCRAFT:
				Aircraft aircraft = null;
				
				aircraft = new Aircraft(
						getString("Enter the name of the manufacturer of the aircraft: "),
						getString("Enter the model of the aircraft: "), 
						getInt("Enter the miles per hour the aircraft can travel: "), 
						getInt("Enter the maximum number of passengers the aircraft can hold: "), 
						getInt("Enter the range that the aircraft can travel: "));
				
				
				aircrafts.add(aircraft);
				break;
					
			case GET_PASSENGER_AVERAGE:
				
				if (aircrafts.size() <= 0) {
					System.out.print("There are currently no aircrafts in the inventory!\n");
				}
				else {
					int avgSum = 0;
					for (int i = 0; i < aircrafts.size(); i++)
					{
						avgSum += aircrafts.get(i).getNumPassengers();
						
					}
					double newSum = (double) avgSum /aircrafts.size();
					System.out.printf("The average number of passengers for all aircrafts is:  %.2f \n", newSum);
				}
				break;
			
			case EXIT:
				System.out.println("Thanks for using my program!");



			}
		} while (response != EXIT);


	}
	


	private static int getInt(String prompt) {
		int r;
		do {
			
			System.out.print(prompt);
			r = input.nextInt();
			input.nextLine();
			
			if (r <= 0) {
				System.out.print("The value entered must be greater than 0. Please re-enter the value: ");
			}
			
		} while (r <= 0);
		return r;
	}

	private static String getString(String prompt) {
		String r;
		do {
			System.out.print(prompt);
			
			r = input.nextLine();
			if (r == null || r.length() < 1) {
				System.out.print("The name can not be null or less than 1. Please re-enter value: ");
			}
			
		} while (r == null || r.length() < 1);
		return r;
	}

	private static int menu() {
		int userResponse = 0;
		
		do {
			try {
				System.out.println("1. Add an Aircraft.  \n2. List the average of passengers for all aircraft. \n3. Exit");
				userResponse = input.nextInt();
				input.nextLine();
				if (userResponse < 1 || userResponse > 5 ) {
					System.out.println("Enter a value of 1 to 3!");
				}
				
				
			} catch (Exception E) {
				System.out.println("Please enter a valid value!");
			} 
			
		} while (userResponse < 1 || userResponse > 3);
		
		return userResponse;
	}

	// Create a class that represents an aircraft, with data fields for the
	// manufacturer (e.g., Boeing),
	// the model (e.g., 777), the top air speed in miles per hour, the maximum
	// number of passengers and the range in miles.
	static class Aircraft {

		private String manufacturer;
		private String model;
		private int mph;
		private int numPassengers;
		private int range;

		public Aircraft(String newManufacturer, String newModel, int newMph, int newNumPassengers, int newRange) {

			setManufacturer(newManufacturer);
			setModel(newModel);
			setMph(newMph);
			setNumPassengers(newNumPassengers);
			setRange(newRange);

		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public int getMph() {
			return mph;
		}

		public void setMph(int mph) {
			this.mph = mph;
		}

		public int getNumPassengers() {
			return numPassengers;
		}

		public void setNumPassengers(int numPassengers) {
			this.numPassengers = numPassengers;
		}

		public int getRange() {
			return range;
		}

		public void setRange(int range) {
			this.range = range;
		}

	}
	


}
