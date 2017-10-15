package Arrays;

import java.util.Arrays;

public class Island {

	public static void main(String args[]){
		Island obj = new Island();
		int[][] grid = new int[][]
				{

						{1, 1, 0, 0, 0},
						{0, 1, 0, 0, 1},
						{1, 0, 0, 1, 1},
						{0, 0, 0, 0, 0},
						{1, 0, 1, 0, 1}

		};

		System.out.println(obj.numIslands(grid));
	}

	public int numIslands(int[][] grid) {
		if(grid==null || grid.length==0||grid[0].length==0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;

		int count=0;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(grid[i][j]==1){
					count++;
					merge(grid, i, j);
				}
			}
		}

		return count;
	}

	public void merge(int[][] grid, int i, int j){

		int m=grid.length;
		int n=grid[0].length;

		if(i<0||i>=m||j<0||j>=n||grid[i][j]!=1)
			return;

		grid[i][j]=-1;

		merge(grid, i+1, j+1);

		merge(grid, i-1, j);
		merge(grid, i+1, j);
		merge(grid, i, j-1);
		merge(grid, i, j+1);
		merge(grid, i-1, j-1);

	}

}
