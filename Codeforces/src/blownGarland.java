
/*
 *    Nachiket V Trivedi
 *    DAIICT
 */
import java.util.*;
import java.io.*;
import java.math.*;
public class blownGarland 
{
 
	public static void main(String[] args) 
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream); 
		//------Start-----
		String str=in.next(),s1,sref="";
		int fl=0;
		for(int i=0;i<str.length();i=i+4){
		if(str.charAt(i)!='!'){
		sref=sref+str.charAt(i);
		fl=1;
		break;
		}
		}
		if(fl==0)sref=sref+'x';
		fl=0;
		for(int i=1;i<str.length();i=i+4){
		if(str.charAt(i)!='!'){
		sref=sref+str.charAt(i);
		fl=1;
		break;
		}
		}
		if(fl==0)sref=sref+'x';
		fl=0;
		for(int i=2;i<str.length();i=i+4){
		if(str.charAt(i)!='!'){
		sref=sref+str.charAt(i);
		fl=1;
		break;
		}
		}
		if(fl==0)sref=sref+'x';
		fl=0;
		for(int i=3;i<str.length();i=i+4){
		if(str.charAt(i)!='!'){
		sref=sref+str.charAt(i);
		fl=1;
		break;
		}
		}
		if(fl==0)sref=sref+'x';
		fl=0;
		// System.out.println(sref);
 
		StringBuilder y=new StringBuilder(sref);
		HashSet<Character> hs=new HashSet<>();
		int index=-1;
		for(int i=0;i<sref.length();i++){
		if(sref.charAt(i)=='x')index=i;
		else hs.add(sref.charAt(i));
		}
		if(index!=-1){
		if(!hs.contains('R'))y.setCharAt(index,'R');
		if(!hs.contains('B'))y.setCharAt(index,'B');
		if(!hs.contains('G'))y.setCharAt(index,'G');
		if(!hs.contains('Y'))y.setCharAt(index,'Y');
		}
		sref=y.toString();
			
		int cr=0,cb=0,cg=0,cy=0;
		for(int i=0;i<4*(str.length()/4);i++)
		{
			if(str.charAt(i)=='R')
				cr++;
			else if(str.charAt(i)=='G')
				cg++;
			else if(str.charAt(i)=='Y')
				cy++;
			else if(str.charAt(i)=='B')
			cb++;				
		}
		
		int rr,rg,rb,ry;
		rr=str.length()/4-cr;
		rg=str.length()/4-cg;
		rb=str.length()/4-cb;
		ry=str.length()/4-cy;		
		int cr1=0,cb1=0,cg1=0,cy1=0,ce1=0;
		
		for(int i=4*(str.length()/4),j=0;i<str.length();i++,j++)
		{
			if(str.charAt(i)=='!')
			{
				if(sref.charAt(j)=='R')
					cr1++;
				if(sref.charAt(j)=='G')
					cg1++;
				if(sref.charAt(j)=='B')
					cb1++;
				
				if(sref.charAt(j)=='Y')
					cy1++;
			}
		
		}
		
			rr+=cr1;
			rg+=cg1;
			rb+=cb1;
			ry+=cy1;
		
		//System.out.println(sref);
			System.out.println(rr+" "+rb+" "+ry+" "+rg);
		/*String base="";
		for(int i=0;;i+=4)
		{
			if(str.length()-si-i<4)
			{
				break;
			}
			base+=s1;
		}
		
		int num=str.length()/4;
		int left=str.length()-1-si+num*4;		
		for(int i=0;i<=str.length()-4;i++)
		{
			char a=str.charAt(i);
			char b=str.charAt(i+1);
			char c=str.charAt(i+2);
			char d=str.charAt(i+3);
			
		}
*/		//-----The End----
		out.close();
	}
	//start writing new static method here
 
 
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
	static long modular_exponentiation(long a, long b, long c)// calculates (a^b)%c
	{
		if(b == 0)
			return 1;
		if(b == 1)
			return a%c;
		else if( b%2 == 0)                                           //if b is even
		{
			return modular_exponentiation((a *a)%c,b/2,c);
		}
		else                                                                    // if b is odd.
		{
			return (a*modular_exponentiation((a*a%c),b/2,c))%c;
		}
	}	
	static int findGCD(int number1, int number2) //complexity O(log(max(n1,n2)))
	{
		if(number2 == 0)
			return number1; 			
		return findGCD(number2, number1%number2); 
	}
	static void extendedEuclid(int A, int B) {
		//gcd(A,B)=Ax+By....this calculates the coefficients...
		//make those variables global and open these comments
		if(B == 0)
		{
			//	        gcd = A;
			//	        x = 1;
			//	        y = 0;	      
		}
		else 
		{	    	
			extendedEuclid(B, A%B);
			//			int temp = x;
			//			x = y;
			//			y = temp - (A/B)*y;	        
		}
	}
	
	static void modInverse(int A, int M)
	{
		//A and M must be coprime for modinverse to exist.
		//If M is prime the call modexponentiation(A,M-2,M)
	    extendedEuclid(A,M);
	    //return (x%M+M)%M;    //this is x of Ax+By=GCD from euclid...x may be negative
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
	//End of My Templates-----------------InputReader class starts from here--------------------------------------------------------------
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
