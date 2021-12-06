
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class Chap11Asign {

	private static final int USE_GUMBALL_MACHINE = 1;
	private static final int USE_SODA_MACHINE = 2;
	private static final int EXIT = 3;

	private static Scanner input = new Scanner(System.in);

	static GumballMachine machine = new GumballMachine();
	//When the program starts, create an instance of the second vending machine type
	static SodaMachine machine1 = new SodaMachine();

	public static void main(String[] args) {


		int response;

		do {
			response = menu();
			switch(response) {
			
			case USE_GUMBALL_MACHINE:
				while (true) {
					out.print("(V)end, (R)efill or (E)xit: ");
					String choice = input.nextLine();
					
					if (choice.toLowerCase().equals("v")) {
						out.println(machine.dispense());
					}
					else if (choice.toLowerCase().equals("r")) {
						out.print("Enter amount to refill: ");
						int amount = input.nextInt();
						input.nextLine();
						machine.refill(amount);
						out.println("Refilled...");
					}
					else if (choice.toLowerCase().equals("e")) {
						out.println("Thanks for using the program!");
						break;
					}
				}
			case USE_SODA_MACHINE:
				
				while (true) {
					out.print("(V)end, (R)efill or (E)xit: ");
					String choice = input.nextLine();
					
					if (choice.toLowerCase().equals("v")) {
						out.println(machine1.dispense());
					}
					else if (choice.toLowerCase().equals("r")) {
						out.print("Enter amount to refill: ");
						int amount = input.nextInt();
						input.nextLine();
						machine1.refill(amount);
						out.println("Refilled...");
					}
					else if (choice.toLowerCase().equals("e")) {
						out.print("Thanks for using the program!");
						break;
					}
					else
						out.println("Invalid choice!");
					
					}
			
			case EXIT:
				System.out.println("Thanks for using my program!");



			}
		} while (response != EXIT);


	}
	

	private static int menu() {
		int userResponse = 0;
		
		do {
			try {
				System.out.println("1. Use Gumball Machine.  \n2. Use Soda Machine. \n3. Exit");
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

	
	interface VendingMachine{
		void refill(int count);
		String dispense();
		boolean isEmpty();
	}

	//second machine class that implements interface of vending machine
	static class SodaMachine implements VendingMachine{
		//initialize variable to use in methods
		int sodaCount = 0;
		
		//method that takes in a users integer as count and then adds it to the current amount of sodaCount
		@Override
		public void refill(int count) {
			sodaCount += count;
			
		}

		//method that "dispenses" soda, starts with conditional if and prints out if hte machine is empty
		//if populated it starts a switch statement that dispenses a brand based of of (math.random * 4 and switches based on cases
		@Override
		public String dispense() {
			if (sodaCount == 0)
				return "Machine is empty, no product dispensed";
			sodaCount --;
			
			String typeSoda = "";
			switch ((int) (Math.random() * 4)) {
			case 0: typeSoda = "Pepsi"; break;
			case 1: typeSoda = "Mountain Dew"; break;
			case 2: typeSoda = "Dr. Pepper"; break;
			case 3: typeSoda = "Sierra Mist"; break;
			}
			return typeSoda;
		}

		
		@Override
		public boolean isEmpty() {
			return sodaCount == 0;
			
		}
		
	}

	static class GumballMachine implements VendingMachine{
		int productCount = 0;
		
		@Override
		public void refill(int count) {
			productCount += count;
		}
		
		@Override
		public String dispense() {
			if (productCount == 0)
				return "Machine is empty, no product dispensed";
			productCount --;
			
			String color = "";
			switch ((int) (Math.random() * 4)) {
			case 0: color = "Red"; break;
			case 1: color = "Yellow"; break;
			case 2: color = "Orange"; break;
			case 3: color = "Green"; break;
			}
			return color + " gumball!";
			
		}
		@Override
		public boolean isEmpty() {
			return productCount == 0;
		}

}
	}
