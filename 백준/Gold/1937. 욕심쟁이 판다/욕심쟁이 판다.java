import java.util.*;
import java.io.*;

class Main {
    static int[][] grid;
    static int[][] memo;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int DFS(int x, int y) {
        if(memo[x][y] != -1)
            return memo[x][y];
        
        int max = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] > grid[x][y]) {
                 int m = DFS(nx, ny) + 1;
                 if(m > max)
                    max = m;
            }
        }
        
        memo[x][y] = max;
        return max;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        grid = new int[n][n];
        memo = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
            }
        }
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(memo[i][j] == -1)
                    DFS(i, j);
        
        int max = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(memo[i][j] > max)
                    max = memo[i][j];
                    
        System.out.println(max);
        
    }
}