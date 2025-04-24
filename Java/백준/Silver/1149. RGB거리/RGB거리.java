import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][n];
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
            	list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = list[0][0];
        dp[0][1] = list[0][1];
        dp[0][2] = list[0][2];
        for(int i = 1; i <n; i++) {
        	for(int j = 0; j < 3; j++) {
        		if(j != 0) {
            		dp[i][j] = dp[i - 1][0] + list[i][j];
        		}
        		if(j!= 1) {
        			if(dp[i][j] == 0) {
            			dp[i][j] = dp[i - 1][1] + list[i][j];
        			} else {
        				dp[i][j] = dp[i][j] > dp[i - 1][1] + list[i][j] ? dp[i - 1][1] + list[i][j] : dp[i][j];  
        			}
        		}
        		if(j != 2) {
        			if(dp[i][j] == 0) {
            			dp[i][j] = dp[i - 1][2] + list[i][j];
        			} else {
        				dp[i][j] = dp[i][j] > dp[i - 1][2] + list[i][j] ? dp[i - 1][2] + list[i][j] : dp[i][j];  
        			}
        		}
        	}
        }
        
        int min = dp[n - 1][0];
        for(int i = 1; i < 3; i++) {
        	if(dp[n - 1][i] < min) {
        		min = dp[n - 1][i];
        	}
        }
        System.out.println(min);
	}
}