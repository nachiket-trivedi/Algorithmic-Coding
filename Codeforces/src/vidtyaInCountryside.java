/*
 *    Nachiket V Trivedi
 *    DAIICT
 */
import java.util.*;
import java.io.*;
public class vidtyaInCountryside 
{
	public static void main(String[] args) 
	{
		InputReader in=new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out=new PrintWriter(outputStream);//out.println() to print 
		//-----Code starts from here-----
		int n=in.nextInt();
		
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			
		}
		if(ar.length==1 & (ar[0]==0 ))
			System.out.println("UP");
		else if(ar.length==1 & (ar[0]==15))
				System.out.println("DOWN");
		else if(ar.length==1 & ar[0]!=0 & ar[0]!=15)
			System.out.println("-1");
		else if(ar.length>1 & ar[n-1]-ar[n-2]>0 & ar[n-1]==15)
			System.out.println("DOWN");
		else if(ar.length>1 & ar[n-1]-ar[n-2]>0 & ar[n-1]!=15)
			System.out.println("UP");
		else if(ar.length>1 & ar[n-1]-ar[n-2]<0 & ar[n-1]!=0)
			System.out.println("DOWN");
		else if(ar.length>1 & ar[n-1]-ar[n-2]<0 & ar[n-1]==0)
			System.out.println("UP");
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