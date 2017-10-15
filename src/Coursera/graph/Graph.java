package Coursera.graph;
import java.util.*;
public class Graph {
	private int V;
	private LinkedList<Integer> adjLst[];

	void buildUndirectedGraphAdList(int vertices,int[][] edges){

		this.V = vertices;
		for(int i =1;i<=V;i++){
			adjLst[i] = new LinkedList<Integer>();
		}

		for (int i=0;i<edges.length;i++){
				addEdge(edges[0][0],edges[1][1]);
		}
	}

	public  void addEdge(int v,int w){
		adjLst[v].add(w);
	}


	public static void main(String args[]){
		Graph g = new Graph();
		g.buildUndirectedGraphAdList(4,new int[][]{{2,1},{4,3},{1,4},{2,4},{3,2}});
	}

}
