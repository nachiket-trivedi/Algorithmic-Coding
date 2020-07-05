//Question starred in whatsaap
import java.util.Arrays;
import java.lang.StringBuilder;
public class foobar1{
    public static String solution(int i) {
        // Your code here
        int n=20250;
        boolean[] primes=new boolean[n+1];
        Arrays.fill(primes, true);
        for(int k=2; k*k<=n; k++){
            if(primes[k]){
                for(int j=k*2; j<=n; j+=k){
                    primes[j]=false;
                }
            }
        }
        StringBuilder primeString=new StringBuilder();
        for (int k = 2; primeString.length()<=(i+5); k++) {

            if (primes[k]) {
                primeString.append(k);
            }
        }
        return primeString.substring(i,i+5).toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(10000));
    }
}