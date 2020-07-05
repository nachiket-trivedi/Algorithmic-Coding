import java.util.*;
public class Result
{
    int ans=0;
    public  int countGroups(int ar[][])
    {
        HashMap<Integer, ArrayList<Integer>> hm=new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0;i<ar.length; i++)
        {
            for(int j=0;j<ar[0].length;j++)
            {
                if(!hm.containsKey(i))
                {
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    temp.add(ar[i][j]);
                    hm.put(i, temp);
                }
                else
                {
                    ArrayList<Integer> temp1=hm.get(i);
                    temp1.add(ar[i][j]);
                    hm.put(i, temp1);
                }
            }
        }
        for(int i=0;i<ar.legnth;i++)
        {
            for(int j=0;j<ar[0].length;j++)
            {
                if(ar[i][j]!=0)
                {
                    ans++;
                    // dfs(i, j, hm);
                }
            }
        }
        dfs(0,1,ar);
        return ans;
    }
    public void dfs(int r, int c, int ar[][])
    {
        if(i<0 && j<o || i>=ar.length || j>=ar[0].length || ar[i][j]==0 )
            return;
        ar[i][j]=0;
        dfs(c,r,ar);
    

        if(r!=c)
        {
            if(ar[r][c]!=0)
            {
                ar[r][c]=0;
                dfs(c, 0, ar);
            }
            else
            {
                if(c<ar[0].length-1)
                    dfs(r, c+1, ar);
            }
        }
        else
        {
            if(c<ar[0].length-1)
                dfs(r, c+1, ar);
        }
    }
}