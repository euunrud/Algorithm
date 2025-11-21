import java.util.*;
import java.io.*;

class Solution {
	static int[][] dp;
	static int[][] arr;
	static int max = 0;
	static int n, k;
	static int dfs(int idx, int w) {
		if(idx == n + 1)
			return 0;
		
        if(dp[idx][w] != 0)
            return dp[idx][w];
        
		int num1 = dfs(idx + 1, w);
        int num2 = 0;
		if(w - arr[idx][0] >= 0)
			num2 = dfs(idx + 1, w - arr[idx][0]) + arr[idx][1];
        
        //System.out.println("idx " + idx + " n1 " + num1 + " n2 " + num2);
        dp[idx][w] = Math.max(num1, num2);
        return dp[idx][w];
    }
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr= new int[n + 1][2];
            for(int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            
            dp = new int[n + 1][k + 1];
            System.out.println("#" + (i + 1) + " " + dfs(1, k));
        }
  }

}
