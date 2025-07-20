
import java.io.*;
//import java.util.*;

class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 0; i < n; i++) {
        	if(nums[i] < 4) {
        		System.out.println(dp[nums[i]]);
        	}
        	else {
	            for(int j = 4; j <= nums[i]; j++) {
	                if(dp[j] == 0) {
	                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
	                }
	                if(j == nums[i]) {
	                    System.out.println(dp[j]);
	                }
	            }
        	}
        }
    }
}