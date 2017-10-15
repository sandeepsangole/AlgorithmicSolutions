package personal.temp;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringPermutation {

    public List<String> permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        String test = "bbbababaaabbbb";
        List<Integer> unsortList = new ArrayList<Integer>();
        permuteUtil(str, count, result, 0, resultList);
        for(String res : resultList)
        {
            Pattern pat = Pattern.compile(res);

            countStringOccurrences(test, res,unsortList);


        }

        Object[] sortedNames = unsortList.stream().sorted(Integer::compareTo).toArray();

        System.out.println( Arrays.toString(sortedNames));
        return resultList;
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

    public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {

        if (level == result.length) {
            resultList.add(new String(result));
           // System.out.println("Reached final level"+resultList.toString());
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;

        }
    }

    private void printArray(char input[]) {
        for(char ch : input) {
            System.out.print(ch);
        }
        System.out.println();
    }

     public static void main(String args[]) {
        StringPermutation sp = new StringPermutation();
        sp.permute("aaba".toCharArray()).forEach(s -> System.out.println(s));
    }
}
//ABC//
//DFJDSHKFJHCSKAASDDBSSSCSDABSDC
//11,19
//14,19


