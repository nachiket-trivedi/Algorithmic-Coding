import java.util.*;
public class Result{
    public static int kdiff(int ar[], int k)
    {
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i:ar)
        {
            hs.add(i);
        }
        HashSet<int[]> res=new HashSet<int[]>();
        for(int i=0;i<ar.length;i++)
        {
            if(hs.contains(k-ar[i]))
            {
                ar[0]=ar[i]<(k-ar[i]) ? ar[i] : (k-ar[i]) ;
                ar[1]=k=ar[0];
                res.add(ar);
            }
        }
        return res.size();
    }
    public static void main(String args[])
    {
        int ar[]=new int[]{1,5,3};
        System.out.println( kdiff(ar, 2));
    }
}