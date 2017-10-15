package graphtheory;
//30 March 2017


import java.util.*;

class Ver {

	char    label;
	boolean isVisited;

	Ver(char label) {
		this.label = label;
		isVisited = false;
	}
}

class GraphNew {

	private final int MAX_VER = 20;
	List<Ver>      vLst;
	int[][]        adjMat;
	Stack<Integer> stack;

	Queue<Integer> queue;

	public GraphNew() {

		vLst = new ArrayList<Ver>();
		adjMat = new int[ MAX_VER ][ MAX_VER ];

		//Stack For DFS
		stack = new Stack<Integer>();

		//Queue for BFS
		queue = new LinkedList<Integer>();
	}

	public void addVertex(char lab) {

		if (vLst.size() < MAX_VER) {
			vLst.add(new Ver(lab));
		} else {
			System.out.println("Max vertext created");
		}

	}

	public void addEdge(int start, int end) {
		adjMat[ start ][ end ] = 1;
		adjMat[ end ][ start ] = 1;
	}

	public void displayVertex(int V) {
		System.out.println(vLst.get(V).label);
	}


	public void dfs() {
		//starting from VertexNewt 0;
		vLst.get(0).isVisited = true;
		displayVertex(0);
		stack.push(0);

		while (!stack.isEmpty()) {
			int v = getUnvisitedAdjVertex(stack.peek());

			if (v == -1) {
				stack.pop();
			} else {
				vLst.get(v).isVisited = true;
				displayVertex(v);
				stack.push(v);
			}

		}

		//Setting all visited to false for BFS
		for (int i = 0; i < vLst.size(); i++) {
			vLst.get(i).isVisited = false;
		}

	}

	int getUnvisitedAdjVertex(int v) {

		for (int j = 0; j < vLst.size(); j++) {
			if (adjMat[ v ][ j ] == 1 && vLst.get(j).isVisited == false)
				return j;

		}
		return -1;
	}


	public void bfs() {

		vLst.get(0).isVisited = true;
		displayVertex(0);
		queue.offer(0);

		while (!queue.isEmpty()) {

			int v = queue.remove();
			int v2;
			while ((v2 = getUnvisitedAdjVertex(v)) != -1) {
				vLst.get(v2).isVisited = true;
				displayVertex(v2);
				queue.offer(v2);

			}
		}

		//Setting all visited to false for DFS
		for (int i = 0; i < vLst.size(); i++) {
			vLst.get(i).isVisited = false;
		}

	}


	public void topologicalSort(){

		Stack<Integer> topoStack = new Stack<Integer>();

		for(int i=0;i<vLst.size();i++){
			if(!vLst.get(i).isVisited){
				topologicalSortUtil(i,topoStack);
			}
		}

		//System.out.println(topoStack);

		while (!topoStack.empty())
			System.out.print(vLst.get(topoStack.pop()).label + " ");

	}

	void topologicalSortUtil(int v, Stack<Integer> stack){

		vLst.get(v).isVisited = true;
		int v2;
		while ((v2 = getUnvisitedAdjVertex(v)) != -1) {
			topologicalSortUtil(v2, stack);
		}


		stack.push(v);
	}
}


public class DFSApp {

	public static void main(String args[]) {

		GraphNew g = new GraphNew();
		g.addVertex('A');//0
		g.addVertex('B');//1
		g.addVertex('C');//2
		g.addVertex('D');//3
		g.addVertex('E');//4

		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(4, 4);
		g.addEdge(3, 4);

  /*
      0 ---- 1----2
      \
      3---4
   */
		System.out.println("DFS : ");
		g.dfs();


		System.out.println("BFS : ");
		g.bfs();

		System.out.println("TOPO Sort  : ");
		g.topologicalSort();


	}
}
