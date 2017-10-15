package hackton;

public class Triplet {

	public static void main(String[] args) {
		
		int a0 = 5;
		int a1 = 6;
		int a2 = 7;
		int b0 = 3;
		int b1 = 6;
		int b2 =10 ;
		
		int[] alice = new int[3];
        int[] bob = new int[3];
        
        int aliceCount =0;
        int bobCount =0;
        
        if((a0 > 0 && a0 <= 100) || (b0 > 0 && b0 <= 100))
        {
            if(a0 > b0)
            {
                alice[0]=1;
            }
            else if(b0 > a0){
                bob[0]=1;
            }
            else{
                alice[0]=0;bob[0]=0;
            }
           
        }
        
        if((a1 > 0 && a1 <= 100) || (b1 > 0 && b2 <= 100))
        {
            if(a1 > b1)
            {
                alice[1]=1;
            }
            else if(b1 > a1){
                bob[1]=1;
            }
            else{
                alice[1]=0;bob[1]=0;
            }
           
        }
        
        if((a2 > 0 && a2 <= 100) || (b2 > 0 && b2 <= 100))
        {
             if(a2 > b2)
            {
                alice[2]=1;
            }
            else if(b2 > a2){
                bob[2]=1;
            }
            else{
                alice[2]=0;bob[2]=0;
            }
           
        }
        
          for (int i=0; i<alice.length; i++)
        {
          aliceCount = aliceCount + alice[i];
        }
        for (int i=0; i<bob.length; i++)
        {
          bobCount = bobCount + bob[i];
        }
        
        System.out.print(aliceCount+" "+bobCount);
     

	}

}
