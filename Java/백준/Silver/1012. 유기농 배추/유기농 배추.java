import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
        	st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
           // System.out.println("----   " + arr[0].length +", " + arr.length);
            for(int j = 0; j < k; j++) {
            	st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
            	
                arr[x][y] = 1;
            }
            int cnt = 0;
            for(int a = 0; a < m; a++) {
            	for(int b = 0; b < n; b++) {
            		if(arr[a][b] != 1) {
            			continue;
            		}
            		DFS(a, b);
            		cnt++;
            	}
            }
            bw.write(cnt + "\n");
        }
        
        bw.flush();
        bw.close();
	}
	
	static void DFS(int a, int b) {
		if(arr[a][b] == 0) {
			return;
		}
		arr[a][b] = 0;
		if(a + 1 < arr.length) {
			DFS(a + 1, b);
		}
		if(a - 1 >= 0) {
			DFS(a - 1, b);
		}
		if(b + 1 < arr[0].length) {
			DFS(a, b + 1);
		}
		if(b - 1 >= 0) {
			DFS(a, b - 1);
		}
		return;
	}
}