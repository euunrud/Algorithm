import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] list = new int[n];
        int[] pl = new int[n];
        int[] dp = new int[n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	list[i] = Integer.parseInt(st.nextToken());
        	pl[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        if(list[0] <= n) {
        	dp[0] = pl[0];
        	max = pl[0];
        }
        if(n > 1 && (1 + list[1]) <= n) {
        	if(list[0] == 1) {
        		dp[1] = pl[0] + pl[1];
        	}
        	else {
        		dp[1] = pl[1];
        	}
        	if(dp[1] > max) {
        		max = dp[1];
        	}
        }
        for(int i = 0; i < n; i++) {
        	for(int j = i - 1; j > -1; j--) {
        		if(j + list[j] <= i) {
        			if(dp[i] < dp[j] + pl[i] && (i + list[i]) <= n) {
        				dp[i] = dp[j] + pl[i];
        				//System.out.println("i - " + i + ", j - " + j);
        			}
        		}
        	}
        	if(dp[i] == 0 && (i + list[i]) <= n) {
        		//System.out.print(i + " + " + list[i] + " , " + n);
        		dp[i] = pl[i];
        	}
        	if(dp[i] > max) {
        		max = dp[i];
        	}
        	//System.out.println("dp[" + i + "] " + dp[i]);
        }
        
        System.out.println(max);
	}
}