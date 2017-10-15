package Arrays;


import java.util.*;

public class ArrayJumps {

	public static void main(String args[]){


		List<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(4);
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(6);
		list.add(9);
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);


		System.out.println(arrayJumps(list));

	}

	public static int arrayJumps(List<Integer> list){

		int count = 0;

		for(int i=0;i<list.size();)
		{

			if(list.get(i) == 0){
				return -1;
			}

			count ++;
			i = i + list.get(i);
		}

		return count;
	}
}