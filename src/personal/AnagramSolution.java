package personal;

import java.util.*;

/**
 * Created by ctsuser on 11/15/16.
 */
public class AnagramSolution {


    public static void main(String args[]){

        String mainString = "abghjbadfghab";
        String anagramString="aab";

        char str[] = anagramString.toCharArray();

        int count[] = new int[anagramString.length()];
        char result[] = new char[anagramString.length()];

        int index =0;
        for (char ch : str)
        {
            count[index] = 1;
            index++;
        }
        List<String> resultList = new ArrayList<String>();

        AnagramSolution sol = new AnagramSolution();
        sol.getAnalgrams(str,count,result,0,resultList);
        System.out.print(resultList.toString());

        List<Integer> unsortedList = new ArrayList<Integer>();
        for (String res:resultList)
        {
            getIndexOfOccurance( mainString,res, unsortedList);
        }
Collections.sort(unsortedList);
        System.out.print(unsortedList);
    }

    public static void countStringOccurrences(String text, String pattern,List unsortedList) {


        int i = 0;
        // Keep calling indexOf for the pattern.
        while ((i = text.indexOf(pattern, i)) != -1) {
            // Advance starting index.

            unsortedList.add(i);
            i += pattern.length();


        }

    }

    public static void getIndexOfOccurance(String mainString,String anagram,List<Integer> indexLst)
    {
        //ab
        //asdfabeew

        int fromIndex =0;
        int temp;
        while(fromIndex < mainString.length())
        {
            if((temp = (mainString.indexOf(anagram,fromIndex))) >= 0)
            {
                indexLst.add(temp);
                fromIndex = temp + anagram.length();
                continue;
            }
           break;
            
        }


    }


public  void getAnalgrams(char[] str, int[] count, char[]result , int level, List<String> resultList) {
    if (result.length == level) {
        resultList.add(new String(result));
        return;

    }

    for (int i = 0; i < str.length; i++) {
        if (count[i] == 0) continue;
        result[level] = str[i];
        count[i]--;
        getAnalgrams(str, count, result, level + 1, resultList);
        count[i]++;

    }

}
}
