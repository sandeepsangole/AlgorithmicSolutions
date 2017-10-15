package String;

public class StringMoveSpacesToFront {

	public static void main(String[] args) {
		StringMoveSpacesToFront obj = new StringMoveSpacesToFront();
		obj.moveSpaces("sa nd eep");
	}

	public void moveSpaces(String str) {

		char[] charStr = str.toCharArray();
		System.out.println(charStr);
		int end = charStr.length - 1;
		for (int i = end; i >= 0; i--) {

			if (charStr[ i ] != ' ') {
				swap(charStr, end--, i);
			}
		}
		System.out.println(charStr);
	}

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[ i ];
		arr[ i ] = arr[ j ];
		arr[ j ] = temp;
	}
}
