package hackton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Quadruples {

	public static void main(String[] args) {
		int A = 1150;
		int B =1547;
		int C =853;
		int D = 423;
		//1150 1547 853 423
		
		
		int[] a1 = new int[A]; 	
		int[] b1 = new int[B]; 
		int[] c1 = new int[C]; 
		int[] d1 = new int[D]; 
		
		a1 = getArray(a1,A);
		b1 = getArray(b1,B);
		c1 = getArray(c1,C);
		d1 = getArray(d1,D);
		
		
		
		
		Set<Integer> set = new HashSet<Integer>();
		int[] temp = new int[4];
		StringBuilder sb = null;
		for(int i = 0;i<a1.length;i++)
		{
			for(int j = 0;j<b1.length;j++)
			{
				for(int k = 0;k<c1.length;k++)
				{
					for(int l = 0;l< d1.length;l++)
					{
						
						
						
						int birOr =a1[i]^b1[j]^c1[k]^d1[l];
					
						if( birOr != 0)
						{
							//System.out.println(a1[i]+""+b1[j]+""+c1[k]+""+d1[l] +" ");
							//System.out.println(a1[i]^b1[j]^c1[k]^d1[l]);
							
							 temp[0] = a1[i];
							 temp[1] = b1[j];
							 temp[2] = c1[k];
							 temp[3] = d1[l];
							 Arrays.sort(temp);
							 
							 sb = new StringBuilder(); 
							 sb = sb.append(temp[0]).append(temp[1]).append(temp[2]).append(temp[3]);
							 set.add(Integer.parseInt(sb.toString()));
							 
						}
						
					}
				}
			}
		}
		System.out.println(set.size());
		
		/*List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		
	
		for(Integer no : list)
		{
			System.out.println(no);
		}*/
		
		

	}
	
	public static int[] getArray(int[] a1 , int no)
	{
		int count = 1;
		for(int i = 0;i< no;i++)
		{	
			a1[i] = count;
			count++;
		}
		return a1;
	}

}
