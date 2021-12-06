package seminolestate.edu;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
//Bijan Amirzadehasl 10/18/2021


public class Chap14_MapHash_Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Different event objects with the same data should be considered the same by HashMap
		Event event1 = new Event(1987, 3, 4);
		Event event2 = new Event(1987, 3, 4);
		Event event3 = new Event(2001, 4, 5);
		System.out.println("Event1's hash code is: " + event1.hashCode());
		System.out.println("Event2's hash code is: " + event2.hashCode());
		System.out.println("Event3's hash code is: " + event3.hashCode());
		
		//Test your Event class by making sure it works properly with HashMap.
		Map<Event, Float> destruction = new HashMap<>();
		destruction.put(event1, (float) (event1.year + event1.day + event1.month));
		destruction.put(event2, (float) (event2.year + event2.day + event2.month));
		destruction.put(event3, (float) (event3.year + event3.day + event3.month));
		
		for (Entry<Event, Float> entry : destruction.entrySet())
			System.out.println(entry.getKey() + " (" + entry.getValue() + " war)");
	}

	//create a class named Event that represents a calendar event.
	
static class Event{
		//it should have data fields for the event name and the event's date
		//(integers for year, month and day)
		int year;
		int month;
		int day;
		
		
		//it should have a constructor that constructs a date
		//with the specified name, year, month and day.
		public Event(int year, int month, int day) {
			super();
			this.year = year;
			this.month = month;
			this.day = day;
		}
		
		/*Override the equals method
		@Override
		public boolean equals(Object object2) {
			
			if(object2 == null || object2.getClass() != getClass())
				return false;
			
			Event event2 = (Event) object2;
			
			if (year != event2.year)
				return false;
			
			if (month != event2.month)
				return false;
			
			if (day != event2.day)
				return false;
			
			
			return true;
		}
		*/
		/*override the hashcode method
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + year;
			result = prime * result + month;
			result = prime * result + day;
			return result;
		}
		*/
		@Override
		public String toString() {
			return "Event [year= " + year + ", month = " + month + " and day = " + day;
		}

		@Override
		public int hashCode() {
			return Objects.hash(day, month, year);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Event other = (Event) obj;
			return day == other.day && month == other.month && year == other.year;
		}
		
	}
	
}
