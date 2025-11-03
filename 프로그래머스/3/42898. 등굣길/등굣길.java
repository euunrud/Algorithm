class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];
        
        for(int[] p : puddles) {
            dp[p[1]][p[0]] = -1;
        }
        
        dp[0][1] = 1;
        for(int i = 1; i <= m; i++) { 
            for(int j = 1; j <= n; j++) {
                if(dp[j][i] == -1) 
                    dp[j][i] = 0;
                else 
                    dp[j][i] = (dp[j - 1][i] + dp[j][i - 1]) % 1000000007;
            }
        }
        
        answer = dp[n][m] % 1000000007;
        return answer;
    }
    
}