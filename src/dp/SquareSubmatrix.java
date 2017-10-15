package dp;

public class SquareSubmatrix {

	public static void main(String args[]){
		boolean[][] arr = {
				{true,true,true},
				{true,true,true}
			/*	{true,true,true,true,true},
				{true,true,true,true,false},
				{true,true,true,true,false},
				{false,true,true,true,false},
				{true,false,false,false,false},*/

			};
		System.out.print(squareSubmatrix(arr));

	}

	public static int squareSubmatrix(boolean[][] arr){

			int max = 0;
			for(int i =0;i<arr.length;i++){
				for(int j =0;j<arr[0].length;j++){
					if(arr[i][j])
					max = Math.max(max,squareMatrix(arr,i,j));
				}
			}
			return max;
	}

	public static int squareMatrix(boolean[][] arr, int i , int j){

		if(i == arr.length || j == arr[0].length){
			return 0;
		}

		if(!arr[i][j]) return 0;

		return 1 + Math.min(Math.min(squareMatrix(arr,i,j+1),
				squareMatrix(arr,i+1,j)),squareMatrix(arr,i+1,j+1));

	}

}
