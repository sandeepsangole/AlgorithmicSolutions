package personal;

/**
 * Created by ctsuser on 11/20/16.
 */
import java.util.*;

public class StrUniqueChars {

public static void main(String args[])
{
    StrUniqueChars fn = new StrUniqueChars();
    System.out.print(fn.charCount("sandeepdeepali"));
    System.out.print(fn.isUniqueChars("sandeep"));
    System.out.print(fn.isUniqueCharsHashSet("sandeep"));

}

    public Map charCount(String str)
    {
        char[] charArray = str.toCharArray();
        int count = 0;
        boolean result = true;

        Map<Character ,Integer> map = new HashMap<Character,Integer>();

        for(char ch : charArray)
        {
            if(map.containsKey(ch))
            {
                count = map.get(ch) + 1;
                map.put(ch,count);
            }
            else
            {
                map.put(ch,0);
            }
        }
        return map;
    }

public boolean isUniqueChars(String str)
{
    char[] charArray = str.toCharArray();
    int count = 0;
    boolean result = true;

    Map<Character ,Integer> map = new HashMap<Character,Integer>();

    for(char ch : charArray)
    {
        if(map.containsKey(ch))
        {
            result = false;
        }
        else
        {
            map.put(ch,count);
        }
    }
    return result;
}

    public boolean isUniqueCharsHashSet(String str)
    {
        char[] charArray = str.toCharArray();
        int count = 0;
        boolean result = true;

       Set<Character> set = new HashSet<Character>();

        for(char ch : charArray)
        {
            if(set.add(ch)){

            }
                else
                    result=false;
        }
        return result;
    }
}
