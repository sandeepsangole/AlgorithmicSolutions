package meetup;

/*
Given a string, compute recursively (no loops) the number of times lowercase "th" appears in the string.
 */
public class RecustionSpecial {

	public static void main(String args[]) {

		RecustionSpecial obj = new RecustionSpecial();
		//System.out.println(obj.countTh("theth"));
		//System.out.println(obj.countTimes10(new int[]{1,5,6,160,8,80,90,90},0));
		//System.out.print(obj.moveX("monxeyxgame"));

		//System.out.println(obj.moveEmptySpaces("    Sa an deep"));
		//System.out.println(obj.wordReverse("cat is running"));
		//System.out.println(obj.mutliply(2,3));
		System.out.println(obj.findElementBinarySearch(new int[]{1,3,5,7,9,11,15,16,50,100},0));
	}

	/*
	Given a string, compute recursively (no loops) the number of times lowercase "th" appears in the string.
	 */
	public int countTh(String source) {

		if (source.length() < 2) {
			return 0;
		}
		if (source.substring(0, 2).equals("th")) {
			return 1 + countTh(source.substring(2));
		}

		return countTh(source.substring(1));

	}

	/*
	Given an array of numbers, compute recursively to check whether somewhere there is a  number A, and
	its followed number is 10 times of it. Say the array [1, 5, 6, 60, 8], the function will return
	true because the value after 6, is 10 times of it (60).
	The initial call in the function will pass in index as 0.
	 */

	public boolean countTimes10(int[] numbers, int index) {

		if (index == numbers.length - 1) {
			return false;
		}

		if (numbers[ index ] * 10 == (numbers[ index + 1 ])) {
			return true;
		}

		return countTimes10(numbers, ++index);
	}

	/*
	Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.
	Ex:
	'cardxboard' => 'cardboardx'
	'monxeyxgame' => 'moneygamexx'
*/

	public String moveX(String str) {

		//System.out.println(str);

		if (str.length() == 0) {
			return "";
		}

		if (str.charAt(0) == 'x') {
			return moveX(str.substring(1)) + 'x';
		}
		return str.charAt(0) + moveX(str.substring(1));
	}

	//reverse String
	public String reverseString(String str) {

		if (str.length() < 2) {
			return str;
		}

		return reverseString(str.substring(1, str.length())) + str.charAt(0);

	}

	//move empty space at the end

	public String moveEmptySpaces(String str) {

		if (str.length() == 0) {
			return "";
		}

		if (str.charAt(str.length()) == ' ') {
			return moveEmptySpaces(str.substring(1)) + str.charAt(0);
		} else
			return str.charAt(0) + moveEmptySpaces(str.substring(1));
	}

		/*
		Write a recursive function to reverse a string. Write a recursive
			function to reverse the words in a string, i.e., ”cat is running”
			becomes ”running is cat”.
		 */

/*		public String reverseSentence(String str){

			if(str.length() < 2)
			{
				return str;
			}

			if(str.charAt(0) == ' '){

			}

		}*/

	//Program: Write a program to reverse a string using recursive algorithm.


	public static String wordReverse(String s) {
		System.out.println(s);
		int idx = s.indexOf(" ");
		if (idx < 0) {
			// no space char found, thus, s is just a single word, so return just s itself
			return s;
		} else {
			// return at first the recursively reversed rest, followed by a space char and the first extracted word
			return wordReverse(s.substring(idx + 1)) + " " + s.substring(0, idx);
		}
	}

	/*
	Given a non-negative int n, and a target digit, return the count of the occurrences of the target digit.
	So for example when n is 8218, and target digit is 8, the program shall return 2. Do not use iterative
	 (loop) approach but recursive algorithm.
	Hint: mod (%) by 10 yields the rightmost digit ( 912 % 10 is 2), while divide (/) by 10 and apply parseInt
	on its result removes the rightmost digit ( parseInt(587 / 10) is 58 )
	 */
	public int digitOccurance(int digit, int target) {

		if (digit == 0) {
			return 0;
		}

		if (digit % 10 == target) {
			return 1 + digitOccurance(digit / 10, target);
		}

		return digitOccurance(digit / 10, target);
	}

	//sum Natural numbers

	public int sumNaturalNumbers(int n){
		System.out.println(n);

		if(n == 0){
			return 0;
		}

		return n + sumNaturalNumbers(n-1);
	}

	//multiply a * b
	public int mutliply(int a ,int b){
		if(a == 0) return 0;
		if(a == 1) return b;

		return b + mutliply(--a,b);

	}


	//Binary Search Sorted Array

	public int findElementBinarySearch(int[] arr,int target){
		if(arr == null || arr.length ==0){
			return 0; //error
		}

		return findElementBinarySearchUtil(arr,0,arr.length - 1,target);

	}

	public int findElementBinarySearchUtil(int[] arr , int low , int end, int target){

		if(low > end){
			return low; // not found
		}

		int mid = (end + low) / 2 ;

		if(arr[mid] == target)
			return mid;

		if(target < arr[mid]){
			return findElementBinarySearchUtil(arr,0,mid-1,target);
		}
		else {
			return findElementBinarySearchUtil(arr,mid+1,end,target);
		}

	}

	//Quick Sort


	//Merge Sort


}
