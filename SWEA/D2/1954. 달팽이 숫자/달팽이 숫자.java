import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        
        for(int i = 0; i < T; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
		for(int tc = 0; tc < T; tc++) {
            int n = arr[tc];
			int[][] grid = new int[n][n];
            
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            
            int cnt = 1;
            int x = 0;
            int y = -1;
            int d = 0;
            
            while(cnt <= n * n) { 
            	int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    d = (d + 1) % 4;
                    continue;
                }
                if(grid[nx][ny] != 0) {
                    d = (d + 1) % 4;
                    continue;
                }
                grid[nx][ny] = cnt;
                
                x = nx;
                y = ny;
                cnt++;
            }
            System.out.println("#"+(tc+1));
            for(int i =0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
		}
	}
}