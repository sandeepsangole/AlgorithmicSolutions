package Arrays;

public class IslandTemp {

	public static void main(String args[]){
		IslandTemp obj = new IslandTemp();
		System.out.println(obj.getIslandCount(new int[][]{
				{1, 1, 0, 0, 0},
				{0, 1, 0, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 0, 0, 0},
				{1, 0, 1, 0, 1}

		}));
	}

public int getIslandCount(int[][] grid){
	int count = 0;
	if(grid == null || grid.length == 0 || grid[0].length == 0)
		return count;

	int m = grid.length;
	int n = grid[0].length;

	for(int i =0 ;i <m;i++){
		for(int j =0;j<m;j++){

			if(grid[i][j] == 1)
			{
				count++;
				merge(grid,i,j);
			}
		}
	}
	return count;
}

public void merge(int[][] grid , int i,int j){

	int m = grid.length;
	int n = grid[0].length;

	if(i < 0 || j < 0 || i >= m || j >=n || grid[i][j] !=1)
		return;

	grid[i][j] = -1;

	merge(grid,i,j-1);
	merge(grid,i-1,j);
	merge(grid,i,j+1);
	merge(grid, i+1,j);
}
}
