import static java.lang.System.out;

import java.util.InputMismatchException;
import java.util.Scanner;
//Bijan Amirzadehasl 09/13/2021
//Soda Machine and gumball machine by Bijan Amirzadehasl
public class Chap11Machine{
	public static void main(String[] args) {
		
		GumballMachine machine = new GumballMachine();
		//When the program starts, create an instance of the second vending machine type
		SodaMachine machine1 = new SodaMachine();
		
		
		Scanner input = new Scanner(System.in);
		int uChoice = 0;
		//allow the user to choose which of the two vending machines 
		
		//try catch to catch any input entered other than 1, 2 or 3
		while(true) {
		try {
			out.print("Enter 1 to use the gumball machine\nEnter 2 to use the soda machine\nEnter 3 to exit!");
			uChoice = input.nextInt();
			input.nextLine();
			if(uChoice < 1 || uChoice > 3)
			{
				out.print("Enter a value between 1 or 3\n");
				continue;
			}
			break;
		} catch (InputMismatchException exception) {
			System.out.print("Enter an integer value!\n");
			input.next();
			continue;
		}
		
		}
		
		
		
			if (uChoice == 1) {
		while (true) {
			out.print("(V)end, (R)efill for Gumball Machine or (E)xit to exit): ");
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
			else
				out.println("Invalid choice!");
										
		}
		}
		else if (uChoice == 2) {
			while (true) {
			out.print("(V)end, (R)efill for Soda Machine or (E)xit to exit ): ");
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
	}
		else if (uChoice == 3) {
			out.println("Thanks for using the program!");
			
		}
		
		
		} 
		
	}

	



interface VendingMachine{
	void refill(int count);
	String dispense();
	boolean isEmpty();
}

//second machine class that implements interface of vending machine
class SodaMachine implements VendingMachine{
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

class GumballMachine implements VendingMachine{
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



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

