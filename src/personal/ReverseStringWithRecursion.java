package personal;

/**
 * Created by ctsuser on 11/20/16.
 */
public class ReverseStringWithRecursion {
    public static void main(String args[]){

        System.out.print(ReverseStringWithRecursion.reverseMe("Sandeep"));
    }

public static String reverseMe(String str)
{
    System.out.println(str);
    if (str.length() < 1)
    {
        return str;
    }
    return reverseMe(str.substring(1,str.length()))+str.charAt(0);
}
}
