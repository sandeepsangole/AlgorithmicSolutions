public class XOR {

	public static void main(String args[]){
		int a = 1;
		int b = 200;
		int count =0;
		for(int i = 1;i<= b;i++) {
			System.out.println(" i "+i +" b :"+b +"i ^ b :"+(i ^ b));
			if((i ^ b) > b && i < b) {
				count++;
			}
		}

	System.out.print(count);
	}
}
