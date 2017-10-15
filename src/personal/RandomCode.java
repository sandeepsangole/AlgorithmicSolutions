package personal;

/**
 * Created by ctsuser on 11/11/16.
 */
public class RandomCode
{
    public static void main(String args[])
    {
        int randomCode  = (int)(Math.random()*9000)+1000;
        System.out.println(randomCode);
        for(int i =0;i< 1000;i++)
        System.out.println((int)(Math.random()*9000)+1000);
    }
}
