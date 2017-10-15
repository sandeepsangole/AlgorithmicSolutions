package matrix;

/*
	Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example,
	the below matrix contains 5 islands

Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}
Output : 5

 */
public class NoOfIslands {

	public static void main(String args[]) {
		NoOfIslands obj = new NoOfIslands();

		int mat[][] =
				{
						{ 1, 1, 0, 0, 0 },
						{ 0, 1, 0, 0, 1 },
						{ 1, 0, 0, 1, 1 },
						{ 0, 0, 0, 0, 0 },
						{ 1, 0, 1, 0, 1 }
				};

		System.out.print(countIslands(mat));
	}

	public static int countIslands(int[][] mat) {

		int row = mat.length;
		int col = mat[ 0 ].length;

		int         count   = 0;
		boolean[][] visited = new boolean[ row ][ col ];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (mat[ i ][ j ] == 1 && !visited[ i ][ j ]) {
					DFS(i, j, visited, mat);
					++count;
				}
			}
		}

		return count;
	}

	static boolean isSafe(int row, int col, boolean[][] visited, int[][] matrix) {

		return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[ 0 ].length &&
				matrix[ row ][ col ] == 1 && !visited[ row ][ col ]);
	}

	static void DFS(int r, int c, boolean[][] visited, int[][] mat) {


		int[] rowNieghbours = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colNeighbours = { -1, 0, 1, 1, -1, -1, 0, 1 };

		visited[ r ][ c ] = true;
		for (int k = 0; k < 8; k++) {

			if (isSafe(r + rowNieghbours[ k ], c + colNeighbours[ k ], visited, mat)) {

				DFS(r + rowNieghbours[ k ], c + colNeighbours[ k ], visited, mat);
			}
		}
	}

}
