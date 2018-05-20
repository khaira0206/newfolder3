
public class isUnique {
	
	public boolean  isUnique(String str)
	{
		if(str.length()>128)
			return false;
	  boolean[] char_set = new boolean[128];
		for(int i=0; i < str.length(); i++)
		{
			int val = str.charAt(i);
			System.out.println(val);
			if(char_set[val])
				return false;
			char_set[val] = true;
		}
		
		return true;
	}
	
	boolean permutation1(String s, String t)
	{
		if(s.length()!= t.length())
 		{
 			return false;
 		}
 		
 		int[] letters = new int[128];
 		
 		for(int i = 0; i < s.length(); i++)
 		{
 			//letters[s.charAt(i)]++;
 			System.out.println(++letters[s.charAt(i)]);	
 		}
 		
 		for(int i = 0; i < t.length(); i++)
 		{
 			System.out.println(--letters[t.charAt(i)]);
 			if(letters[t.charAt(i)]<0)
 			{
 				return false;
 				
 			}
 		}
		return true;
	}
	
	
	public String replace(char[] s , int truelength)
	{
		int spacecount = 0;
		char[] string = new char[21];
		for(int i = 0; i < truelength; i++)
		{
			if(s[i] == ' ')
			{
				spacecount++;
			}
			
		}
		if(s.length > truelength)
			s[truelength] = '\0';
		int index = truelength + 2 * spacecount;
		
		for(int i = truelength-1; i >= 0; i-- )
		{
		if(string[i]== ' ')
		{
			string[index-1]='0';
			string[index-2]='2';
			string[index-3]='%';
			index = index - 3;
		}
		else
		{
			string[index - 1] = string[i];
			index--;
		}
			
		}
		for(int i = 0; i < string.length; i++)
		System.out.println(string[i]);
		return string.toString();
	}

	public static void main(String args[])
	{
		isUnique str = new isUnique();
		//System.out.println(str.isUnique("heloZ")?"made of unique char":"not made of unique char");
		//System.out.println(str.permutation1("kajan", "karan")?"string is perm of the other one":"string is not perm of the other one");
		String s = "I Love You  ";
		String hell = str.replace(s.toCharArray(), 12);
		
	}
}

