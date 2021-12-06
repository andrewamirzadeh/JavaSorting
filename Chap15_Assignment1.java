import static java.lang.System.out;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.NumberFormat;

//tree for a restaurant root = ExecutiveChef is root. Then chef D'cuisines children of chef D'cuisine are sous chefs children of sous chef are line cooks
//children of line cooks are prep chefs and dishwasher


//Bijan Amirzadehasl 10/25/2021
public class Chap15_Assignment1 {

	public static void main(String[] args) {
		
		//create kitchen employee objects
		KitchenEmployee dishwasher1 = new KitchenEmployee("Ben Affleck", 18000, false);
		KitchenEmployee dishwasher2 = new KitchenEmployee("Matt Damon", 22000, false);
		KitchenEmployee lineCook1 = new KitchenEmployee("Ann Burrel", 35000, false, dishwasher1, dishwasher2);
		KitchenEmployee lineCook2 = new KitchenEmployee("Michael Simon", 35000, false);
		KitchenEmployee lineCook3 = new KitchenEmployee("Chad Mendez", 35000, false);
		KitchenEmployee lineCook4 = new KitchenEmployee("Jaco Pastorius", 35000, false);
		KitchenEmployee lineCook5 = new KitchenEmployee("Ann Burrel", 35000, false);
		KitchenEmployee lineCook6 = new KitchenEmployee("Michael Simon", 35000, false);
		KitchenEmployee lineCook7 = new KitchenEmployee("Chad Mendez", 35000, false);
		KitchenEmployee lineCook8 = new KitchenEmployee("Jaco Pastorius", 35000, false);
		KitchenEmployee sousChef1 = new KitchenEmployee("Guy Fieri", 46000, true, lineCook1, lineCook2, lineCook3, lineCook4);
		KitchenEmployee sousChef2 = new KitchenEmployee("Ina Garten", 35000, true, lineCook5, lineCook6);
		KitchenEmployee sousChef3 = new KitchenEmployee("Bobby Flay", 41000, false, lineCook7, lineCook8);
		KitchenEmployee chefDCuisine2 = new KitchenEmployee("Giada De Laurentiis", 55000, true);
		KitchenEmployee chefDCuisine1 = new KitchenEmployee("Gordon Ramsay", 52000, true, sousChef1, sousChef2, sousChef3);
		KitchenEmployee chefDCuisine3 = new KitchenEmployee("Ina Garten", 52000, true);	
		KitchenEmployee executiveChef = new KitchenEmployee("Anthony Bourdain", 185000, true, chefDCuisine1, chefDCuisine2, chefDCuisine3);
		
		//number formater instantiation
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		
		//method calls
		printEmployees(executiveChef);
		out.println("The number of employees that have health insurance is: " + numberThatHasHealthInsurance(executiveChef));
		out.println("The number of employees is: " + totalEmployees(executiveChef));
		out.println("The total salary for the kitchen is: " + fmt.format(totalSalary(executiveChef)));
		out.println("If you fired the number of employees that have health insurance you would have " + fireInsuredEmployees(executiveChef) + " employees left.");
		out.println("You would save " + fmt.format(moneyLeft(executiveChef)) + " if you fired current employees who have health insurance.");
		
		
	}
	
	private static double moneyLeft(KitchenEmployee executiveChef) {
		List<KitchenEmployee> stack = new ArrayList<>();
		stack.add(executiveChef);
		double moneyLeftAfter = 0;
		
		while(!stack.isEmpty()) {
			KitchenEmployee currentEmp = stack.remove(stack.size() - 1);
			
			if (currentEmp.hasHealthInsurance) {
				moneyLeftAfter += currentEmp.salary;
			}
			
			for (KitchenEmployee child : currentEmp.children)
				stack.add(child);
		}
		
		
		return moneyLeftAfter;
	}
	
	private static int fireInsuredEmployees(KitchenEmployee executiveChef) {
		List<KitchenEmployee> stack = new ArrayList<>();
		stack.add(executiveChef);
		int fireInsured = 0;
		
		while (!stack.isEmpty()) {
			KitchenEmployee currentEmp = stack.remove(stack.size() - 1);
			
			if (!currentEmp.hasHealthInsurance) {
				fireInsured += 1;
			}
			
			for (KitchenEmployee child : currentEmp.children)
				stack.add(child);
		}
		
		return fireInsured;
	}
	
	private static int totalEmployees(KitchenEmployee executiveChef) {
		List<KitchenEmployee> stack = new ArrayList<>();
		stack.add(executiveChef);
		int totalEmployees = 0;
		
		while(!stack.isEmpty()) {
			KitchenEmployee currentEmp = stack.remove(stack.size() - 1);
			
			totalEmployees += 1;
			
			for (KitchenEmployee child : currentEmp.children)
				stack.add(child);
		}
		
		return totalEmployees;
	}
	
	private static double totalSalary(KitchenEmployee executiveChef) {
		List<KitchenEmployee> stack = new ArrayList<>();
		stack.add(executiveChef);
		double totalSalary = 0;
		
		while(!stack.isEmpty()) {
			
			KitchenEmployee currentEmp = stack.remove(stack.size() - 1);
			
			totalSalary += currentEmp.salary;
			
			for (KitchenEmployee child : currentEmp.children)
				stack.add(child);
		}
		
		
		return totalSalary;
	}
	
	private static int numberThatHasHealthInsurance(KitchenEmployee executiveChef) {
		List<KitchenEmployee> stack = new ArrayList<>();
		stack.add(executiveChef);
		int numInsurance = 0;
		
			while (!stack.isEmpty()) {
			
			KitchenEmployee currentEmp = stack.remove(stack.size() - 1);
			
			if (currentEmp.hasHealthInsurance)
				numInsurance += 1;
			
			for (KitchenEmployee child : currentEmp.children)
				stack.add(child);
		}
		
		return numInsurance;
		
	}
	
	private static void printEmployees(KitchenEmployee executiveChef) {
		Map<KitchenEmployee, Integer> kitchLevels = new HashMap<>();
		List<KitchenEmployee> stack = new ArrayList<>();
		
		stack.add(executiveChef);
		kitchLevels.put(executiveChef, 0);
		
		while (!stack.isEmpty()) {
			
			KitchenEmployee currentEmployee = stack.remove(stack.size() - 1);
			
			int currentKitchenLevel = kitchLevels.get(currentEmployee);
			for (int i = 0; i < currentKitchenLevel; i++)
				out.print(" ");
			out.println(currentEmployee.name);
			
			
			for(KitchenEmployee child : currentEmployee.children) {
				stack.add(child);
				kitchLevels.put(child, currentKitchenLevel + 1);
			}
		}
		
	}

}

class KitchenEmployee {
	String name;
	int salary;
	boolean hasHealthInsurance;
	List<KitchenEmployee> children = new ArrayList<>();
	
	public KitchenEmployee(String name, int salary, boolean hasHealthInsurance, KitchenEmployee...kitchenEmployees) {
		super();
		this.name = name;
		this.salary = salary;
		this.hasHealthInsurance = hasHealthInsurance;
		
		for (KitchenEmployee child : kitchenEmployees)
			this.children.add(child);
	}
	
	
}

//class DepartmentNode {
//	String name;
//	int employees;
//	int budget;
//	List<DepartmentNode> children = new ArrayList<>();
//
//	public DepartmentNode(String name, int employees, int budget, DepartmentNode...departmentNodes) {
//		super();
//		this.name = name;
//		this.employees = employees;
//		this.budget = budget;
//		for (DepartmentNode child : departmentNodes)
//			this.children.add(child);
//	}
//
//}
