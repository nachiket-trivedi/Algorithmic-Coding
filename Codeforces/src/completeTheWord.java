
/*
 *    Nachiket V Trivedi
 *    DAIICT
 */
import java.util.*;
import java.io.*;
public class completeTheWord 
{
	public static void main(String[] args) 
	{
		InputReader in=new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out=new PrintWriter(outputStream);//out.println() to print 
		//-----Code starts from here-----
		String str=in.next();
		boolean flag=false;
		int index =-1;
		char[]abc1=null;
		for(int i=0;i<=str.length()-26;i++)
		{
			String abc=str.substring(i,i+26);
			int qcount=0;
			HashMap<Character, Integer> hm=new HashMap();
			for(int j=0;j<abc.length();j++)
			{
				if(abc.charAt(j)!='?')
				{
					if(!hm.containsKey(abc.charAt(j)))
					{
						hm.put(abc.charAt(j),1);
					}
					else
					{
						qcount=-1;
						break;
					}
				}
				else
				{
					qcount++;
				}
			}
			if(qcount!=-1 & (26-hm.size())>=qcount)
			{
				char[] cr=new char[26-hm.size()];
				int k=0;
				
				for(char i1=0;i1<26;i1++)
				{
					if(!hm.containsKey((char)(i1+65)))
					{
						cr[k]=(char)(i1+65);
				
						k++;						
					}
				}
				
				abc1=abc.toCharArray();
				int k1=0;
				for(int j=0;j<abc.length();j++)
				{
					if(abc1[j]=='?')
					{
						abc1[j]=cr[k1];
						k1++;
					}
				}
				flag=true;
				index=i;
				
				break;
			}
		}
		if(flag==false)
			System.out.println("-1");
		else
		{
			for(int i=0;i<index;i++)
			{
				if(str.charAt(i)=='?')
					System.out.print('A');
				else
					System.out.print(str.charAt(i));
			}
			for(int i=0;i<26;i++)
			{
				System.out.print(abc1[i]);
			}
			for(int i=index+26;i<str.length();i++)
			{
				if(str.charAt(i)=='?')
					System.out.print('A');
				else
					System.out.print(str.charAt(i));
			}
		}
		
		//-----The End----
	}
 
	
	//InputReader class starts from here
	public static class InputReader 
	{
		public BufferedReader reader;
		public StringTokenizer tokenizer;
 
		public InputReader(InputStream inputstream) 
		{
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}
 
		public String nextLine()
		{
			String fullLine=null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) 
			{
				try
				{
					fullLine=reader.readLine();
				} 
				catch (IOException e) 
				{
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}
		public String next() 
		{
			while (tokenizer == null || !tokenizer.hasMoreTokens()) 
			{
				try 
				{
					tokenizer = new StringTokenizer(reader.readLine());
				}
				catch (IOException e) 
				{
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public long nextLong() 
		{
			return Long.parseLong(next());
		}
		public int nextInt() 
		{
			return Integer.parseInt(next());
		}
	}
 
}