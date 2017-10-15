package graphtheory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DijkstraAlgo {

	private int distanceLst[];
	private Set<Integer> settled;
	private Set<Integer> unsettled;
	private int no_of_nodes;
	private int adjacencyMatrixGlobal[][];

	public DijkstraAlgo(int no_of_nodes) {
		this.distanceLst = new int[no_of_nodes + 1];
		this.settled = new HashSet<Integer>();
		this.unsettled = new HashSet<Integer>();
		this.no_of_nodes = no_of_nodes;
		this.adjacencyMatrixGlobal = new int[no_of_nodes + 1][no_of_nodes + 1];

	}

	public void DijkstraAlgorithmImplementation(int adjacency_matrix[][], int source) {
		int evalutionNode;
		for (int i = 1; i <= no_of_nodes; i++) {
			for (int j = 1; j <= no_of_nodes; j++) {
				adjacencyMatrixGlobal[i][j] = adjacency_matrix[i][j];
			}
		}

		for (int i = 1; i <= no_of_nodes; i++) {
			distanceLst[i] = Integer.MAX_VALUE;
		}

		unsettled.add(source);

		distanceLst[source] = 0;
		while (!unsettled.isEmpty()) {
			evalutionNode = getNodeWithMiniumDistanceFromUnsettled();
			unsettled.remove(evalutionNode);
			settled.add(evalutionNode);

			evaluateNeighbours(evalutionNode);

		}
	}

	private int getNodeWithMiniumDistanceFromUnsettled() {
		int min;
		int node = 0;
		Iterator<Integer> iterator = unsettled.iterator();
		node = iterator.next();
		min = distanceLst[node];

		for (int i = 1; i <= distanceLst.length; i++) {
			if (unsettled.contains(i))
            {
				if (distanceLst[i] <= min) {
					min = distanceLst[i];
					node = i;
	
				}
            }
		}
		System.out.println("Node with minimum distance  :"+node);
		return node;
	}

	private void evaluateNeighbours(int evaluationNode) {
		int edgeDistance = -1;
		int newDistance = -1;
		System.out.println("evaluationNode :" +evaluationNode);
		for (int destinationNode = 1; destinationNode <= no_of_nodes; destinationNode++) {
			if (!settled.contains(destinationNode)) {
				if (adjacencyMatrixGlobal[evaluationNode][destinationNode] != Integer.MAX_VALUE) {
					
					edgeDistance = adjacencyMatrixGlobal[evaluationNode][destinationNode];
					newDistance = distanceLst[evaluationNode] + edgeDistance;
					
					System.out.println("newDistance :" +newDistance);
					if (newDistance < distanceLst[destinationNode]) {
						distanceLst[destinationNode] = newDistance;
						for(int i=1;i< distanceLst.length;i++)
						{
							System.out.print(distanceLst[i]+" ,");
						}
					}
					unsettled.add(destinationNode);
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
				
				DijkstraAlgo dijkstraAlgo = new DijkstraAlgo(no_of_nodes);
				dijkstraAlgo.DijkstraAlgorithmImplementation(adjacency_matrix, source);
				
				System.out.println("The Shorted Path from " + source + " to " + destination + " is: ");
		        for (int i = 1; i <= dijkstraAlgo.distanceLst.length - 1; i++)
		        {
		            if (i == destination)
		                System.out.println(source + " to " + i + " is "
		                        + dijkstraAlgo.distanceLst[i]);
		        }
		}
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }

		scanner.close();
	}
}
	

