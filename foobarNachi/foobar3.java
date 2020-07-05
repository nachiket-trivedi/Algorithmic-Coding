//question starred in whatsapp
import java.util.ArrayList;

public class foobar3 {
    public static int solution(String s) {
        //Your code here
        int count=0;
        ArrayList<Integer> a1=new ArrayList<Integer>();
        for(char c: s.toCharArray()){
            if(c=='>')
                count++;
            else if(c=='<' && count>0){
                a1.add(count);
            }
        }
        int res=0;
        for(int num: a1){
            res+=(num*2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("<<>><"));
    }
}
