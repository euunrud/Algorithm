import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		String[] st1 = s1.split("");
		String[] st2 = s2.split("");
		int[][] dp = new int[st2.length][st1.length];
		int max = 0;
		for(int i = 0; i < st1.length; i++) {
			for(int j = 0; j < st2.length; j++) {
				if(i == 0 && j == 0) {
					if(st1[i].equals(st2[j])) {
						dp[0][0] = 1;
					}else {
						dp[0][0] = 0;
					}
				}
				if(st1[i].equals(st2[j])) {
					if(i > 0 && j > 0) {
						dp[j][i] = dp[j - 1][i - 1] + 1;
					}else if(i > 0 || j > 0) {
						dp[j][i] = 1;
					}
				}else {
					if(i > 0 && j > 0) {
						dp[j][i] = dp[j - 1][i] > dp[j][i - 1]?dp[j - 1][i]:dp[j][i - 1];
					}else if(i > 0) {
						dp[j][i] = dp[j][i - 1];
					}else if(j > 0) {
						dp[j][i] = dp[j - 1][i];
					}
				}
				//System.out.println("i - " + i+ ", j - " + j + ", " + dp[j][i]);
				if(max < dp[j][i]) {
					max = dp[j][i];
				}
			}
		}
//		for(int i = 0; i < st1.length; i++) {
//			for(int j = 0; j < st2.length; j++) {
//				System.out.print(dp[j][i]);
//			}
//			System.out.println();
//		}
		System.out.println(max);
	}
}