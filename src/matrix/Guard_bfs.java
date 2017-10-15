package matrix;

import java.util.*;

/*
Problem:
Given a matrix that is filled with ‘O’, ‘G’, and ‘W’ where ‘O’ represents open space, ‘G’ represents guards and ‘W’ represents walls in a Bank.
Replace all of the O’s in the matrix with their shortest distance from a guard, without being able to go through any walls. Also,
replace the guards with 0 and walls with -1 in output matrix.
 */

/*
The idea is to do BFS. We first enqueue all cells containing the guards and loop till queue is not empty.
For each iteration of the loop, we dequeue the front cell from the queue and for each of its four adjacent cells,
if cell is an open area and its distance from guard is not calculated yet,
we update its distance and enqueue it. Finally after BFS procedure is over, we print the distance matrix
 */
public class Guard_bfs {

	public static void main(String args[]){
		char[][] matrix = {
				{'O', 'O', 'O', 'O', 'G'},
				{'O', 'W', 'W', 'O', 'O'},
				{'O', 'O', 'O', 'W', 'O'},
				{'G', 'W', 'W', 'W', 'O'},
				{'O', 'O', 'O', 'O', 'G'}
		};

		//call find distance
		new Guard_bfs().findDistance(matrix);
	}

	boolean isSafe(int row, int column,int[][] distance, char[][] matrix){
		return row<matrix.length && row>=0 && column<matrix[0].length && column>=0 && distance[row][column]==-1 && matrix[row][column]=='O';
	}

	void findDistance(char[][] matrix){
		int[][] distance = new int[matrix.length][matrix[0].length];
		//Build Queue for Guard positions with distance as 0
		Queue q = new LinkedList<Guard_Companion>();
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]=='G'){
					distance[i][j]=0;
					Guard_Companion companion1 = new Guard_Companion();
					//companion1.distance=0;
					companion1.i=i;
					companion1.j=j;
					q.offer(companion1);
				}else{
					distance[i][j]=-1;
				}
			}

		}

		//Iterate through Queue and its distance for neighbour cells having open space and add it to Queue with distance as 1

		while(!q.isEmpty()){
			Guard_Companion companion2 = (Guard_Companion)q.peek();
			int i = companion2.i;
			int j = companion2.j;
			//int dist = companion2.distance;
			int[] rowNeighbour =    {0,0,1,-1};
			int[] columnNeighbour = {1,-1,0,0};
			for(int k=0;k<4;k++){

			//	System.out.println(i+rowNeighbour[k] +" : "+ (j+columnNeighbour[k]));

				if(isSafe(i+rowNeighbour[k], j+columnNeighbour[k], distance, matrix)){
					distance[i+rowNeighbour[k]][j+columnNeighbour[k]] = distance[i][j] + 1;
					Guard_Companion companion3 = new Guard_Companion();
					companion3.i = i+rowNeighbour[k];
					companion3.j = j+columnNeighbour[k];
					//companion3.distance = distance[i][j] + 1;
					q.offer(companion3);
				}

			}
			//Once all neighbouring cells are visited ..remove from queue
			q.poll();
		}

		for(int p = 0 ; p<distance.length;p++){
			for(int j=0;j<distance[0].length;j++)
			{
				System.out.print(distance[p][j]+" ");
			}
			System.out.println();
		}
	}
}

class Guard_Companion {
	// i, j and distance stores x and y-coordinates
	// of a matrix cell and its distance from guard
	// respectively
	int i;
	int j;
	//int distance;
}