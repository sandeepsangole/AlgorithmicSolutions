package Arrays;

/**
 * Created by sandeep on 9/11/2017.
 */
public class NumberToStringCurrency {

    public static void main(String args[]){
            System.out.println(numberToWords(995500050));
    }

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                System.out.println("Words : "+words +" num : "+num);
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num = num / 1000;
            i++;
        }

        return words.trim();
    }

    private static String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }


}
