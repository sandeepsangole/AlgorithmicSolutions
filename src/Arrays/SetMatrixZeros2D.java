package Arrays;

import java.util.Arrays;
/*

1.First check of first row and column has zero..and set flags accordingly
2.Iterate remaining matrix and update correspoding row 0 and col0 valus
3.Set values to zero based on row col values
4.user firstrow and column flags to set first row and column.
 */
public class SetMatrixZeros2D {

	public static void main(String args[]) {
		int[][] mat = {
				{ 1, 0, 1, 1 },
				{ 0, 1, 1, 0 },
				{ 1, 1, 1, 1 },
				{ 0, 0, 1, 1 }
		};

		int nRows = mat.length;
		int nCols = mat[ 0 ].length;
		SetMatrixZeros2D obj = new SetMatrixZeros2D();

		obj.printArray(mat);
		System.out.println();
		System.out.println();
		System.out.println();
		obj.setZeros(mat,nRows,nCols);
		obj.printArray(mat);

	}


	public void setZeros(int [][] mat,int rows,int cols) {

		if (mat.length == 0 || mat[ 0 ].length == 0)
			return;

		boolean rowZero = false;
		boolean colZero = false;

		for (int r = 0; r < rows; r++) {
			if (mat[ r ][ 0 ] == 0) {
				colZero = true;
			}
		}

		for (int c = 0; c < cols; c++) {
			if (mat[ 0 ][ c ] == 1) {
				rowZero = true;
			}
		}

		for (int r = 1; r < rows; r++) {
			for (int c = 1; c < cols; c++) {
				if (mat[ r ][ c ] == 0) {
					mat[ r ][ 0 ] = 0;
					mat[ 0 ][ c ] = 0;
				}
			}
		}

		for (int r = 0; r < rows; r++) {
			if (mat[ r ][ 0 ] == 0) {
				for (int c = 1; c < cols; c++) {
					mat[ r ][ c ] = 0;
				}
			}
		}

		for (int c = 0; c < cols; c++) {
			if (mat[ 0 ][ c ] == 0) {
				for (int r = 1; r < rows; r++) {
					mat[ r ][ c ] = 0;
				}
			}
		}

		if (rowZero) {
			for (int c = 0; c < cols; c++) {
				mat[ 0 ][ c ] = 0;
			}
		}

		if (colZero) {
			for (int r = 0; r < cols; r++) {
				mat[ r ][ 0 ] = 0;
			}
		}
	}



	public void printArray(int[][] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j <array[i].length; j++){
				System.out.print(array[i][j]);

			}
			System.out.println();
	}
	}


}
