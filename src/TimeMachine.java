import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;

public class TimeMachine {

	public static void main(String[] args) {
	TimeMachine m = new TimeMachine();
		m.sorting();
		/*//year we want to check
		int           year = 2016;
		DecimalFormat df   = new DecimalFormat("00");
		Calendar      cal  =Calendar.getInstance();
		cal.set(Calendar.YEAR,year);

		if(year == 1918){
			cal.set(Calendar.DAY_OF_YEAR,0);
			cal.add(Calendar.DAY_OF_YEAR, 256 + 13);

		}
		else
		{
			cal.set(Calendar.DAY_OF_YEAR,0);
			cal.add(Calendar.DAY_OF_YEAR, 256);

		}

		System.out.print(df.format(cal.get(cal.DATE))+"."+df.format(cal.get(Calendar.MONTH)+1 )+"."+cal.get(Calendar.YEAR));
*/

	}

	public void sorting(){

		String[] unsorted = new String[]{"6","31415926535897932384626433832795","1","3","10","3","5"};

		BigInteger[] bigInt = new BigInteger[unsorted.length];
		int i= 0;

		for(String str:unsorted){
			bigInt[i] = new BigInteger(str);
			i++;
		}
		Arrays.sort(bigInt);
		System.out.println(Arrays.toString(bigInt));
	}
}
