import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] lc = new int[2];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9) {
                    lc = new int[]{i, j};
                    arr[i][j] = 0;
                }
            }
        }
        
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int size = 2;
        int cnt = 0;
        int time = 0;
        boolean ch = true;
        
        while(ch) {
            ch = false;
            Queue<int[]> que = new ArrayDeque<>();
            boolean[][] vst = new boolean[n][n];
            que.offer(new int[]{lc[0], lc[1], 0});
            vst[lc[0]][lc[1]] = true;
            
            int t = 0;
            int[] find = {-1, -1};
            while(!que.isEmpty()) {
                int[] q = que.poll();
                t = q[2];
                
                for(int i = 0; i < 4; i++) {
                    int nx = dx[i] + q[0];
                    int ny = dy[i] + q[1];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] <= size && vst[nx][ny] == false) {
                        vst[nx][ny] = true;
                        if(arr[nx][ny] != 0 && arr[nx][ny] != size) {
                            if(find[0] == -1)
                                find = new int[]{nx, ny};
                            else
                                if(find[0] > nx || (find[0] == nx && find[1] > ny)) {
                                    find = new int[]{nx, ny};
                                }
                        }
                        que.offer(new int[]{nx, ny, q[2] + 1});
                    }
                }
                
                if(find[0] != -1 && que.peek()[2] != q[2]) {
                    cnt++;
                    if(cnt == size){
                        size++;
                        cnt = 0;
                    }
                    
                    arr[find[0]][find[1]] = 0;
                    lc = new int[]{find[0], find[1], 0};
                    ch = true;
                    que.clear();
                    break;
                }
            }
            if(ch) time += t + 1;
        }
        System.out.println(time);
    }
}