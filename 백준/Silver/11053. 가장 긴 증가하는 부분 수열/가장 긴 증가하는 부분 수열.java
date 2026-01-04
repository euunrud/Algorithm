import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	list[i] = Integer.parseInt(st.nextToken());
        }


        int max = 1;
        dp[0] = 1;
        if(n > 1) {
        	dp[1] = list[0] < list[1] ? 2 : 1;
            if(dp[1] > 1) max = 2;
        }
        for(int i = 2; i < n; i++) {
        	for(int j = i - 1; j >= 0; j--) {
        		if(list[i] > list[j]) {
        			if(dp[i] <= dp[j]) {
        				dp[i] = dp[j] + 1;
        				//System.out.println(i + " - " + dp[i]);
        			}
        		}
        	}
        	if(dp[i] == 0) {
        		dp[i] = 1;
        	}
        	//System.out.println(i + " -- " + dp[i]);
        	if(dp[i] > max) {
        		max = dp[i];
        	}
        }
        
        System.out.print(max);
        
	}
}