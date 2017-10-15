import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REgExp {

	static Matcher mat = null;
	
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[a-z]+@gmail.com");
		String firstName = "Sandeep";
		String emailID = "sandeepsangole@gmail.com";
		ArrayList<String> lst = new ArrayList<String>(); 
        int count = 0;
        
		mat = p.matcher(emailID);
		
		if(mat.matches()) {
			lst.add(firstName);
            count++;
        }
		
		Collections.sort(lst);

	}

}
