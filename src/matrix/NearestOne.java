package matrix;

import java.util.*;

/*
Given a binary matrix of order m*n, the task is to find the distance of nearest 1 for each 0 in the matrix and print final distance matrix. From any cell (i,j), we can move only in four directions up, down, left and right.
Note : Distance from one cell to immediate another cell is always incremented by 1.

Examples:

Input : m = 3, n = 4
        mat[m][n] = {{0, 0, 0, 1},
                     {0, 0, 1, 1},
                     {0, 1, 1, 0}}
Output: 3 2 1 0
        2 1 0 0
        1 0 0 1

 */
public class NearestOne {

	public static void main(String args[]) {

		int[][] mat =
				{ { 0, 0, 0, 1 },
						{ 0, 0, 1, 1 },
						{ 0, 1, 1, 0 }
				};

		NearestOne obj = new NearestOne();
		obj.findDistance(mat);
	}

	class Distance {
		int r;
		int c;

		Distance(int r, int c) {
			this.r = r;
			this.c = c;
		}

		Distance() {

		}
	}


	public void findDistance(int[][] mat) {

		int[][] distance = new int[ mat.length ][ mat[ 0 ].length ];
		Queue<Distance> q = new LinkedList<Distance>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[ 0 ].length; j++) {
				distance[ i ][ j ] = Integer.MAX_VALUE;

				if (mat[ i ][ j ] == 1) {
					distance[ i ][ j ] = 0;
					Distance d = new Distance(i, j);
					q.offer(d);
				}
			}
		}

		while (!q.isEmpty()) {

			Distance d2 = q.poll();
			int      r  = d2.r;
			int      c  = d2.c;

			int[] rowN = { 0, 0, 1, -1 };
			int[] colN = { 1, -1, 0, 0 };

			for (int k = 0; k < 4; k++) {

				final int i  = r + rowN[ k ];
				final int i1 = c + colN[ k ];
				if (i >= 0 && i < mat.length &&
						i1 >= 0 && i1 < mat[ 0 ].length &&
						distance[ i ][ i1 ] > distance[ r ][ c ] + 1) {

					distance[ i ][ i1 ] = distance[ r ][ c ] + 1;
					Distance d3 = new Distance();
					d3.r = i;
					d3.c = i1;
					q.offer(d3);

				}
			}
		}

		for (int p = 0; p < distance.length; p++) {
			for (int j = 0; j < distance[ 0 ].length; j++) {
				System.out.print(distance[ p ][ j ] + " ");
			}
			System.out.println();
		}

	}
}
