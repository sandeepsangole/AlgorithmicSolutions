package important.specials;


import java.util.*;

class GraphSpecial {

	private int                 vertices;
	private LinkedList<Integer> adjLst[];

	GraphSpecial(int V) {
		this.vertices = V;
		adjLst = new LinkedList[ vertices ];
		for (int i = 0; i < vertices; i++) {
			adjLst[ i ] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adjLst[ v ].add(w);
	}

	//Breadth First Search - No need of recursion - As queue is being used.
	/*
		1. Use Queue
		2. Create Visited boolean array to maintain visited and unvisited list
	 */
	public void BFS(int startVertex) {

		boolean[]      visited = new boolean[ vertices ];
		Queue<Integer> queue   = new LinkedList<Integer>();
		queue.offer(startVertex);
		visited[ startVertex ] = true;
		while (!queue.isEmpty()) {

			int temp = queue.poll();
			System.out.print(temp + " ");
			Iterator<Integer> it = adjLst[ temp ].iterator();
			while (it.hasNext()) {

				int v = it.next();
				if (!visited[ v ]) {
					queue.offer(v);
					visited[ v ] = true;
				}
			}
		}

	}

	void DFS(int startVertex) {
		boolean[] visited = new boolean[ vertices ];
		DFSUtil(startVertex, visited);
	}

	//DFS
	void DFSUtil(int v, boolean[] visited) {

		visited[ v ] = true;
		System.out.print(v + " ");

		Iterator<Integer> it = adjLst[ v ].iterator();
		while (it.hasNext()) {
			int t = it.next();
			if (!visited[ t ]) {
				DFSUtil(t, visited);
			}
		}

	}

	//Topological Sort

	public void topologicalSort() {

		Stack<Integer> stack   = new Stack<Integer>();
		boolean[]      visited = new boolean[ vertices ];

		for (int i = 0; i < vertices; i++) {
			if (!visited[ i ])
				topologicalUtil(i, stack, visited);
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	void topologicalUtil(int v, Stack<Integer> s, boolean[] visited) {

		visited[ v ] = true;
		int               t;
		Iterator<Integer> it = adjLst[ v ].iterator();

		while (it.hasNext()) {

			t = it.next();
			if (!visited[ t ]) {
				topologicalUtil(t, s, visited);

			}
		}
		s.push(v);

	}

	//Dijkstra shortest path


	public static void main(String args[]) {

		//BFS DFS
		//http://www.geeksforgeeks.org/breadth-first-traversal-for-a-GraphSpecial/
		GraphSpecial g = new GraphSpecial(4);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println();
		System.out.println("BFS-->");
		g.BFS(2);

		System.out.println();
		System.out.println("DFS-->");
		g.DFS(2);


		//topologivcal sort
		//http://www.geeksforgeeks.org/topological-sorting/
		GraphSpecial g1 = new GraphSpecial(6);
		g1.addEdge(5, 2);
		g1.addEdge(5, 0);
		g1.addEdge(4, 0);
		g1.addEdge(4, 1);
		g1.addEdge(2, 3);
		g1.addEdge(3, 1);

		System.out.println();
		System.out.println("Topogolical Sort -->");
		g1.topologicalSort();
		System.out.println();

	}


}