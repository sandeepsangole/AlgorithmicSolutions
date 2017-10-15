public class BitManipulation {

	public static void main(String args[]){
		int a = 9 , b = 4;
		 a  = a - b ;// 5
		 b = a + b; // 5 + 4
		 a = b - a; //

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;


		int bit = 0000111;
		int bit1 = 000001111;
		System.out.println(bit%2);
		System.out.println(bit1%2);
	}
}
