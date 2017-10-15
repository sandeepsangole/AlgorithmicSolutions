package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StringAnagram {
	private static void anagram_search(char txt[],char pat[])
	{
		HashMap<Character,Integer> hm1 = new HashMap<>();
		HashMap<Character,Integer> hm2 = new HashMap<>();

		int m = txt.length;
		int np = pat.length;
		int i,j=0;
		int flag=0;
		int countpat[]= new int[26];

		for( i=0;i<np;i++)
		{
			if(hm1.containsKey(pat[i]))
				hm1.put(pat[i],hm1.get(pat[i])+1);
			else
				hm1.put(pat[i],1);
		}

		i=0;
		while(i<(m-np+1))
		{
			//  int k=0;
			//int counttxt[]= new int[26];
			for( j=i;j<=(i+np-1);j++)
			{

				if(hm2.containsKey(txt[j]))
					hm2.put(txt[j],hm2.get(txt[j])+1);
				else
					hm2.put(txt[j],1);
			}

			//final Map<Character, Integer> hm3 = new HashMap<Character, Integer>();
			int valpat ,valtxt ;
			flag=0;
			for (final Character key1 : hm1.keySet()) {
				if (hm2.containsKey(key1)) {
					valpat = hm1.get(key1);
					valtxt=  hm2.get(key1);
					if(valpat!=valtxt)
					{
						flag=0;
						break;
					}
					else
						flag=1;
				}//outer if
				else
				{
					flag=0;
					break;
				}
			}
			if(flag==0)
				i++;
			else
			{
				System.out.println("Pattern found at index "+ i);
				i++;
			}
			for(Character ch :hm2.keySet())
			{
				for(int ii=0;ii< hm2.size();ii++)
				{
					if (hm2.containsKey(txt[ii]))
						hm2.put(txt[ii],0);
				}
			}

		}

	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter input String ");
		String data = br.readLine();
		System.out.println("Enter pattern to be checked ");
		String pattern = br.readLine();


		char txt[]= data.toCharArray();
		char pat[]= pattern.toCharArray();
		anagram_search(txt,pat);
	}

}
