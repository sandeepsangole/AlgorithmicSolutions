package dp;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class  EggDropping {


	public int eggDropMemorization(int eggs, int floors) {
		return eggDropRec(eggs, floors, new int[ eggs + 1 ][ floors + 1 ]);
	}



	public int calculate(int eggs, int floors) {

		int T[][] = new int[ eggs + 1 ][ floors + 1 ];
		int c     = 0;
		for (int i = 0; i <= floors; i++) {
			T[ 1 ][ i ] = i;
		}

		for (int e = 2; e <= eggs; e++) {
			for (int f = 1; f <= floors; f++) {
				T[ e ][ f ] = Integer.MAX_VALUE;
				for (int k = 1; k <= f; k++) {
					c = 1 + Math.max(T[ e - 1 ][ k - 1 ], T[ e ][ f - k ]);
					if (c < T[ e ][ f ]) {
						T[ e ][ f ] = c;
					}
				}
			}
		}
		return T[ eggs ][ floors ];
	}

	public int calculateRecursive(int eggs, int floors,int[][] array) {
		if (eggs == 1) {
			return floors;
		}
		if (floors == 0) {
			return 0;
		}

		if (array[ eggs ][ floors ] > 0) {
			return array[ eggs ][ floors ];

		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= floors; i++) {
			int val = 1 + Math.max(calculateRecursive(eggs - 1, i - 1,array),
					calculateRecursive(eggs, floors - i,array));
			if (val < min) {
				min = val;
			}
		}

		array[ eggs ][ floors ] = min;

		return min;
	}

	public static void main(String args[]) {
		EggDropping ed = new EggDropping();
	/*	int         r  = ed.calculate(2, 5);
		System.out.println(r);
		int r1 = ed.calculateRecursive(2, 10,new int[2][10]);
		System.out.println(r1);*/
		int r2 = ed.eggDropMemorization(2,6);
		System.out.println(r2);

	}

	public int eggDropRec(int eggs,int floors,int[][] array){

		if(eggs == 1){
			return floors;
		}

		if(floors == 0){
			return 0;
		}

		if(array[eggs][floors] > 0){
			return array[ eggs ][ floors ];
		}
		int min = Integer.MAX_VALUE;

		for(int i = 1; i <= floors;i++){

			int val =  1 + Math.max(eggDropRec(eggs - 1,i - 1,array),
					eggDropRec(eggs,floors - i,array));
			if(val < min){
				min = val;
			}
		}

		array[eggs][floors] = min;

		return min;
	}
}
