package dp;

public class TempDice
{

	public static void main(String[] args)
	{

		System.out.println(findDiceThrowWay(4, 2, 1)); // 0
		System.out.println(findDiceThrowWay(2, 2, 3)); // 2

		System.out.println(findDiceThrowWay(2, 2, 3));
		System.out.println(findDiceThrowWay(6, 3, 8)); // 21
		System.out.println(findDiceThrowWay(4, 2, 5)); // 4
		System.out.println(findDiceThrowWay(4, 3, 5)); // 6

	}

	public static int findDiceThrowWay(int mFaces, int nDice, int sum)
	{
	//	System.out.println("Dice :"+nDice +"  Sum : "+sum);

		int nways = 0;
		if (sum < 0 || nDice < 0) return 0;

		if (sum == 0 && nDice == 0) return 1;
		for (int i = 1; i <= mFaces; i++)
		{
		//	System.out.println("i :"+i);
			nways += findDiceThrowWay(mFaces, nDice - 1, sum - i);
		}
		return nways;
	}

}