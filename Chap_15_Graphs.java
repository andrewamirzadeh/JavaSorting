import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

//Bijan Amirzadehasl 11/08/2021
//chapter 15 graphs assignment
class GraphNode {
	int id;
	List<GraphNode> children = new ArrayList<>();
	boolean isExit = false;

	public GraphNode(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ((Integer) id).toString();
	}

}

public class Chap_15_Graphs {

	public static void main(String[] args) {
		List<GraphNode> nodes = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			nodes.add(new GraphNode(i + 1));
		}
	
		//modify the maze so that it has multiple exits.
		nodes.get(17).isExit = true;
		nodes.get(15).isExit = true;
		nodes.get(3).isExit = true;
	
		
		connect(nodes, 1, 2);
		connect(nodes, 2, 3);
		connect(nodes, 3, 4);
		connect(nodes, 4, 5);
		connect(nodes, 1, 6);
		connect(nodes, 3, 8);
		connect(nodes, 4, 9);
		connect(nodes, 7, 8);
		connect(nodes, 6, 11);
		connect(nodes, 7, 12);
		connect(nodes, 9, 14);
		connect(nodes, 10, 15);
		connect(nodes, 11, 12);
		connect(nodes, 14, 15);
		connect(nodes, 13, 18);
		connect(nodes, 15, 20);
		connect(nodes, 16, 17);
		connect(nodes, 17, 18);
		connect(nodes, 18, 19);
		connect(nodes, 19, 20);

		List<GraphNode> visited = new ArrayList<>();
		List<GraphNode> path = new ArrayList<>();
		//Empty list of integers for multiple paths
		List<Integer> pathList = new ArrayList<Integer>();
		
		
		solve(nodes.get(2), visited, path, pathList);
//		if (result) {
//			out.println("Exit has been found!");
//			for (Integer pathNode : pathList)
//				out.print(pathNode + " ");
//					
//		}
//
//		else
//			out.println("Exit has not been found!");
		
//		out.print(pathList);

	}

	private static boolean solve(GraphNode node, List<GraphNode> visited, List<GraphNode> path, List<Integer> pathList) {

//		out.print(node.id + " ");
		visited.add(node);
		path.add(node);
		
		if (node.isExit) {
			out.print("Found Solution: ");
			for (GraphNode pathNode : path) 
				pathList.add(pathNode.id);
				out.println(pathList);
		
		}

		for (GraphNode child : node.children)
			if (!visited.contains(child))
				if (solve(child, visited, path, pathList))
					return true;
		//clear the pathList list to print out the seperate exit paths
		//if you do not do this, it will join all paths and print out into one array
		pathList.clear();
		path.remove(path.size() - 1);
		return false;

	}

	private static void connect(List<GraphNode> nodes, int nodeId1, int nodeId2) {
		nodes.get(nodeId1 - 1).children.add(nodes.get(nodeId2 - 1));
		nodes.get(nodeId2 - 1).children.add(nodes.get(nodeId1 - 1));
	}

}
