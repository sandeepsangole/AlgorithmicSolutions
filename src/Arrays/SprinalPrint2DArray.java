package Arrays;

import java.util.*;

public class SprinalPrint2DArray {

	public static void main(String args[]) {
		SprinalPrint2DArray obj = new SprinalPrint2DArray();

		int[][] arr =
				{
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8, },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }
		};

		obj.printSpiralOrder(arr);

	}

	public void printSpiralOrder(int[][] arr) {

		int row = arr.length;
		int col = arr[ 0 ].length;
		List<Integer> res =  printSpiralOrder(arr, row, col);

		//System.out.println(Arrays.asList(res));

		System.out.println(Arrays.asList(printSpiralRecursion(arr)));

	}

	public enum Direction {
		LEFT, RIGHT, TOP, BOTTOM
	}

	static ArrayList<Integer> printSpiralRecursion(int[][] arr) {
		return spiralOrder(arr,0,0,arr.length,arr[0].length);

	}


			public static ArrayList<Integer> spiralOrder(int [][] matrix, int x, int y, int m, int n){
				ArrayList<Integer> result = new ArrayList<Integer>();

				if(m<=0||n<=0)
					return result;

				//only one element left
				if(m==1&&n==1) {
					result.add(matrix[x][y]);
					return result;
				}

				//top - move right
				for(int i=0;i<n-1;i++){
					result.add(matrix[x][y++]);
				}

				//right - move down
				for(int i=0;i<m-1;i++){
					result.add(matrix[x++][y]);
				}

				//bottom - move left
				if(m>1){
					for(int i=0;i<n-1;i++){
						result.add(matrix[x][y--]);
					}
				}

				//left - move up
				if(n>1){
					for(int i=0;i<m-1;i++){
						result.add(matrix[x--][y]);
					}
				}

				if(m==1||n==1)
					result.addAll(spiralOrder(matrix, x, y, 1, 1));
				else
					result.addAll(spiralOrder(matrix, x+1, y+1, m-2, n-2));

				return result;
	}

		

	List printSpiralOrder(int[][] arr, int row, int col) {

		List<Integer> arrayList = new ArrayList<Integer>();
		int       topRow    = 0;
		int       bottomRow = row - 1;
		int       leftCol   = 0;
		int       rightCol  = col - 1;
		Direction dir       = Direction.RIGHT;

		while (topRow <= bottomRow && leftCol <= rightCol) {
			//System.out.print("\n");

			if (dir == Direction.RIGHT) {
				for (int i = leftCol; i <= rightCol; i++){
					//System.out.print(" " + arr[ topRow ][ i ]);
					arrayList.add(arr[ topRow ][ i ]);
				}
				topRow++;
				dir = Direction.BOTTOM;
			}


			if (dir == Direction.BOTTOM) {
				for (int i = topRow; i <= bottomRow; i++) {
					//System.out.print(" " + arr[ i ][ rightCol ]);
					arrayList.add(arr[ i ][ rightCol ]);
				}

				rightCol--;
				dir = Direction.LEFT;

			}

			if(dir == Direction.LEFT){
				for(int i=rightCol;i>=leftCol;i--) {
					//System.out.print(" " + arr[ bottomRow ][ i ]);
					arrayList.add(arr[ bottomRow ][ i ]);
				}
					bottomRow--;
					dir= Direction.TOP;

			}

			if(dir == Direction.TOP){
				for(int i=bottomRow;i>=topRow;i--) {
					//System.out.print(" " + arr[ i ][ leftCol ]);
					arrayList.add(arr[ i ][ leftCol ]);
				}
					leftCol++;
				dir = Direction.RIGHT;

			}
		}

		return arrayList;
	}

	void printSpiralOrderLeft(int[][] arr, int row, int col) {
		int       topRow    = 0;
		int       bottomRow = row - 1;
		int       leftCol   = 0;
		int       rightCol  = col - 1;
		Direction dir       = Direction.BOTTOM;


		while (topRow <= bottomRow && leftCol <= rightCol) {
			System.out.print("\n");

			if (dir == Direction.BOTTOM) {
				for (int i = topRow; i <= bottomRow; i++)
					System.out.print(" " + arr[ i ][ leftCol ]);

				leftCol++;
				dir = Direction.RIGHT;

			}


			if (dir == Direction.RIGHT) {
				for (int i = leftCol; i <= rightCol; i++)
					System.out.print(" " + arr[ bottomRow ][ i ]);
				bottomRow--;
				dir = Direction.TOP;
			}

			if (dir == Direction.TOP) {
				for (int i = bottomRow; i >= topRow; i--)
					System.out.print(" " + arr[ i ][ rightCol ]);
				rightCol--;
				dir = Direction.LEFT;

			}

			if (dir == Direction.LEFT) {
				for (int i = rightCol; i >= leftCol; i--)
					System.out.print(" " + arr[ topRow ][ i ]);
				topRow++;
				dir = Direction.BOTTOM;

			}


		}
	}
}
