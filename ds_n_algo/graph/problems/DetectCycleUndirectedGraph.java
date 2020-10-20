package ds_n_algo.graph.problems;

import java.util.List;

import ds_n_algo.graph.AdjacencyList;
import ds_n_algo.graph.Graph;

/**
 * @since 08/10/2020

 * 0---------- 1
 * 		       |
 *             |
 *        4    |
 *      /   \  |
 *     /     \ |
 *    3--------2-----5
 */

public class DetectCycleUndirectedGraph {
	
	private static AdjacencyList undirectedGraph;
	private static boolean[] isVisited;
	
	public static void main(String[] str) {
		final int noOfVertices = 6;
		isVisited = new boolean[noOfVertices];
		
		undirectedGraph = new AdjacencyList(6);
		
		undirectedGraph.addEdge(0, 1);
		undirectedGraph.addEdge(1, 2);
		undirectedGraph.addEdge(2, 3);
		undirectedGraph.addEdge(2, 4);
		undirectedGraph.addEdge(2, 5);
		//undirectedGraph.addEdge(3, 4);
		
		undirectedGraph.print();
		
		System.out.println("Graph has Cycle - " + hasCycle() );
	}

	
	private static boolean hasCycle() {
		
		for(int i=0; i<undirectedGraph.adjLists.size(); i++) {
			if(!isVisited[i]) {
				boolean hasCycle = dfs(i, -1);
				if(hasCycle) {
					return true;
				}
			}
		}

		return false;
	}
	
	private static boolean dfs(int node, int parent) {
		
		isVisited[node] = true;
		List<Integer> neighbours = undirectedGraph.adjLists.get(node);
		for(int neighbour : neighbours) {
			
			if(!isVisited[neighbour])
				return dfs(neighbour, node);
			else if(neighbour != parent && parent != -1)//visited && !=parentNode  
				return true;
		}
		
		return false;
		
	}
	
}
