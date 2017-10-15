package String;

/*
1. Given a numeric string (e.g. “1234”), determine whether or not it is ‘beautiful’. A beautiful string
   meets the following conditions:
    1.  Each element in the sequence is 1 greater than the previous element (e.g. “1 -> 2 -> 3 -> 4”
        or “12 -> 13 -> 14”
    2.  Elements don’t have leading zeroes
    3.  Must be done without rearranging the string.


 */

/*


11 12 13 14

count = 0
end = current + 1
current = str(0,end)
next =str(end +1,(end+1)+end)
                  1 + 1 + 1 = 3
            2

count = 1
end = current + 1
current = str(0,end)
next =str(end +1,(end+1)+end)

count = 2
end = current + 1
current = str(0,end)
next =str(end +1,(end+1)+end)





 */
public class BeautifulString {

	public static void main(String args[]){
		BeautifulString obj = new BeautifulString();
		/*System.out.println(obj.isBeautifulString("1234"));
		System.out.println(obj.isBeautifulString("11121314"));
		System.out.println(obj.isBeautifulString("111112113114"));
		System.out.println(obj.isBeautifulString("123124125126"));
		System.out.println(obj.isBeautifulString("100101102103"));

		System.out.println(obj.isBeautifulString("1235"));
		System.out.println(obj.isBeautifulString("11131214"));
		System.out.println(obj.isBeautifulString("123456780"));*/

		System.out.println(obj.isBeautifulString("1112131415167"));

	}
	public boolean isBeautifulString(String str) {

		boolean isBeautiful = false;

		if (str == null || str.length() == 0 || str.length() == 1) {
			return false;
		}

		int i = 0;
		int j = 1;
		int jumps = 1;
		int counter = 0;
		while(j < str.length()){
			System.out.println(counter++);
			int pre = Integer.parseInt(str.substring(i,j));
			if(j+jumps > str.length()) {
				isBeautiful = false;
				break;
			}
			int curr = Integer.parseInt(str.substring(j,j+jumps));

			if(pre + 1 == curr){
					i = i + jumps;
					j = j + jumps;
				isBeautiful = true;

			}
			else{
				i = 0;
				jumps++;
				j= jumps;
				isBeautiful = false;
			}
			//System.out.println("Prev : "+pre +" Curr "+curr);

		}


		return isBeautiful;
	}
}
