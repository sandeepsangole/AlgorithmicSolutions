package personal;

/**
 * Created by ctsuser on 10/12/16.
 */
public class StringManipulation {

    public static void main(String args[]){
        StringManipulation mp = new StringManipulation();
        mp.manipulateString("SAND");
    }

    void manipulateString(String st)
    {
        System.out.println("Input String : "+st);
        if(st !=null && st.length() == 1)
        {
            System.out.println(st);
        }
        else
        {
            System.out.println(st);
            manipulateString(st.substring(0,st.length()-1));
            System.out.println(st);
        }
    }
}
