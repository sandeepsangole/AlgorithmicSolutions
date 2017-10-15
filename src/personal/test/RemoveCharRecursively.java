package personal.test;

public class RemoveCharRecursively {
	public static void main(String args[])
	{
		RemoveCharRecursively r = new RemoveCharRecursively();
		System.out.println(r.removeChar("Sandeep",'e'));
	}

	public String removeChar(String str, char ch)
	{
		int index = str.indexOf(ch);
		if(index == -1)
		{
			return str;
		}

		return removeChar(str.substring(0,index) + str.substring(index+1,str.length()),ch);
	}
}
