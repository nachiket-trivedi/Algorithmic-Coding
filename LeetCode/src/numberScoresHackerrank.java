
/*
 *    Nachiket Trivedi
 *    San Jose
 */
import java.util.*;
import java.io.*;
import java.math.*;
public class numberScoresHackerrank 
{
	public static void main(String[] args) 
	{
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream); 
		//------Start-----
		int n=in.nextInt();
		int score=0;
		if(n%3==0)
			{score+=2;
			System.out.println("3-"+score);
			}
		int nc=n;
		while(nc!=0)
		{
			int di=nc%10;
			if(di==7)
				score+=1;
			if(di%2==0 || di==0)
				score+=4;
			nc=nc/10;
			
		}
		System.out.println("7 and even-"+score);
		ArrayList<Integer> fiveTot=calcFive(n);
		for(int i=0;i<fiveTot.size();i++)
		{
			int counti=fiveTot.get(i);
			if(counti>2)
			{
				int diff=counti-2;
				score+=(diff*3);
			}
			score+=((counti-1)*3);
		}
		System.out.println("5-"+score);
		ArrayList<Integer> oneLess=calcOneLess(n);
		for(int i=0;i<oneLess.size();i++)
		{
			int counti=oneLess.get(i);
			System.out.println("seq count-"+counti);
			score+=(counti*counti);

		}
		System.out.println(score);
		//-----The End----
	}
	//start writing new static method here
	static ArrayList<Integer> calcOneLess(int n)
	{
		int nc=n;
		int count=1;
		ArrayList<Integer> a1=new ArrayList<Integer>();
		boolean flag=false;
		while(nc!=0)
		{
			int d1=nc%10;
			int d2=(nc/10)%10;
			if(d2-d1==1)
			{
				flag=true;
				count++;
				nc=nc/10;
			}
			else 
			{
				if(count>1 && flag)
					a1.add(count);
				flag=false;
				nc=nc/10;
				count=1;
			}
		}
		if(flag==true)
			a1.add(count);
		return a1;
	}
	static ArrayList<Integer> calcFive(int n)
	{
		int nc=n;
		int count=0;
		ArrayList<Integer> a1=new ArrayList<Integer>();
		boolean flag=false;
		while(nc!=0)
		{
			int di=nc%10;
			if(di==5)
			{
				flag=true;
				count++;
				nc=nc/10;
			}
			else 
			{
				if(count>1 && flag)
					a1.add(count);
				flag=false;
				nc=nc/10;
				count=0;
			}
		}
		if(flag==true)
			a1.add(count);
		return a1;
	}
 
	//My template methods are here--------------------------------------------------
	static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
         
        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                System.out.print(i + " ");
        }
    }
	static TreeSet primeFactors(long n)
	{
		TreeSet<Long> ts=new TreeSet();		
		while(n%2==0)
		{		
			ts.add((long)2);
			n=n/2;
		}
		for(long i=3;i<=Math.sqrt(n);i+=2)
		{
			while(n%i==0)
			{
				ts.add(i);
				n=n/i;
			}
		}
		if(n>2)
			ts.add(n);
		return ts;
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