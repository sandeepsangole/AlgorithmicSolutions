import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SolutionTemp {

	Stack st = new Stack();
	Queue qu = new LinkedList();
	
	public void pushCharacter(char ch)
	{
		st.push(ch);
		System.out.println(st.toString());
	}
	
	public char popCharacter()
	{
		return (char) st.pop();
	}

	public void enQueue(char ch)
	{
		qu.offer(ch);
		System.out.println("Queue :"+qu.toString());
	}
	
	public char deQueue()
	{
		return (char) qu.remove();
	}
	
    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        String input = "ritika";
       // scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        SolutionTemp p = new SolutionTemp();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            //p.`x(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            //if (p.popCharacter() != p.dequeueCharacter()) {
              //  isPalindrome = false;
                //break;
            //}
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }



	
}


