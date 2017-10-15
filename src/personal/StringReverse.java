package personal;

/**
 * Created by ctsuser on 11/11/16.
 */
public class StringReverse {
    public static void main(String args[]){

        System.out.print(StringReverse.reverseRecursively("Sandeep"));
    }



    public static String reverseRecursively(String str) {

        System.out.println(str);
        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }


}