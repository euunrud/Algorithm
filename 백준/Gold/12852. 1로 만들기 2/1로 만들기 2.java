import java.io.*;
import java.util.*;

class Main {
    static int[] memo;
    static void dp(int num) {
        memo[1] = 0;
        for(int i = 2; i <= num; i++) {
            int n1 = -1, n2 = -1, n3 = -1;
            if(i % 3 == 0 && i / 3 > 0)
                n1 = memo[i / 3] + 1;
            if(i % 2 == 0 && i / 2 > 0)
                n2 = memo[i / 2] + 1;
            n3 = memo[i - 1] + 1;
            
            int min = 100000;
            if (n1 != -1) min = Math.min(min, n1);
            if (n2 != -1) min = Math.min(min, n2);
            if (n3 != -1) min = Math.min(min, n3);
                
            memo[i] = min;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];
        
        dp(n);
        System.out.println(memo[n]);
        System.out.print(n);
        while(n > 1) 
            if(n % 3 == 0 && memo[n / 3] == memo[n] - 1) {
                n /= 3;
                System.out.print(" " + n);
            }else if (n % 2 == 0 && memo[n / 2] == memo[n] - 1) {
                n /= 2;
                System.out.print(" " + n);
            }else if (memo[n] == memo[n-1] + 1) {
                n -= 1;
                System.out.print(" " + n);
            }
    }
}