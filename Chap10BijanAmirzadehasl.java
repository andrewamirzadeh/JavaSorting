import java.util.ArrayList;

import static java.lang.System.out;

//Bijan Amirzadehasl 09/06/2021


//Chapter 10 assignment by Bijan Amirzadehasl,

public class Chap10BijanAmirzadehasl {

	public static void main(String[] args) {

//create an arraylist of type Strings
		ArrayList<String> alist = new ArrayList<String>();

//populate arraylist using the .add method
		alist.add("Greg"); // index 0
		alist.add("Kelly"); // index 1
		alist.add("Cristine"); // index 2
		alist.add("Sandy"); // index 3
		alist.add("Sandy");// index 4
		alist.add("Tyler");// index 5
		alist.add("Cristine"); // index 6
		alist.add("Kelly"); // index 7

//first for loop to go over each element(string) from first to last
//brute force
		for (int i = 0; i < alist.size(); i++) {

//for loop where j is always one ahead that checks against each element starting at the index
//of the above for loop
//if the if condition evaluates to true it removes it at index j and is decremented in order
//to adjust for the new size of the list

			for (int j = i + 1; j < alist.size(); j++) {
				if (alist.get(i).equals(alist.get(j))) {
					alist.remove(j);
					j--;
				}
			}
		}

		out.print(alist);

	}

}