package matrix;
/*

Given a 2D grid of characters and a word, find all occurrences of given word in grid.
A word can be matched in all 8 directions at any point. Word is said be found in a direction if
all characters match in this direction (not in zig-zag form).

The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up and 4 Diagonal directions.

With time complexity O(R*C*N) where R is the no of rows, C is the no of Col, and N is length for word.

 */
public class FindWordinNNCharsMatrixOneDir {


	static Boolean found    = false;

	public static void main(String[] args) {

		char[][] M = {
				{ 'a', 'b', 'n', 'd', 'e' },
				{ 'd', 'f', 'u', 'g', 'n' },
				{ 'f', 'l', 'n', 'n', 's' },
				{ 'b', 'f', 'u', 'o', 'o' },
				{ 'n', 'u', 'f', 'u', 'n' } };

		String input = "nso";//"fun";

		findWord(M, input);

	}

	static boolean isSafe(int i, int j,char[][] m) {

		int R = m.length;
		int C = m[0].length;

		if (i >= 0 && i <= (R - 1) && j >= 0 && j <= C - 1) {
			return true;
		}

		return false;
	}

	private static void findWord(char[][] m, String input) {
		// TODO Auto-generated method stub
		int R = m.length;
		int C = m[0].length;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				findWordUtil(m, i, j, input);
			}

		}

		if (!found)
			System.out.println("not found the input");

	}

	private static void findWordUtil(char[][] m, int row, int col, String word) {

		 int     rowNum[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		 int     colNum[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		if (m[ row ][ col ] != word.charAt(0)) {
			return;

		}

		int len = word.length();

		//eight cells
		for (int dir = 0; dir < 8; ++dir) {
			int    rd   = row + rowNum[ dir ];
			int    cd   = col + colNum[ dir ];
			int    k;
			String path = word.charAt(0) + "(" + row + "," + col + ")";

			//System.out.println(" checking for  (" + rd + "," + cd + ")");
			//remaining letters in word
			for (k = 1; k <= len - 1; k++) {

				if (!isSafe(rd, cd,m)) {
					break;
				}

				if (!(m[ rd ][ cd ] == word.charAt(k))) {
					break;
				} else {
					path = path.concat(m[ rd ][ cd ] + "(" + rd + "," + cd + ")");
				}

				//  Moving in particular direction
				rd = rd + rowNum[ dir ];
				cd = cd + colNum[ dir ];
			}

			if (k == len) {
				System.out.println("found the word: path:" + path);
				found = true;
			}

		}

	}
}
