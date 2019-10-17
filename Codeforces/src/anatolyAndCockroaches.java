import java.util.*;
import java.io.*;
public class anatolyAndCockroaches 
{
	public static void main(String[] args) 
	{
		InputReader in=new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out=new PrintWriter(outputStream);//out.println() to print 
		//-----Code starts from here-----
		int n=in.nextInt();
		String str=in.next();
		
		StringBuilder r1=new StringBuilder();
		StringBuilder b1=new StringBuilder();
		boolean flag=true;
		for(int i=0;i<n;i++)
		{
			if(flag==true)
			{
				r1.append("r");
				b1.append("b");
			}
			else
			{
				r1.append("b");
				b1.append("r");
			}
			flag=!flag;
		}
		int rcount=0,bcount=0, rrincount=0, rbincount=0, brincount=0, bbincount=0;
		for(int i=0;i<n;i++)
		{
			if(str.charAt(i)!=r1.charAt(i))
				{
				rcount++;
				if(str.charAt(i)=='r')
					rrincount++;
				else
					rbincount++;
				}
			if(str.charAt(i)!=b1.charAt(i))
				{
				bcount++;
				if(str.charAt(i)=='r')
					brincount++;
				else
					bbincount++;
				}
		}
		System.out.println(Math.min(Math.max(rrincount, rbincount), Math.max(brincount, bbincount)));
		//-----The End----
		out.close();
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
		private static boolean isPrime(int num) {
			if (num < 2) return false;
			if (num == 2) return true;
			if (num % 2 == 0) return false;
			for (int i = 3; i * i <= num; i += 2)
				if (num % i == 0) return false;
			return true;
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