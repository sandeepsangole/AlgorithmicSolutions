package hackton;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		int n = 4;
		int k = 3;
		long a[] = { 1, 7, 2, 4, 6, 7, 8, 15, 30, 70, 100 };
		
		Set<Long> subset = new HashSet<Long>();

		for (int i = 0; i < a.length; i++) {
			boolean isEligible = true;
			if(subset.size() ==0)
				subset.add((long)a[i]);
			
			else{
				for (Long s : subset) {
					if((s + (int)a[i]) %k ==0)
					{
						isEligible = false;
					}
				}
				if(isEligible)
					subset.add((long)a[i]);
					
			}
			

		}

		for (Long s : subset) {
			System.out.println(s);
		}
	}
}
