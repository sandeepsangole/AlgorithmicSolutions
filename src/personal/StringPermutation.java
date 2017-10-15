package personal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ctsuser on 11/19/16.
 */
public class StringPermutation {

    public static void main(String args[])
    {

        String str1 = "agbc";
        String str2 = "bacg";
        StringPermutation p = new StringPermutation();
       p.findIndexOfAnagram("ab","abghjbadfghab");

    }


    public void findIndexOfAnagram(String anagram,String mainStr)
    {

        int len = mainStr.length() - anagram.length();
        System.out.println("Len :"+len);
        int count =0;
        for(int i=0;i<=len;i++)
        {
            count = i + anagram.length();
            String subStr =  mainStr.substring(i,count);
            //System.out.println("count :"+count);
            if(isPermutation(subStr,anagram)) {
                System.out.print(i);
            }

        }
    }

    public boolean isPermutation(String str1, String str2)
    {
        if(str1.length() != str2.length()){
            return false;
        }

        char[] str1CArray = str1.toCharArray();
        char[] str2CArray = str2.toCharArray();
        Arrays.sort(str1CArray);
        Arrays.sort(str2CArray);

        return Arrays.equals(str1CArray,str2CArray);


    }

    public void permutations(String prefix, String str, List<String> result) {

        int len = str.length();
        if (len == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < len; i++) {
                //Looks for first occurance of char from given index
                if(str.indexOf(str.charAt(i),i+1) != -1)
                    continue;
                permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len), result);
            }
        }

    }
}
