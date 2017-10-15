import java.util.*;

public class PrimeNumbers {

	public static void main(String args[]) {
		PrimeNumbers p = new PrimeNumbers();
		//p.isPrime();
		p.primes(77,100);
	}

	public static boolean isPrime(long no) {
		int[] primeBelow10 = new int[] { 2, 3, 5, 7 };

		boolean isPrime = true;
		while (no > 0) {
			boolean found = false;
			long temp = (no % 10);
			for (int t : primeBelow10) {
				if(t == temp)
				found = true;
			}
			if(found == false) {
				//System.out.println("is not Prime");
				isPrime = false;
					break;
			}

			no = no / 10;
		//	System.out.println(no);
		}
	return isPrime;
	}

	public static Set<Long> primes(long from,long to) {
		Set<Long> primes = new HashSet<Long>();
		primes.add(new Long(2));
		primes.add(new Long(3));
		primes.add(new Long(5));
		primes.add(new Long(7));


		for (long n = from; n<to;n += 2) {

			boolean prime = true;

				for (Long j : primes) {
					Long top = j * j;
					if (n >= top) {
						//System.out.println("j(prime): " + j + "; i(test): " + n + "; Top: " + top);
						if ((j != 0) && (n % j == 0)) {
							prime = false;
							break;
						}

					} else {
						break;
					}

				}

			if (prime) {
				//System.out.println(n);
				primes.add(n);
			}
		}

		for(long n : primes) {
			if (!isPrime(n)) {
				primes.remove(n);
			}
		}

		//System.out.println(Arrays.asList(primes));
		//System.out.println(primes.size());
		return primes;
	}


}

