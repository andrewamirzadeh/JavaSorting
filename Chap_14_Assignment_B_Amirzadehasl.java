import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Bijan Amirzadehasl 10/11/2021
public class Chap_14_Assignment_B_Amirzadehasl {

	public static void main(String[] args) {
		List<Integer>  list = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			list.add((int) (Math.random() * 10) + 1);
		
		Collections.sort(list);
		
		out.println("The list is : " + list);
		
		int index = binarySearch(list, 10);
		if (index >= 0)
			out.println("Binary search: the number 10 was found at " + index);
		else
			out.println("Binary search: the number 10 was not found");
		
		List<String> names = new ArrayList<>();
		names.add("Sam");
		names.add("Josh");
		names.add("Sara");
		names.add("Robert");
		names.add("Spike");
		names.add("Grace");
		names.add("Andrew");
		names.add("Maria");
		names.add("Steven");
		names.add("Trisha");
		
		Collections.sort(names);
		
		out.println("The names are " + names);
		
		//test here
		index = binarySearch(names, "Spike");
		if (index >= 0)
			out.println("Binary search: The name you entered was found at index " + index);
		else
			out.println("Binary search: The name you entered was not found");
		
		
		
	}
	
	public static <E> int linearSearch(List<E> list, E data) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).equals(data))
				return i;
		return -1;
	}
	private static <E extends Comparable<E>> int binarySearch(List<E> list, E data) {
		//upper is 7
		int upper = list.size() - 1;
		int lower = 0;
		//while 7 is greater than 0
		while (upper >= lower) {
			//mid becomes 3 first loop
			int mid = (lower + upper) / 2 ;
			//the .compareto will return 0 if the objects are of equal value
			//< 0 if the string is lexicographically less than the other string 
			//> 0 if the string is lexicographically greater than the other string (more characters)
			if(data.compareTo(list.get(mid)) < 0)
				upper = mid - 1;
			else if (data.compareTo(list.get(mid)) == 0)
				return mid;
			else
				lower = mid + 1;
		}
		return -lower - 1;
		
		/*
		while (upper != lower) {
			
		
				
			int M = (upper + lower) /2;
			
			E midVal = list.get(M);
			
			int compareResult = midVal.compareTo(data);
			
			if (compareResult == 0)
				return compareResult;
			
			
			if (compareResult > 0)
				upper = M;
			else
				lower = M;
				
			if (upper == lower + 1) {
				if (list.get(upper).equals(data))
					return list.indexOf(upper);
				if (list.get(lower).equals(data))
					return list.indexOf(lower);
				break;
			}
		}
		if (list.get(upper).compareTo(data) != 0)
			return -1;
		return -1;
		*/
	}

}
