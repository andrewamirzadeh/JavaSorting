import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class CHAP14_BIJAN_AMIRZADEHASL {

	public static void main(String[] args) throws FileNotFoundException {
		
		List<Asteroid> asteroids = new ArrayList<>();
		Map<String, Asteroid> asteroidMap = new HashMap<>();
		
		
		
		
		File file = new File("src/lc_summary_pub.txt");
		Scanner input = new Scanner(file);
		
		for (int i = 0; i < 5; i++)
			input.nextLine();
		
		while (input.hasNext()) {
			String line = input.nextLine();
			
			int number = Integer.parseInt(line.substring(0, 8).trim());
			String name = line.substring(10, 40).trim();
			float diameter = readFloat(line, 89, 96);
			float reflectivity = readFloat(line, 130, 136);
			float period = readFloat(line, 139, 149);
			Asteroid asteroid = new Asteroid (number, name, diameter, reflectivity, period);
			asteroids.add(asteroid);
			
			asteroidMap.put(asteroid.name, asteroid);
			
		}
		
		out.println("Read " + asteroids.size() + " asteroids...");
		
		Collections.sort(asteroids);
		
//		out.println("The first asteroid is: " + asteroids.get(0));
	//	out.println("The last asteroid is: " + asteroids.get(asteroids.size() - 1));
		
		input.close();
		
		//linear search
		Asteroid asteroid = null;
		long start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			asteroid = linearSearch(asteroids, "Pluto");
		}
		long end = System.currentTimeMillis();
		out.println("Linear search: Pluto's record is " + asteroid);
		out.println("Linear search: Time to find Pluto: " + (end- start) + " milliseconds");
		
		//binary search
		asteroid = null;
		start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			asteroid = binarySearch(asteroids, "Pluto");
		}
		end = System.currentTimeMillis();
		out.println("Binary search: Pluto's record is " + asteroid);
		out.println("Binary search: Time to find Pluto: " + (end- start) + " milliseconds");
		
		//map search
		asteroid = null;
		start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
		asteroid = asteroidMap.get("Pluto");
				}
		end = System.currentTimeMillis();
		out.println("Map search: Pluto's record is " + asteroid);
		out.println("Map search: Time to find Pluto: " + (end- start) + " milliseconds");
		
	}
	private static Asteroid linearSearch(List<Asteroid> asteroids, String asteroidName) {
		for (int i = 0; i < asteroids.size(); i++)
			if (asteroids.get(i).name.equals(asteroidName))
				return asteroids.get(i);
		return null;
	}
	
	private static Asteroid binarySearch(List<Asteroid> asteroids, String asteroidName) {
		//int index = Collections.binarySearch(asteroids, new Asteroid(0, asteroidName, 0, 0, 0));
		//if (index == -1)
			//return null;
		//return asteroids.get(index);
		
		int upper = asteroids.size() - 1;
		int lower = 0;
		
		while (upper != lower) {
			
		
				
			int M = (upper + lower) /2;
			
			Asteroid midAsteroid = asteroids.get(M);
			int compareResult = midAsteroid.name.compareToIgnoreCase(asteroidName);
			if (compareResult == 0)
				return midAsteroid;
			
			
			if (compareResult > 0)
				upper = M;
			else
				lower = M;
				
			if (upper == lower + 1) {
				if (asteroids.get(upper).name.equalsIgnoreCase(asteroidName))
					return asteroids.get(upper);
				if (asteroids.get(lower).name.equalsIgnoreCase(asteroidName))
					return asteroids.get(lower);
				break;
			}
		}
		if (asteroids.get(upper).name.compareToIgnoreCase(asteroidName) != 0)
			return null;
		return null;
	}
	

private static float readFloat(String line, int startIndex, int endIndex) {
	float num = 0;
	String str = line.substring(startIndex, endIndex).trim();
	if (!str.isEmpty()) {
		try {
			num = Float.parseFloat(str);
		}
		catch (Exception ex) {
			out.println("Error");
		}
	}
		
		
	return num;
	
	}
}

class Asteroid implements Comparable<Asteroid>{
	int number;
	String name;
	float diameter;
	float reflectivity;
	float period;
	
	public Asteroid(int number, String name, float diameter, float reflectivity, float period) {
		super();
		this.number = number;
		this.name = name;
		this.diameter = diameter;
		this.reflectivity = reflectivity;
		this.period = period;
	}

	@Override
	public String toString() {
		return name + "[ID=" + number + "), diameter=" + diameter + ", diameter: " + diameter + " km, reflectivity=" + reflectivity
				+ ", period=" + period + " hours]";
	}
	@Override
	public int compareTo(Asteroid other) {
		return name.compareToIgnoreCase(other.name);
	}
	
}