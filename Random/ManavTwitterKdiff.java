import java.util.*;
import java.io.*;
public class ManavTwitterKdiff{
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
            int temp[]=new int[2];
            
            if(hs.contains(k-ar[i]) && ar[i]!=(k-ar[i]))
            {
                temp[0]=ar[i]<(k-ar[i]) ? ar[i] : (k-ar[i]) ;
                temp[1]=k+temp[0];
                System.out.println(ar[i]);
                System.out.println(temp[0]+","+temp[1]);
                res.add(temp);
            }
            else if(hs.contains(ar[i]-k) && ar[i]!=(ar[i]-k))
            {
                temp[0]=ar[i]<(ar[i]-k) ? ar[i] : (ar[i]-k) ;
                temp[1]=(k+temp[0]);
                System.out.println(ar[i]);
                System.out.println(temp[0]+"-"+temp[1]);
                res.add(temp);
            }
        }
        return res.size();
    }
    public static void main(String args[])
    {
        int ar[]=new int[]{363374326,364147530,618215163, 107306571, 128124602, 139946991, 428047635, 491595254, 879792181, 106926279};
        System.out.println( kdiff(ar, 1));
    }
}