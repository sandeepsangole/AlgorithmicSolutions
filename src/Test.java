import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		/*Test t = new Test();
		t.computeDifference();*/

		String Str = new String("1234");

		System.out.print("Return Value :" );
		System.out.println(Str.substring(0,1) );
		System.out.println(Str.substring(1,2) );


	}




void computeDifference()
{
	int[] elements ={8 ,19, 3 ,2, 7};
	Arrays.sort(elements);
	 int maxDiff = 0;
	maxDiff = elements[elements.length -1] - elements[0];
	
  
   /*for(int i =0;i< elements.length ;i++)
       {
	   for(int j =0;i< elements.length;i++)
	   {
         if(i !=j)
         {
			   int diff = elements[i]-elements[j];
	           if(maxDiff < diff)
	           {
	              maxDiff = diff;
	          }
         }
	   }
   }*/
   
   System.out.println("maxDiff " +maxDiff);
}

}
