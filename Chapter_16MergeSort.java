import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Bijan Amirzadehasl
//chapter 16 assignment "Improved Bubble sort"
public class Chapter_16MergeSort {

	public static void main(String[] args) {
		
List<Integer> list = new ArrayList<>();

		
		for (int i = 0; i < 10; i++)
			list.add((int) (Math.random() * 10 + 4));
		
		out.println("Before sorting: " + list);
		
		out.println("After sorting: " + mergeSort(list));
		out.println("Smallest value: " + mergeSort(list).get(0));
		List<String> names = new ArrayList<>();
		//unsorted list
		names.add("Samantha");
		names.add("Josh");
		names.add("Jeremy");
		names.add("Andrew");
		names.add("Maria");
		names.add("Oliver");
		
		out.println("Before sorting: " + names);
		
		out.println("After sorting: " + mergeSort(names));
		out.println("Smallest value: " + mergeSort(names).get(0));
		
		List<Float> floats = new ArrayList<Float>();
		//semi sorted list with largest number set at the first index
		floats.add(3.14f);
		floats.add(3.09f);
		floats.add(3.10f);
		floats.add(3.11f);
		floats.add(3.12f);
		floats.add(3.13f);
		
		out.println("Before sorting: " + floats);
		
		out.println("After sorting: " + mergeSort(floats));
		out.println("Smallest value: " + mergeSort(floats).get(0));
	}
	public static <E extends Comparable<E>> List<E> mergeSort(List<E> list){
		   return mergeSort(list, 0, list.size() - 1);
		}
	
	public static <E extends Comparable<E>> List<E> mergeSort(List<E> list, int start, int end){
		if (end == start - 1)
			return new ArrayList<>();
		
		if (end == start) {
			List<E> result = new ArrayList<>();
			result.add(list.get(start));
			return result;
		}
		
		int mid = (end + start) / 2;
		
		List<E> half1 = mergeSort(list, start, mid);
		
		List<E> half2 = mergeSort(list, mid + 1, end);
		
		return merge(half1, half2);
	}
	
	public static <E extends Comparable<E>> List<E> merge(List<E> half1, List<E> half2){
		List<E> result = new ArrayList<>();
		int index1 = 0;
		int index2 = 0;
		
		while (index1 < half1.size() || index2 < half2.size()) {
			if (index1 == half1.size())
				result.add(half2.get(index2++));
			
			else if (index2 == half2.size())
				result.add(half1.get(index1++));
			
			
			else {
				if (half1.get(index1).compareTo(half2.get(index2)) > 0)
					result.add(half2.get(index2++));
				else
					result.add(half1.get(index1++));
			}
		}
		return result;
	}
}
