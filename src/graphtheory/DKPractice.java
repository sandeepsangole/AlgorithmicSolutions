package graphtheory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DKPractice {

	private int distances[];
	private Set<Integer> visited;
	private Set<Integer> unVisited;
	private int no_of_nodes;
	private int adjacencyMatrixGlobal[][];

	public DKPractice(int no_of_nodes) {
		this.distances = new int[no_of_nodes + 1];
		this.visited = new HashSet<Integer>();
		this.unVisited = new HashSet<Integer>();
		this.no_of_nodes = no_of_nodes;
		this.adjacencyMatrixGlobal = new int[no_of_nodes + 1][no_of_nodes + 1];

	}
	
	public void DKPractice(int adjacency_matrix[][] , int source)
	{
		//setting matrix from input
		for(int i = 1;i<=no_of_nodes;i++)
		{
			for(int j =1;j<=no_of_nodes;j++)
			{
				adjacencyMatrixGlobal[i][j] = adjacency_matrix[i][j];
			}
		}
		
		//set ditance of eash node to MAX/infinity
		for(int i = 1;i<=distances.length;i++)
		{
			distances[i]=Integer.MAX_VALUE;
		}
		
		//setting source distance to zero
		distances[source] = 0;
		//setting souce as unvisited node to start process
		unVisited.add(source);
		
		
		while(!unVisited.isEmpty())
		{
		
			int node = getNodewithMiniumDistanceFromUnvisited();
			unVisited.remove(node);
			visited.add(node);
			evaluateNode(node);
			
		}
		
		
		
	}
	
	private int getNodewithMiniumDistanceFromUnvisited()
	{
		int node = 0;
		Iterator it = unVisited.iterator();
		int targetNode = (int) it.next();
		
		int min = 0;
		min = distances[targetNode];
		
		for(int i =1;i<=distances.length;i++){
			if(unVisited.contains(i))
			{
				if(distances[i] <= min)
				{
					min = distances[i];
					node = i;
					
				}
			}
		}
		 
		return node;
	}
	
	private void evaluateNode(int targetNode)
	{
		int edgeDistance = -1;
		int newDistance = -1;
		
		for(int i =1;i<=no_of_nodes;i++)
		{
			if(!visited.contains(i)) {
				if(adjacencyMatrixGlobal[targetNode][i] != Integer.MAX_VALUE){
					
					edgeDistance = adjacencyMatrixGlobal[targetNode][i];
					newDistance = distances[targetNode]+edgeDistance;
					if(newDistance <= distances[i]){
						distances[i] = newDistance;
						unVisited.add(i);
					}
				}
			}
				
		}
		
	}
	
	
	public static void main(String[] args) {

		int adjacency_matrix[][];
		int no_of_nodes;
		int source, destination;

		Scanner scanner = new Scanner(System.in);
		try {
				System.out.println("Enter number of Vertices : ");
				no_of_nodes = scanner.nextInt();
				adjacency_matrix = new int[no_of_nodes + 1][no_of_nodes + 1];
				
				 System.out.println("Enter the Weighted Matrix for the graph");
		          
				 
				for (int i = 1; i <= no_of_nodes; i++) {
					for (int j = 1; j <= no_of_nodes; j++) {
						adjacency_matrix[i][j] = scanner.nextInt();
						if (i == j) {
							adjacency_matrix[i][j] = 0;
							continue;
						}
		
						if (adjacency_matrix[i][j] == 0) {
							adjacency_matrix[i][j] = Integer.MAX_VALUE;
						}
					}
				}
		
				System.out.println("Enter Source ");
				source = scanner.nextInt();
				
				System.out.println("Enter Desination ");
				destination = scanner.nextInt();
				
				DKPractice dijkstraAlgo = new DKPractice(no_of_nodes);
				dijkstraAlgo.DKPractice(adjacency_matrix, source);
				
				System.out.println("The Shorted Path from " + source + " to " + destination + " is: ");
		        for (int i = 1; i <= dijkstraAlgo.distances.length - 1; i++)
		        {
		            if (i == destination)
		                System.out.println(source + " to " + i + " is "
		                        + dijkstraAlgo.distances[i]);
		        }
		}
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }

		scanner.close();
	}
}
