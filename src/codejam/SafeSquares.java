package codejam;

import java.util.*;
import java.io.*;

public class SafeSquares {


	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int     t  = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int     r    = in.nextInt();
			int     c    = in.nextInt();
			int[][] grid = new int[ r ][ c ];
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
    		  System.out.println(r);
    		  System.out.println(c);
    		  System.out.println(j);
    		  System.out.println(k);
					grid[ j ][ k ] = Math.min(r - j, c - k);
				}
			}
			//System.out.println(Arrays.deepToString(grid));
			//int max_square = Math.min(r, c);
			int k = in.nextInt();
			for (int j = 1; j <= k; j++) {
				int row    = in.nextInt();
				int column = in.nextInt();
				grid[ row ][ column ] = 0;
				for (int a = 0; a <= row; a++) {
					for (int b = 0; b <= column; b++) {
						int distance = Math.max(row - a, column - b);
						grid[ a ][ b ] = Math.min(distance, grid[ a ][ b ]);
					}
				}
			}
			//System.out.println(Arrays.deepToString(grid));
			long solution = 0;
			for (int a = 0; a < r; a++) {
				for (int b = 0; b < c; b++) {
					solution += grid[ a ][ b ];
				}
			}
			System.out.println("Case #" + i + ": " + solution);
		}
		in.close();
	}


	/*public static  void main(String args[]){
		int[][] mat = new int[][]{
			{0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1 },
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
			{1 ,0, 0, 0, 1, 0, 0, 0, 0, 1, 1},
			{0 ,0, 0, 0, 1, 0, 0, 0, 0, 0, 1}
		} ;

		System.out.print("Row "+mat.length +" Col :"+mat[0].length);

		System.out.println();
		int row = 4 ;
		int col = 11;
		for(int i=2;i<4;i++){
			for(int j =2;j<4;j++){
				System.out.print(mat[i][j] +" ");
			}
			System.out.println();
		}

		System.out.println();
	}*/
}
