import java.util.ArrayList;

//import JavaReviewAssignment.Aircraft;

//Bijan Amirzadehasl 08/31/2021

public class JavaReview {

	
	//create array list to store aircraft objects
	static ArrayList<Aircraft> aircrafts = new ArrayList<>();
	
	public static void main(String[] args) {
		//for instances of the aircraft object to test passenger average method
		Aircraft aircraft1 = new Aircraft("Boeing", "747", 400, 467, 8394);
		Aircraft aircraft2 = new Aircraft("Maverick", "Hawker", 570, 5, 10433);
		Aircraft aircraft3 = new Aircraft("Bombardier", "Renegade", 523, 200, 5909);
		Aircraft aircraft4 = new Aircraft("Cessna", "Falcon", 421, 70, 5999);
		
		//add to the array list
		aircrafts.add(aircraft1);
		aircrafts.add(aircraft2);
		aircrafts.add(aircraft3);
		aircrafts.add(aircraft4);
		
		//call the method to get passenger average
		getPassengerAverage();

	}
	


	private static void getPassengerAverage() {
		
		int avgSum = 0;
		//for loop to loop through the objects in the array list of aircrafts
		for (int i = 0; i < aircrafts.size(); i++)
		{
			//.get(i) positions it in 0,1,2,3,4... and the .getNumPassengers(), gets the number of passengers and add its it to avgSum.
			avgSum += aircrafts.get(i).getNumPassengers();
			
		}
		//equation that divides the total sum of all the passengers for the aircrafts in the array list, divides it by how many were in the arraylist.
		//it then gets cast to a double so we are able to get an accurate number and not integer division.
		double newSum = (double) avgSum /aircrafts.size();
		System.out.printf("The average number of passengers for all the aircrafts is:  %.2f \n", newSum);
	}


//aircraft class have to make static so it's able to be used throughout the public class
	static class Aircraft {

		
		//attributes of the object of the aircraft
		private String manufacturer;
		private String model;
		private int mph;
		private int numPassengers;
		private int range;

		//constructor for Aircraft object
		public Aircraft(String newManufacturer, String newModel, int newMph, int newNumPassengers, int newRange) {

			//setters for the attributes of the aircraft
			//could have set restrictions within the set methods of the class (string cant be null, int values can be zero...) but was not asked to do so in the assignment
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
