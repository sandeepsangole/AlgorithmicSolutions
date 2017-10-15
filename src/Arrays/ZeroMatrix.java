package Arrays;

public class ZeroMatrix {
	public static void main(String args[]){
		ZeroMatrix obj = new ZeroMatrix();

	}
	public void computeZeroMatrix(int[][] matrix){
		if(matrix.length == 0 || matrix[0].length ==0){
			return;
		}
		boolean rowZero = false;
		boolean colZero = false;

		//First Row
		for(int j =0;j<matrix[0].length;j++){
			if(matrix[0][j] == 0){
				rowZero = true;
				break;
			}

		}

		//First Column
		for(int i=0;i<matrix.length;i++){
			if(matrix[i][0] == 0){
				colZero = true;
				break;
			}
		}




	}
}
