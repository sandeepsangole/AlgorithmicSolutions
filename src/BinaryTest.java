//Task 
//Given a base-1010 integer, nn, convert it to binary (base-22). 
//Then find and print the base-1010 integer denoting the maximum number of consecutive 11's in nn's
//binary representation.


public class BinaryTest {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		String finalStr = null;
		int max = 0;
		int count = 0;

		int n = 6;
		while (n >= 0) {
			if (n % 2 == 0) {
				sb.append("0");

			} else {
				sb.append("1");
			}
			n = n / 2;
			if (n == 1) {
				sb.append("1");
				n = -1;
			} else if (n == 0) {
				sb.append("0");
				n = -1;

			}
			

		}

		System.out.println(sb.toString());
		finalStr = sb.reverse().toString();
		System.out.println(finalStr.toString());
		int currentMax = 0;
		for (int i = 0; i < finalStr.length(); i++)

		{
			
			if (finalStr.charAt(i) == '1') {
				max = max + 1;
			} else {
				currentMax = max;
				max = 0;
				
			}

		}
		if(currentMax > max)
		System.out.println("currentMax :"+currentMax);
		else
		System.out.println("MAX :"+max);
		
	}
}
