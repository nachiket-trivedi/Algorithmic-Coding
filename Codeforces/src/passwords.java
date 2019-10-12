/*
 *    Nachiket V Trivedi
 *    DAIICT
 */
import java.util.*;
import java.io.*;
import java.math.*;
public class passwords 
{
	public static void main(String[] args) 
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream); 
		//------Start-----
		int n=in.nextInt();
		int k=in.nextInt();
		TreeMap<Integer, ArrayList<String>> tm=new TreeMap();
		for(int i=0;i<n;i++)
		{
			ArrayList ar;
			String s=in.next();
			if(!tm.containsKey(s.length()))
			{
				ar=new ArrayList();
				ar.add(s);
				tm.put(s.length(), ar);
			}
			else
			{
				ar=new ArrayList();
				ar=tm.get(s.length());
				ar.add(s);
				tm.put(s.length(), ar);
			}
		}
		
		String pwd=in.next();
		int n1=pwd.length();
		int min=0,max=0;
		for(int a:tm.keySet())
		{
			if(n1!=a )
			{
				min+=tm.get(a).size();
				max+=tm.get(a).size();
			}
			else if(n1==a )
			{
				/*for(int i=0,j=(tm.get(a).size()-1);j>=0 & i<=(tm.get(a).size()-1);i++,j--)
				{
					ArrayList br=tm.get(a);
					String b1=(String) br.get(i);
					String c1=(String) br.get(j);
					if(!b1.equals(pwd))
						min++;
					else if(b1.equals(pwd))
					{
						break;
					}
					if(!c1.equals(pwd))
						max++;
					else if(c1.equals(pwd))
						break;
 
				}*/
				max+=tm.get(a).size();
				min++;
				int q1=(min-1)/k*5;
				int q2=(max-1)/k*5;
 
				out.println((q1+min)+" "+(q2+max));
			}
		
 
		}
		//-----The End----
		out.close();
	}
	//start writing new static method here
 
 
	//My template methods are here--------------------------------------------------
	static long modRecursion(long a, long b, long c)// calculates (a^b)%c
	{
		if(b == 0)
			return 1;
		if(b == 1)
			return a%c;
		else if( b%2 == 0)                                           //if b is even
		{
			return modRecursion((a *a)%c,b/2,c);
		}
		else                                                                    // if b is odd.
		{
			return (a*modRecursion((a*a%c),b/2,c))%c;
		}
	}
	static boolean isPrime(int num)
	{
		if (num < 2) return false;
		if (num == 2) return true;
		if (num % 2 == 0) return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) return false;
		return true;
	}
	static int findGCD(int number1, int number2) 
	{
		if(number2 == 0)
			return number1; 			
		return findGCD(number2, number1%number2); 
	}
	static void debug(Object... o)// to print any object like an array 
	{
		System.out.println(Arrays.deepToString(o));
	}
	static public ArrayList<ArrayList<Integer>> FindAllsubsets(int[] S)//2^n complexity 
	{
		if (S == null)
			return null;
		Arrays.sort(S);	 
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	 
		for (int i = 0; i < S.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			//get sets that are already in result
			for (ArrayList<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}	 
			//add S[i] to existing sets
			for (ArrayList<Integer> a : temp) {
				a.add(S[i]);
			}	 
			//add S[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(S[i]);
			temp.add(single);	 
			result.addAll(temp);
		}	 
		//add empty set
		result.add(new ArrayList<Integer>());	 
		return result;
	}
	static int greatestIndexNotExceeding(int[] data, int limit, int lb, int ub) 
	{
		final int mid = (lb + ub) / 2;
		// Need to go lower but can't
		if (mid == lb && data[mid] > limit) 
			return -1;		
		// Found a candidate, and can't go higher
		if (data[mid] <= limit && (mid == ub || data[mid + 1] > limit)) 
			return mid;		
		if (data[mid] <= limit) 
			// Consider upper half
			return greatestIndexNotExceeding(data, limit, mid + 1, ub);
		else
			// Consider lower half
			return greatestIndexNotExceeding(data, limit, lb, mid);
	}
 
	//Pair class is here
	static class Pair implements Comparable<Pair>
	{
		long u;
		long v;
		BigInteger bi;
		public Pair(long u, long v) {
			this.u = u;
			this.v = v;
		}
 
 
		public int hashCode() {
			int hu = (int) (u ^ (u >>> 32));
			int hv = (int) (v ^ (v >>> 32));
			return 31 * hu + hv;
		}
 
		public boolean equals(Object o) {
			Pair other = (Pair) o;
			return u == other.u && v == other.v;
		}
 
		public int compareTo(Pair other) {
			return Long.compare(u, other.u) != 0 ? Long.compare(u, other.u) : Long.compare(v, other.v);
		}
 
		public String toString() {
			return "[u=" + u + ", v=" + v + "]";
		}
	}
	//InputReader class starts from here--------------------------------------------------------------
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
 
//---------------------------------------------------------------