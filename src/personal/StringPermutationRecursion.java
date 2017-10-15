package personal;

public class StringPermutationRecursion {
	public static void main(String args[]) {
		permutation("AABC");
	}

	public static void permutation(String input) {
		permutation("", input);
	}

	/* * Recursive method which actually prints all permutations * of given String, but since we are passing an empty
	String * as current permutation to start with, * I have made this method private and didn't exposed it to client. */
	private static void permutation(String perm, String word) {
		if (word.isEmpty()) {
			System.err.println(perm);
		} else {
			for (int i = 0; i < word.length() ;i++){
				/*System.out.println("=================");
				System.out.println("i :"+i);
				System.out.println("PERM:"+perm);
				System.out.println("Wrd:"+word);
				System.out.println("word.substring(0, i) :"+word.substring(0, i) );
				System.out.println("word.substring(i + 1, word.length()) :"+word.substring(i + 1, word.length()));
				System.out.println(perm + word.charAt(i)+","+ word.substring(0, i) + word.substring(i + 1, word.length()));
				System.out.println("=================");*/
				permutation(perm + word.charAt(i),  word.substring(0,i)+word.substring(i + 1, word.length()));
			}
		}
	}
}

