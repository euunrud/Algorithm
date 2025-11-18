import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] num = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = num[1];
        
        int max = dp[1];
        for(int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            if(dp[i] > max)
                max = dp[i];
        }
        System.out.println(max);
    }
}