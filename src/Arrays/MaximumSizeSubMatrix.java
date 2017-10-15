package Arrays;

import java.util.*;

/*
{0,1,1,0,1},
{1,1,1,0,0},
{1,1,1,1,0},
{1,1,1,0,1}

[[0, 0, 0, 0, 0],
[0, 0, 0, 0, 0],
[0, 0, 0, 0, 0],
[0, 0, 0, 0, 0]]

[[0, 0, 0, 0, 0],
[1, 0, 0, 0, 0],
[1, 0, 0, 0, 0],
[1, 0, 0, 0, 0]]

[[0, 1, 1, 0, 1],
[1, 0, 0, 0, 0],
[1, 0, 0, 0, 0],
[1, 0, 0, 0, 0]]

 */
public class MaximumSizeSubMatrix {

	private int min(int a, int b, int c) {
		int l = Math.min(a, b);
		return Math.min(l, c);
	}

	public int maxSize(int arr[][]) {

		int result[][] = new int[ arr.length ][ arr[ 0 ].length ];

		System.out.println(Arrays.deepToString(result));
		for (int i = 0; i < arr.length; i++) {
			result[ i ][ 0 ] = arr[ i ][ 0 ];
		}
		System.out.println(Arrays.deepToString(result));

		for (int i = 0; i < arr[ 0 ].length; i++) {
			result[ 0 ][ i ] = arr[ 0 ][ i ];
		}
		System.out.println(Arrays.deepToString(result));

		int max = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[ i ].length; j++) {
				if (arr[ i ][ j ] == 0) {
					continue;
				}
				int t = min(result[ i - 1 ][ j ], result[ i - 1 ][ j - 1 ], result[ i ][ j - 1 ]);
				result[ i ][ j ] = t + 1;
				if (result[ i ][ j ] > max) {
					max = result[ i ][ j ];
				}
			}
		}
		return max;
	}


	public int minTotalDistance(int[][] grid) {
		int                m    = grid.length;
		int                n    = grid[ 0 ].length;
		ArrayList<Integer> cols = new ArrayList<Integer>();
		ArrayList<Integer> rows = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[ i ][ j ] == 1) {
					cols.add(j);
					rows.add(i);
				}
			}
		}
		int sum = 0;
		for (Integer i : rows) {
			sum += Math.abs(i - rows.get(rows.size() / 2));
		}
		Collections.sort(cols);


		for (Integer i : cols) {
			sum += Math.abs(i - cols.get(cols.size() / 2));
		}
		return sum;
	}

	public static void main(String args[]) {

		int                  arr[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 0, 1 } };
		MaximumSizeSubMatrix mssm    = new MaximumSizeSubMatrix();
		int                  result  = mssm.maxSize(arr);
		System.out.print(result);


	}

}

