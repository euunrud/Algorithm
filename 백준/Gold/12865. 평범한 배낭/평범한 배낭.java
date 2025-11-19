import java.util.*;
import java.io.*;

class Main {
    static int[][] dp;
    static int[][] num;
    static int max = 0;

    static public int DP(int idx, int k) {
      if(idx == dp.length)
        return 0;

      if(dp[idx][k] != 0) 
        return dp[idx][k];
      
      int val1 = 0;
      if(k - num[idx][0] >= 0)
        val1 = DP(idx + 1, k - num[idx][0]) + num[idx][1];
      int val2 = DP(idx + 1, k);
      
      dp[idx][k] = Math.max(val1, val2);
      return dp[idx][k];
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        num = new int[n + 1][2];
        for(int i = 1; i <= n; i++) {
          st = new StringTokenizer(br.readLine());
          num[i][0] = Integer.parseInt(st.nextToken());
          num[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num, (a, b) -> a[0] - b[0]);

        dp = new int[n + 1][k + 1];
        System.out.println(DP(1, k));
  }
}
