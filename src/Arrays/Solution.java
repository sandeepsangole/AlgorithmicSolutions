package Arrays;

public class Solution {

	public static void main(String args[]) {
		Solution s = new Solution();
		int count = s.findCircleNum(new int[][] {
				{ 1, 1, 0 },
				{ 1, 0, 1 },
				{ 1, 0, 1 },
		});

		System.out.println("count : " + count);
	}

	private boolean[] visited;

	public int findCircleNum(int[][] M) {

		if (M.length <= 1) return M.length;

		int circle = 0;
		visited = new boolean[ M.length ];

		for (int i = 0; i < visited.length; i++) {
			if (!visited[ i ]) {
				circle++;
				visitCircle(M, i);
			}
		}
		return circle;

	}

	private void visitCircle(int[][] M, int i) {
		if (visited[ i ]) return;
		visited[ i ] = true;

		for (int j = 0; j < M[ i ].length; j++) {
			if (M[ i ][ j ] == 1 && j != i) {
				visitCircle(M, j);
			}
		}
	}

}
