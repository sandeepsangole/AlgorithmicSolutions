package Arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RotateArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = 4;
		int n = 4;
		int r = 9;

		int[][] rotatedMatrix = new int[m][n];
		int[][] matrix = {{1,2,3,4},
								{5,6,7,8,},
								{9,10,11,12},
								{13,14,15,16}
							  };
		/*for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
			}int[][] matrix = new int[m][n];
		}*/

		int depth = findMaxDepth(m, n);

		for (int j = 1; j <= depth; j++) {
			int[] rotated = rotateArray(extractItemsFromMatrixDepth(matrix, m, n, j), r);
			addItemsToMatrix(rotatedMatrix, rotated, m, n, j);
		}
		printMatrix(rotatedMatrix);
	}

	public static void addItemsToMatrix(int[][] matrix, int[] itemsInDepth, int m, int n, int depth) {
		handleMatrixFromDepth(matrix, itemsInDepth, m, n, depth);
	}

	public static int[] extractItemsFromMatrixDepth(int[][] matrix, int m, int n, int depth) {
		return handleMatrixFromDepth(matrix, null, m, n, depth);
	}

	public static int[] handleMatrixFromDepth(int[][] matrix, int[] itemsInDepth, int m, int n, int depth) {
		boolean extract = false;
		if (itemsInDepth == null) {
			itemsInDepth = new int[getOuterDepthItemCount(m, n, depth)];
			extract = true;
		}
		int rows = getRowsForDepth(m, depth);
		int columns = getColumnsForDepth(n, depth);
		int index = 0;
		int columnIndex = depth - 1;
		int rowIndex = depth - 1;
		for(int r1 = rowIndex; r1 < (depth + rows - 1); r1++) {
			if (extract) itemsInDepth[index] = matrix[r1][depth - 1];
			else matrix[r1][depth - 1] = itemsInDepth[index];
			rowIndex = r1;
			index++;
		}
		for(int c1 = columnIndex + 1; c1 < (depth + columns - 1); c1++) {
			if (extract) itemsInDepth[index] = matrix[rowIndex][c1];
			else matrix[rowIndex][c1] = itemsInDepth[index];
			columnIndex = c1;
			index++;
		}
		for(int r2 = rowIndex - 1; r2 >= (depth - 1); r2--) {
			if (extract) itemsInDepth[index] = matrix[r2][columnIndex];
			else matrix[r2][columnIndex] = itemsInDepth[index];
			rowIndex = r2;
			index++;
		}
		if (columnIndex - depth > 0) { // no need to add already added indexes
			for(int c2 = columnIndex - 1; c2 > (depth - 1); c2--) {
				if (extract) itemsInDepth[index] = matrix[rowIndex][c2];
				else matrix[rowIndex][c2] = itemsInDepth[index];
				index++;
			}
		}
		return itemsInDepth;
	}

	public static int findMaxDepth(int m, int n) {
		return Math.min(m, n) / 2;
	}

	public static int getOuterDepthItemCount(int m, int n, int depth) {
		int maxDepth = findMaxDepth(m, n);
		int valueForDepth = getDepthItemCount(m, n, depth)
				- (depth == maxDepth ? 0 : getDepthItemCount(m, n, depth + 1));
		return valueForDepth;
	}

	public static int getDepthItemCount(int m, int n, int depth) {
		return getRowsForDepth(m, depth) * getColumnsForDepth(n, depth);
	}

	public static int getRowsForDepth(int m, int depth) {
		return m - ((depth - 1) * 2);
	}

	public static int getColumnsForDepth(int n, int depth) {
		return n - ((depth - 1) * 2);
	}

	public static int[] rotateArray(int[] array, int order) {
		int[] result = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			result[(i + order) % array.length] = array[i];
		}
		return result;
	}

	public static void printMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if ((j + 1) % n == 0) {
					System.out.println(matrix[i][j]);
				} else {
					System.out.print(matrix[i][j]+" ");
				}
			}
		}
	}
}