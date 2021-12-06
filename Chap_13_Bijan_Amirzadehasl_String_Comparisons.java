package seminolestate.edu.String_comparisons;

//Bijan Amirzadehasl 09/27/2021

import java.util.Scanner;
//imports


public class Chap_13_Bijan_Amirzadehasl_String_Comparisons {

	//constants used for menu control
	private static final int COMP_STRINGS = 1;
	private static final int EXIT = 2;

	//scanner
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		//intialize response
		int userResponse = 0;
		
		do {
			
			//basic do while that continues the menu until the user enters 2
			userResponse = menu();
			switch (userResponse) {
			case COMP_STRINGS:
				
				System.out.print("Enter the first word that you will check against the second word: ");
				String x = input.nextLine();
				System.out.print("Enter the second word: ");
				String y = input.nextLine();
				
				//intialize variable with a call to the compareSubStrings method
				int res = compareSubStrings(x, y);
				//selection statement that controls the output of the result to the user
				if (res == -1) {
					System.out.print("The first word is not a substring of the second word.\nThe Runtime complexity is O(" + x.length() * y.length() + ")");
				}
				else {
					System.out.println("The first word is a substring of the second word.\nThe Runtime complexity is O(" + x.length() * y.length() + ")");
				}
				
				break;
			case EXIT:
				System.out.print("Thanks for using the program!");
				
		
			}
		}while (userResponse != EXIT);
		
		
		
		
	}
	
	//method to determine if the first string is a substring of the second string
	//takes in two string parameters
	//I believe the Big O complexity is O(n) or O(n^2) because of the nested for loops
	static int compareSubStrings(String s1, String s2)
	    {
	    
		//outer for loop is controlled by the value of s2 - s1.
		//Example say we have s1 = apple and s2 = Snapple s2 - s1's lengths would be 2 (7 -5) 
	        for (int i = 0; i <= s2.length() - s1.length(); i++) {
	            int j;
	            	
	         //inner for loop that's controlled by s1's length.
	           // apple is 5
	            for (j = 0; j < s1.length(); j++) 
	                if (s2.charAt(i + j)!= s1.charAt(j))
	                    break;
	            
	            //the for loop is terminated by the sum of j
	            if (j == s1.length())
	                return i;
	        }
	        //return -1 to indicate an unsucessful iteration
	        return -1;
	    }
	
	private static int menu() {
		int userResponse = 0;
		
		do {
			try {
				System.out.println("What would you like to do?\n(1). Run the compare strings method\n(2). Exit");
				userResponse = input.nextInt();
				input.nextLine();
				if (userResponse < 1 || userResponse > 3 ) {
					System.out.println("Enter a value of 1 to 3!");
				}
				
				
			} catch (Exception E) {
				System.out.println("Please enter a valid value!");
			} 
			
		} while (userResponse < 1 || userResponse > 2);
		
		return userResponse;
	}
	
	

}
