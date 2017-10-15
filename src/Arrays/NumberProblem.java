package Arrays;
import java.math.BigInteger;

public class NumberProblem {

	public static int count =0;
	public static BigInteger mod = new BigInteger("8");
	public static void main (String args[]){
		combinations("","8888888888888888888888");
		double result = Math.pow(10,9)+7;
		int intValue =  (int)(count%result);

		System.out.println(intValue);
		//System.out.println(final);
	}

	public static void combinations(String suffix,String prefix){

		if(prefix.length()<0)return;
		if(suffix != null && suffix.length() >0 )
		{
			BigInteger bigInt = new BigInteger(suffix);
			if(BigInteger.ZERO.equals(bigInt.mod(mod)))
			count++;
		}

		for(int i=0;i<prefix.length();i++) {
			combinations(suffix + prefix.charAt(i), prefix.substring(i + 1, prefix.length()));
		}
	}
}
