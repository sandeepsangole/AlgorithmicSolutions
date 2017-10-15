package Arrays;

import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Friends {
	static  Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

	public static void main(String args[]) {
		Friends f            = new Friends();
		int     totalFriends = 5;


		f.buildFriendShip(1,2);

		int first = map.get(1).size() +  map.get(2).size();
		System.out.print(" first : "+first);
		f.buildFriendShip(3, 2);

		int second = map.get(1).size()+map.get(3).size() +  map.get(2).size();
	  System.out.print(" second : "+second);

		/*f.buildFriendShip(4, 2);
		int three =map.get(1).size()+map.get(3).size()+ map.get(4).size() + map.get(2).size();

		System.out.print(" three : " + three);
		f.buildFriendShip(4, 3);
		int four = map.get(1).size()+map.get(3).size()+ map.get(4).size() + map.get(2).size();
	System.out.print(" four : " + four);

		int total = first + second +three + four;
		System.out.print("total : " + total);*/

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}

		//map.forEach(k,v)->System.out.print("Key :"+k +"Value :"+v);
	}

	public Map<Integer, List<Integer>> buildFriendShip(Integer first, Integer second) {

		if(!map.containsKey(first)){
			map.put(first,new ArrayList<Integer>());
		}

		if(!map.containsKey(second)){
			map.put(second,new ArrayList<Integer>());
		}

		if (!map.get(first).contains(second))
			map.get(first).add(second);

		if (!map.get(second).contains(first))
			map.get(second).add(first);

		//Step 1 - add friends first time

		List<Integer> firstFriend = map.get(first);

		for (Integer i : firstFriend){
			if(i.equals(second)) continue;
			map.get(i).add(second);

		}

		List<Integer> secondFriend = map.get(second);

		for (Integer j : secondFriend) {
			if(j.equals(first)) continue;
			map.get(j).add(first);
		}

		return map;
	}

}
/*

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


     static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int total = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();

            for(int j=1;j<=n;j++){
                map.put(j,new ArrayList<Integer>());
            }

            int m = in.nextInt();
            for(int a1 = 0; a1 < m; a1++){
                int x = in.nextInt();
                int y = in.nextInt();
                sol.buildFriendShip(x,y);
                set.add(x);set.add(y);
                for(Integer no : set){

                    total = total + map.get(no).size();
                }
            }

            System.out.print(total);

        }
    }

    public  static void buildFriendShip(Integer first, Integer second) {

         if (!map.get(first).contains(second))
			map.get(first).add(second);

		if (!map.get(second).contains(first))
			map.get(second).add(first);


		List<Integer> firstFriend = map.get(first);

		for (Integer i : firstFriend) {
			if (i == second || i == first) continue;

			if (!map.get(i).contains(second))
				map.get(i).add(second);
			if (!map.get(second).contains(i))
				map.get(second).add(i);

		}

		List<Integer> secondFriend = map.get(second);

		for (Integer j : secondFriend) {
			if (j == second || j == first) continue;
			if (!map.get(j).contains(first))
				map.get(j).add(first);
			if (!map.get(first).contains(j))
				map.get(first).add(j);

		}


	}
}

 */