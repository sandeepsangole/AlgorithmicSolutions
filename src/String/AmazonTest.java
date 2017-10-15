package String;

public class AmazonTest {

	public static void main(String args[]) {
		AmazonTest obj = new AmazonTest();
		System.out.println(obj.totalScore(new String[] { "5", "-2", "4", "Z", "X", "9", "+", "+" }, 8));
	}

	public int totalScore(String[] arr, int length) {

		String str = "ZX+";
		int    cs  = 0;
		int    ps  = 0;
		int    ts  = 0;
		for (int i = 0; i < arr.length; i++) {

			String temp = arr[ i ];


			switch (temp) {
				case "X":
					cs = ps * 2;
					ts = ts + cs;
					// ps = cs;
					break;
				case "+":
					int cstemp = cs;
					cs = cs + ps;
					ps = cstemp;
					ts = ts + cs;
					break;
				case "Z":
					ts = ts - cs;
					cs = ps;
					break;
				default:
					ps = cs;
					cs = Integer.parseInt(temp);
					ts = ts + cs;
			}

		}
		return ts;
	}


}
