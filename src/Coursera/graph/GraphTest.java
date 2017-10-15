package Coursera.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;

public class GraphTest {

	private int                 vertices;
	private LinkedList<Integer> adjLst[];

	GraphTest(int v) {
		this.vertices = v;
		adjLst = new LinkedList[ vertices ];
		for (int i = 0; i < vertices; i++) {
			adjLst[ i ] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adjLst[ v ].add(w);
	}
	/*


	 */
	void DFS() {
		Stack<Integer> s       = new Stack<>();
		boolean[]      visited = new boolean[ vertices ];
		s.push(0);
		visited[ 0 ] = true;
		System.out.println(s.peek()+" ");

		while (!s.isEmpty()) {

			int v2;
			if ((v2 = getUnvisitedAdjacentVertex(s.peek(), visited)) != -1) {
				visited[ v2 ] = true;
				s.push(v2);
				System.out.print(v2+" ");
			}
			else {
				s.pop();
			}
		}
	}

	void BFS(){

		boolean[] visited = new boolean[vertices];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		System.out.println(q.peek()+" ");

		while(!q.isEmpty()){

			int v = q.remove();
			int v2;

			while((v2 = getUnvisitedAdjacentVertex(v,visited)) != -1){
				visited[v2] = true;
				q.offer(v2);
				System.out.print(v2 +" ");
			}


		}



	}



	int getUnvisitedAdjacentVertex(int v, boolean[] visited) {

		Iterator<Integer> it = adjLst[ v ].iterator();
		while (it.hasNext()) {
			int ver = it.next();
			if (!visited[ ver ]) {
				return ver;
			}
		}

		return -1;
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int     x    = scan.nextInt();
		int     y    = scan.nextInt();

		GraphTest test = new GraphTest(x);

		for (int i = 0; i < y; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			test.adjLst[ a ].add(b);
		}

		test.DFS();
		test.BFS();
	}
}
