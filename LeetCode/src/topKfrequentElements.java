
/*
 *    Nachiket Trivedi
 *    San Jose
 */
import java.util.*;
import java.io.*;
public class topKfrequentElements 
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
		int k=in.nextInt();		
		System.out.println(topKFrequent(ar,k));
		//-----The End----
	}
 
	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> h1=new HashMap<Integer, Integer>();
        TreeMap<Integer, List<Integer>> t1=new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++)
        {
            if(!h1.containsKey(nums[i]))
                h1.put(nums[i],1);
            else
                h1.put(nums[i],h1.get(nums[i])+1);
        }
        
        Set set = h1.entrySet(); 
        Iterator i = set.iterator(); 
        while (i.hasNext()) { 
            Map.Entry me = (Map.Entry)i.next(); 
            Integer key=(Integer)me.getKey();
            Integer value=(Integer)me.getValue();
            if(!t1.containsKey(value))
            {
                List<Integer> l1=new ArrayList<Integer>(); 
                l1.add(key);
                t1.put(value,l1);
            }
            else
            {
            	List<Integer> l2=t1.get(value);
            	l2.add(key);
                t1.put(value,l2);
            }
        } 
        
        List<Integer> ans=new ArrayList<Integer>(); 
        Set tset = t1.entrySet(); 
        Iterator ti = tset.iterator(); 
        while (ti.hasNext()) { 
            Map.Entry me = (Map.Entry)ti.next(); 
            Integer key=(Integer)me.getKey();
            List<Integer> value=(List<Integer>) me.getValue();
            System.out.println(key);
            System.out.println(value);
            int j=0;
            if(ans.size()==2)
                break;
            if(value.size()<=k)
            {
                int vsize=value.size();
                while(vsize-->0)
                {
                    ans.add(value.get(j++));
                }
                k=k-j;
            }
            else
            {
                while(ans.size()<k)
                {
                    ans.add(value.get(j));
                } 

            }
        } 
        return ans;
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