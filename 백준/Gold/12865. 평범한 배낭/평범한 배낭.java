import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] bag;
    static int[][] memo;
    static int max = 0;
    
    static int dp(int idx, int w) {
        if(idx == n)
            return 0;
        if(memo[idx][w] > 0)
            return memo[idx][w];
            
        int r1 = dp(idx + 1, w);
        int r2 = 0;
        if(w - bag[idx][0] >= 0)
            r2 = dp(idx + 1, w - bag[idx][0]) + bag[idx][1];
        
        memo[idx][w] = Math.max(r1, r2);
        return memo[idx][w];
        
    }
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bag = new int[n][2];
        memo = new int[n][k + 1];
        
        for(int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
             bag[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        System.out.print(dp(0, k));
	}
}