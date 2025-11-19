import java.util.*;
import java.io.*;

class Main {
    static int[][] memo;
    static int n,m;
    static int[][] route;
    static int DP(int i, int j) {
      if(i >= n && j >= m)
        return 1;

      if(memo[i][j] != -1)
        return memo[i][j];

      int[] dx = {-1, 1, 0, 0};
      int[] dy = {0, 0, -1, 1};
      int num = 0;
      
      for(int k = 0; k < 4; k++) {
        int xv = i + dx[k];
        int yv = j + dy[k];
        
        if(xv > 0 && xv <= n && yv > 0 && yv <= m) 
          if(route[xv][yv] < route[i][j])
            num += DP(xv, yv);
      }

      memo[i][j] = num;
      return memo[i][j];
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        memo = new int[n + 1][m + 1];
        route = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
          st = new StringTokenizer(br.readLine());
          for(int j = 1; j <= m; j++) {
            route[i][j] = Integer.parseInt(st.nextToken());
            memo[i][j] = -1;
          }
        }

        System.out.println(DP(1, 1));
      
  }
}
