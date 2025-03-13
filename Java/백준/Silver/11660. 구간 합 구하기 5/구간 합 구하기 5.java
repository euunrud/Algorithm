
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] S = new long[n + 1][n + 1];
        
        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
        	for(int j = 1; j < n + 1; j++) {
        		if(i == 1 && j == 1) {
        			S[i][j] = Long.parseLong(st.nextToken());
        		}else if (i == 1) {
        			S[i][j] = S[i][j - 1] + Long.parseLong(st.nextToken());
        		}else if (j == 1) {
        			S[i][j] = S[i - 1][j] + Long.parseLong(st.nextToken());
        		}else {
        			S[i][j] = S[i][j - 1] + S[i - 1][j] - S[i-1][j-1] + Long.parseLong(st.nextToken());
        		}
        	}
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            if(a == 1 && b == 1) {
                System.out.println(S[c][d]);
            }else if(a == 1){
            	System.out.println(S[c][d] - S[c][b - 1]);
            }else if(b == 1) {
            	System.out.println(S[c][d] - S[a - 1][d]);
            }else {
                System.out.println(S[c][d] - S[c][b - 1] - S[a - 1][d] + S[a - 1][b - 1]);
            }
        }
        
    }

}
