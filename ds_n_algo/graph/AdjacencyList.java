package ds_n_algo.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList implements Graph {
	
	private int vCount;
	public List<List<Integer>> adjLists;

	public static void main(String[] str) {
		
		Graph graph = new AdjacencyList(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 0);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		
		graph.print();
		
		graph.removeEdge(0, 1);
		System.out.println();
		graph.print();
	}
	
	
	public AdjacencyList(int vCount) {
		
		this.vCount = vCount;
		adjLists = new ArrayList<>(vCount);
		
		for(int i=0; i<this.vCount; i++)
			adjLists.add(new ArrayList<Integer>());
	}
	
	@Override
	public void addEdge(int i, int j) {
		
		List<Integer> list1 = adjLists.get(i);
		list1.add(j);

		List<Integer> list2 = adjLists.get(j);
		list2.add(i);
	}
	

	@Override
	public void removeEdge(int i, int j) {
		List<Integer> list1 = adjLists.get(i);
		list1.remove(list1.indexOf(j));

		List<Integer> list2 = adjLists.get(j);
		list2.remove(list2.indexOf(i));
	}

	@Override
	public void print() {
		for(int i=0; i<adjLists.size(); i++) {
			System.out.print(i);
			for(int j : adjLists.get(i)) {
				System.out.print("->"+j);
			}
			System.out.println();
		}
	}
	
	@Override
	public void addVertex(char label) {
		//TODO
	}
	
	public List<Integer> getNeighbours(int i) {
		return adjLists.get(i);
	}

	@Override
	public void dfs() {
		// TODO Auto-generated method stub
	}

	@Override
	public void bfs() {
		// TODO Auto-generated method stub
		
	}
	
}
