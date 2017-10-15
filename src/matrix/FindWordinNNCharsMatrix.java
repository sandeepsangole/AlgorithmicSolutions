package matrix;
/*
Find all occurrences of a given word in a matrix
Given a 2D grid of characters and a word, find all occurrences of given word in grid. A word can be matched in all
8 directions at any point. Word is said be found in a direction if all characters match in this direction (not in zig-zag form).

The solution should print all coordinates if a cycle is found. i.e.
The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up, Vertically Down and 4 Diagonals.

 finding word in all the directions including Zig-Zag

 */
public class FindWordinNNCharsMatrix {

	static final int M = 5;
	static final int N = 5;

	static int     rowNum[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int     colNum[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Boolean found    = false;

	public static void main(String[] args) {
/*
		char[][] M = {
				//	  0     1    2    3    4
					{ 'a', 'b', 'n', 'd', 'e' },
					{ 'd', 'f', 'u', 'g', 'n' },
					{ 'f', 'l', 'r', 'n', 's' },
					{ 'b', 'f', 'y', 'u', 'o' },
					{ 'n', 'u', 'f', 'u', 'n' } };

		String input = "fun";*/

char [][] M = {{'A','C','P','R','C'},
					{'X','S','O','P','C'},
					{'V','O','V','N','I'},
					{'W','G','F','M','N'},
					{'Q','A','T','I','T'} };

		String input = "MICROSOFT";

		findWord(M, input);

	}

	static boolean isSafe(int i, int j, int prevRow, int prevCol) {

		if (i >= 0 && i <= (M - 1) && j >= 0 && j <= N - 1 && (i != prevRow) && (j != prevCol)) {
			return true;
		}

		return false;
	}

	private static void findWord(char[][] m, String input) {
		// TODO Auto-generated method stub

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (m[ i ][ j ] == input.charAt(0)) {
					String temp = m[ i ][ j ] + "";
					String path = m[ i ][ j ] + "(" + i + "," + j + ")";
					findWordUtil(m, i, j, -1, -1, temp, input, path);

				}

			}

		}

		if (!found)
			System.out.println("not found the input");

	}

	private static void findWordUtil(char[][] m, int i, int j, int prevRow, int prevCol, String temp, String input,
	                                 String path) {

		//System.out.println("Current : "+i+" : "+j +  "Previous : "+prevRow+" : "+prevCol +" temp : "+temp);

		if (temp.equalsIgnoreCase(input)) {
			found = true;
			System.out.println("found the input: path: " + path + " found:" + found);
			return;
			// return true;
		}

		for (int k = 0; k < 8; ++k) {
			int newRow = i + rowNum[ k ];
			int newCol = j + colNum[ k ];

			if (isSafe(newRow, newCol, prevRow, prevCol)) {
				char c = m[ newRow ][ newCol ];
				if (input.contains(temp + c)) {
					findWordUtil(m, newRow, newCol, i, j, temp + c, input,
							path.concat(c + "(" + newRow + "," + newCol + ")"));
				}

			}

		}

	}
}

