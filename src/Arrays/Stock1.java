package Arrays;



public class Stock1 {

	public static void main(String args[]) {
		Stock1 obj = new Stock1();
		System.out.println(obj.maxProfit(new int[] { 20,22,16,41,32}));
	}


	public int maxProfit(int[] prices) {
		if(prices==null||prices.length<=1)
			return 0;
		int min=prices[0]; // min so far
		int result=0;
		for(int i=1; i<prices.length; i++){
			result = Math.max(result, prices[i]-min);
			min = Math.min(min, prices[i]);
		}
		return result;
	}
}
