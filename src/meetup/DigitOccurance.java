package meetup;
/*
Given a non-negative int n, and a target digit, return the count of the occurrences of the target digit.
So for example when n is 8218, and target digit is 8, the program shall return 2. Do not use iterative
 (loop) approach but recursive algorithm.
Hint: mod (%) by 10 yields the rightmost digit ( 912 % 10 is 2), while divide (/) by 10 and apply parseInt
on its result removes the rightmost digit ( parseInt(587 / 10) is 58 )
 */
public class DigitOccurance {

	public static void main(String args[]){
		DigitOccurance dg = new DigitOccurance();
		/*System.out.println(dg.digitOccurance(88,8));
		System.out.println(dg.moveX("cardxboard"));*/
		//System.out.println(dg.countTh("thethe"));
		//System.out.println(dg.countDigit(23453332,5));
		//System.out.println(dg.reverseSentence("this is me"));
		System.out.println(dg.sumNaturalNumbers(5));
		//5 4 3 2 1
	}
 //This is me
	public String reverseSentence(String str){
		int idx = str.indexOf(" ");

		if(idx < 0){
				return str;
		}

		return reverseSentence(str.substring(idx+1)) +" "+ str.substring(0,idx);
	}

	public int sumNaturalNumbers(int n){
		System.out.println(n);

		if(n == 0){
			return 0;
		}

		return n + sumNaturalNumbers(n-1);
	}

	public int digitOccurance(int digit,int target){

		if(digit == 0 ){
			return 0;
		}

		if(digit % 10 == target) {
			return 1 + digitOccurance(digit / 10, target);
		}

		return digitOccurance(digit / 10, target);
	}

	//count th in string
	public int countTh(String str){

			if(str.length() < 2){
				return 0;
			}

			if(str.substring(0,2).equals("th")){
				return 1 + countTh(str.substring(2));
			}

			return countTh(str.substring(1));
	}

	public int countDigit(int n , int target){

		if(n==0){
			return 0;
		}

		if(n%10 == target){
			return 1 + countDigit(n/10,target);
		}
		else
		{
			return countDigit(n/10,target);
		}

	}

	public String reverseString(String str){

		if(str.length() < 2){
			return str;
		}

		return reverseString(str.substring(1))+str.charAt(0);
	}
	//'cardxboard' => 'cardboardx'

	public String moveX(String str){

			if(str.length() ==0){
				return "";
			}
			if(str.charAt(0) == 'x'){
				return moveX(str.substring(1)) + str.charAt(0);
			}

			return str.charAt(0) + moveX(str.substring(1));
	}

}
