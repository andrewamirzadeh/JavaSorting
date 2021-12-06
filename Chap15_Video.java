import static java.lang.System.out;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


//Bijan Amirzadehasl 11/1/2021

public class Chap15_Video {

	public static void main(String[] args) {
		DepartmentNode node1 = new DepartmentNode("Bonneville Power Administration", 21, 150000);
		DepartmentNode node2 = new DepartmentNode("Southeastern Power Administration", 11, 190000);
		DepartmentNode node3 = new DepartmentNode("Southwestern Power Administration", 15, 110000);
		DepartmentNode node4 = new DepartmentNode("Western Area Power Administration", 14, 120000);
		DepartmentNode node5 = new DepartmentNode("Assistant Secretary for Electricity", 12, 191000, node1, node2, node3, node4);
		DepartmentNode node6 = new DepartmentNode("Assistant Secretary for Fossil Energy", 10, 100000);
		DepartmentNode node7 = new DepartmentNode("Assistant Secretary for Nuclear Energy", 10, 100000);
		DepartmentNode node8 = new DepartmentNode("Assistant Secretary for Energy Efficiency and Renewable Energy", 10, 100000);
		DepartmentNode node9 = new DepartmentNode("Office of the Undersecretary of Energy", 10, 100000, node5, node6, node7, node8);
		DepartmentNode node10 = new DepartmentNode("Office of Science", 15, 110000);
		DepartmentNode node11 = new DepartmentNode("Office of Artificial Intelligence and Technology", 14, 120000);
		DepartmentNode node12 = new DepartmentNode("Office of the Undersecretary for Science", 12, 191000, node10, node11);
		DepartmentNode node13 = new DepartmentNode("Chief of Staff", 1, 50000);
		DepartmentNode node14 = new DepartmentNode("Ombudsman", 1, 50000);
		
		DepartmentNode root = new DepartmentNode("Office of the Secretary", 12, 191000, node12, node9, node13, node14);
//		printTreeIterative(root);
//		out.println("Total budget is " + totalBudget(root));
		
		root.printSubtree(0);
		out.println("Total budget is " + root.totalBudget());
		out.println("The tree has " + root.nodeCount() + " nodes.");
		out.println("The department has " + root.totalEmployees() + " employees.");
		//prints it out with two decimal places
		out.println("The average number of employees is: " + String.format("%.2f", root.averageEmployees()));
	}
	
	private static int totalBudget(DepartmentNode root) {
		List<DepartmentNode> stack = new ArrayList<>();
		stack.add(root);
		int totalBudget = 0;
		
		while (!stack.isEmpty()) {
			
			DepartmentNode currentNode = stack.remove(stack.size() - 1);
			
			totalBudget += currentNode.budget;
			
			for (DepartmentNode child : currentNode.children)
				stack.add(child);
		}
		return totalBudget;
	}
	
	private static void printTreeIterative(DepartmentNode root) {
		Map<DepartmentNode, Integer> nodeLevelMap = new HashMap<>();
		List<DepartmentNode> stack = new ArrayList<>();
		
		stack.add(root);
		nodeLevelMap.put(root, 0);
		
		while (!stack.isEmpty()) {
			
			DepartmentNode currentNode = stack.remove(stack.size() - 1);
			
			int currentNodeLevel = nodeLevelMap.get(currentNode);
			for (int i = 0; i < currentNodeLevel; i++)
				out.print(" ");
			out.println(currentNode.name);
			
			
			for(DepartmentNode child : currentNode.children) {
				stack.add(child);
				nodeLevelMap.put(child, currentNodeLevel + 1);
			}
		}
		
	}
	
	
}
	class DepartmentNode {
		String name;
		int employees;
		int budget;
		List<DepartmentNode> children = new ArrayList<>();

		public DepartmentNode(String name, int employees, int budget, DepartmentNode...departmentNodes) {
			super();
			this.name = name;
			this.employees = employees;
			this.budget = budget;
			for (DepartmentNode child : departmentNodes)
				this.children.add(child);
		}

		
		public void printSubtree(int level) {
			for (int i = 0; i < level; i++)
				out.print(" ");
			out.println(name);
			
			for(DepartmentNode child : children)
				child.printSubtree(level + 1);
		}
		
		public int totalBudget() {
			int answer = budget;
			for(DepartmentNode child : children)
				answer += child.totalBudget();
			return answer;
		}
		//counts the total number of nodes
		public int nodeCount() {
			int answer = 1;
			for(DepartmentNode child : children)
				answer += child.nodeCount();
			return answer;
		}
		//adds the total amount of employees
		public int totalEmployees() {
			int answer = employees;
			for(DepartmentNode child : children)
				answer += child.totalEmployees();
			return answer;
		}
		//divides the two recursive results
		public double averageEmployees() {
			
			return (double) totalEmployees() / nodeCount();
		}
	}


