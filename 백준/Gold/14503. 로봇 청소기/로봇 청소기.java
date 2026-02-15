// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] grid;
    static int cnt = 0;
    static int[] dir = {-1, 1, 1, -1};
    static Set<String> set = new HashSet<>();
    static boolean check(int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0)
                return true;
        }
        
        return false;
    }
    static void simul(int x, int y, int d) {
        if(grid[x][y] == 0) {
            grid[x][y] = 2;
            cnt++;
        }
        
        if(check(x, y)) {
            d = (d - 1 + 4 ) % 4;
            if(d == 0 || d == 2) {
                if(grid[x + dir[d]][y] == 0) {
                    simul(x + dir[d], y, d);
                }else {
                    String s = x + " " + y + " " + d;
                    if(!set.contains(s)) {
                        set.add(s);
                        simul(x, y, d);
                    }
                }
            }else {
                if(grid[x][y + dir[d]] == 0) {
                    simul(x, y + dir[d], d);
                }else {
                    String s = x + " " + y + " " + d;
                    if(!set.contains(s)) {
                        set.add(s);
                        simul(x, y, d);
                    }
                }
            }
        } else {
            if(d == 0 || d == 2) {
                if(grid[x + dir[(d + 2) % 4]][y] != 1) {
                    simul(x + dir[(d + 2) % 4], y, d);
                }
            }else {
                if(grid[x][y + dir[(d + 2) % 4]] != 1) {
                    simul(x, y + dir[(d + 2) % 4], d);
                }
            }
        }
        
        return;
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        simul(r, c, d);
        System.out.print(cnt);
    }
}