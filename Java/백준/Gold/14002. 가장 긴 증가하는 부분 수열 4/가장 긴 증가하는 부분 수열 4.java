import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] len = new int[n];
        
        ArrayList<Integer>[] dp = new ArrayList[n];
        for(int i = 0; i < n; i++) {
        	dp[i] = new ArrayList<Integer>();
        }
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	list[i] = Integer.parseInt(st.nextToken());
        }
        

        int max = 0;
        dp[0].add(list[0]);
        len[0] = 1;
        if(n > 1) {
        	if(list[1] > list[0]) {
        		dp[1].addAll(dp[0]);
        		dp[1].add(list[1]);
        		len[1] = 2;
        		max = 1;
        	} else {
        		dp[1].add(list[1]);
        		len[1] = 1;
        		max = 0;
        	}
        }
        
        for(int i = 2; i < n; i++) {
        	for(int j = i - 1; j >= 0; j--) {
        		if(list[i] > list[j]) {
        			if(len[i] <= len[j]) {
        				dp[i].clear();
        				dp[i].addAll(dp[j]);
        				dp[i].add(list[i]);
        				len[i] = len[j] + 1;
        				//System.out.println("ee - " + j + "len - " + len[j]);
        			}
        		}
        	}
        	
        	if(len[i] == 0) {
        		dp[i].add(list[i]);
        		len[i] = 1;
        	}
        	if(len[i] > len[max]) max = i;
        	//System.out.println("i - " + i + "len - " + len[i] + ", dp.size - " + dp[i].size());
//        	for(int  k = 0; k < dp[i].size(); k++) {
//        		System.out.print(dp[i].get(k) + " ");
//        	}
//        	System.out.println();
        }

        System.out.println(dp[max].size());
        for(int i = 0; i < dp[max].size(); i++) {
        	System.out.print(dp[max].get(i) + " ");
        }
	}
}
