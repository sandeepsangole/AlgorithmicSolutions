package Arrays;

import java.util.Arrays;

public class RotateImage90 {

	public static void main(String[] args){
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,0,1,2},
				{3,4,5,6}
		};

		RotateImage90 obj = new RotateImage90();
		int n = arr.length;
		System.out.println(Arrays.asList(obj.rotateMatrix(arr,n)));
	}

	public int[][] rotateMatrix(int[][] matrix,int n){

		int[][] result = new int[n][n];
		for(int i =0;i<n;i++){
			for(int j=0;j<n;j++){
				result[i][j] = matrix[n-j-1][i];
			}
		}

		return result;
	}
}
