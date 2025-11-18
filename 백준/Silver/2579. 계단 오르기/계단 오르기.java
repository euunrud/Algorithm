import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        for(int i = 0; i < n; i++)
            num[i] = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = num[0];
        if(n >= 2)
            dp[2] = dp[1] + num[1];
        for(int i = 3; i <= n; i++)
            dp[i] = Math.max(dp[i - 2] + num[i - 1], dp[i - 3] + num[i - 2] + num[i - 1]);
        System.out.println(dp[n]);
    }
}