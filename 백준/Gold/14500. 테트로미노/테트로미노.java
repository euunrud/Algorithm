import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
    static int n, m;
    static int[][] arr;
    static void dfs(int x, int y, int idx, int sum, boolean[][] vst) {
        if(idx == 3) {
            max = Math.max(max, sum);
            return;
        }
        
        if(x - 1 >= 0 && vst[x - 1][y] == false) {
            vst[x - 1][y] = true;
            dfs(x - 1, y, idx + 1, sum + arr[x - 1][y], vst);
            vst[x - 1][y] = false;
        }
        
        if(x + 1 < n && vst[x + 1][y] == false) {
            vst[x + 1][y] = true;
            dfs(x + 1, y, idx + 1, sum + arr[x + 1][y], vst);
            vst[x + 1][y] = false;
        }
        
        if(y - 1 >= 0 && vst[x][y - 1] == false) {
            vst[x][y - 1] = true;
            dfs(x, y - 1, idx + 1, sum + arr[x][y - 1], vst);
            vst[x][y - 1] = false;
        }
        
        if(y + 1 < m && vst[x][y + 1] == false) {
            vst[x][y + 1] = true;
            dfs(x, y + 1, idx + 1, sum + arr[x][y + 1], vst);
            vst[x][y + 1] = false;
        }
        return;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        boolean[][] vst = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                vst[i][j] = true;
                dfs(i, j, 0, arr[i][j], vst);
                vst[i][j] = false;
            }
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
         for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int[] block = {0, 0, 0, 0};
                for(int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(x >= 0 && x < n && y >= 0 && y < m)
                        block[k] = arr[x][y];
                }
                Arrays.sort(block);
                int sum = block[3] + block[2] + block[1] + arr[i][j];
                max = Math.max(max, sum);
            }
         }
         
         System.out.println(max);
    }
}