package graphtheory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UndirectedConnectivityBFS {

	private Queue<Integer> queue = null;

	public UndirectedConnectivityBFS() {
		queue = new LinkedList<Integer>();
	}

	public void bfs(int adjacency_matrix[][], int source) {
		int no_of_nodes = adjacency_matrix[source].length - 1;
		int[] visited = new int[no_of_nodes + 1];
		int i, element;

		visited[source] = 1;
		queue.add(source);
		while (!queue.isEmpty()) {

			element = queue.remove();
			i = element;
			while (i <= no_of_nodes) {
				if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					queue.add(i);
				}
				i++;
			}

		}

		boolean connected = false;
		for (int vertex = 1; vertex <= no_of_nodes; vertex++) {
			if (visited[vertex] == 1) {
				connected = true;
			} else {
				connected = false;
				break;
			}

		}

		if (connected) {
			System.out.println("The graph is connected");
		} else {
			System.out.println("The graph is disconnected");
		}

	}

	public static void main(String[] args) {
		int no_of_nodes, source;
		Scanner scanner = null;

		try {
			System.out.println("Enter the no of nodes in the graph");
			scanner = new Scanner(System.in);
			no_of_nodes = scanner.nextInt();
			int adjacency_matrix[][] = new int[no_of_nodes + 1][no_of_nodes + 1];
			System.out.println("Enter the adjacency matrix");
			for (int i = 1; i <= no_of_nodes; i++)
				for (int j = 1; j <= no_of_nodes; j++)
					adjacency_matrix[i][j] = scanner.nextInt();

			for (int i = 1; i <= no_of_nodes; i++) {
				for (int j = 1; j <= no_of_nodes; j++) {
					if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0) {
						adjacency_matrix[j][i] = 1;
					}
				}

			}

			System.out.println("Enter the source for the graph");
			source = scanner.nextInt();
			UndirectedConnectivityBFS undirectedConnectivityBFS  = new UndirectedConnectivityBFS();
			undirectedConnectivityBFS.bfs(adjacency_matrix, source);

		} catch (Exception e) {

		}

	}

}
