package meetup;
/*
Graph can be stored as edge list, adjacency list, and adjacency matrix.

The following graph, with 6 vertices indexed 0-5, is stored as an edge list in the variable edgeList.

var edgeList = [ [0, 2], [1, 3], [2, 3], [2, 4], [3, 5], [4, 5] ];

                   0
                   |
              1    2
               \ /   \
                3     4
                 \   /
                   5

By converting the edgeList, store the same graph to an adjacency matrix and list, in the variable adjMatrix and adjList, respectively.

var adjMatrix = [
    ];

var adjList = [
    ];

reference link: https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/p/challenge-store-a-graph

 */

import java.util.*;
public class Graph {

	public static void main(String args[]){
		Graph g = new Graph();
		int[][] matrix = g.buildAdjMatrix(6,new int[][]{
				{0, 2},{1, 3}, {2, 3}, {2, 4}, {3, 5}, {4, 5}});

		for(int i =0;i<matrix.length;i++){

			for(int j=0;j<matrix[0].length;j++){
				System.out.println(matrix[i][j]);
			}
		}

		ArrayList<ArrayList<Integer>> res = g.buildAdjLst(6,new int[][]{
				{0, 2},{1, 3}, {2, 3}, {2, 4}, {3, 5}, {4, 5}});

		g.printListOfList(res);
	}

	public int[][] buildAdjMatrix(int vertices, int[][] edgeLst){

			if(edgeLst == null || edgeLst.length == 0 || vertices == 0){
				return null;
			}

			int[][] adjMatrix = new int[vertices][vertices];

			for(int[] edge : edgeLst){
				adjMatrix[edge[0]][edge[1]] = 1;
			}

			return adjMatrix;

	}

	public ArrayList<ArrayList<Integer>> buildAdjLst(int vertices,int[][] edgeLst){

		if(edgeLst == null || edgeLst.length == 0 || vertices == 0){
			return null;
		}

		ArrayList<ArrayList<Integer>> lst = new ArrayList<>();

		for(int i =0 ;i<vertices;i++){
			lst.add(i,new ArrayList<>());
		}

		for(int[] edge : edgeLst){
			lst.get(edge[0]).add(edge[1]);
		}

		return lst;

	}

	void printListOfList(ArrayList<ArrayList<Integer>> res) {
		for (List<Integer> n : res) {

			for (Integer t : n)
				System.out.print(t + " ");

			System.out.print(",");

		}
		System.out.println();
	}


}
