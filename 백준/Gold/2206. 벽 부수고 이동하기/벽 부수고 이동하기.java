import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static int bfs(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{x, y, 1, 1});
        
        boolean[][][] vst = new boolean[N][M][2];
        vst[0][0][0] = true;
        vst[0][0][1] = true;
        
        while(!que.isEmpty()) {
            int[] q = que.poll();
            if(q[0] == N - 1 && q[1] == M - 1)
                return q[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = q[0] + dx[i];
                int ny = q[1] + dy[i];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && vst[nx][ny][q[3]] == false)
                    if(arr[nx][ny] == 1 && q[3] > 0) {
                        vst[nx][ny][0] = true;
                        que.offer(new int[]{nx, ny, q[2] + 1, q[3] - 1});
                    } else if(arr[nx][ny] == 0) {
                        vst[nx][ny][q[3]] = true;
                        que.offer(new int[]{nx, ny, q[2] + 1, q[3]});
                    }
            }
        }
        return -1;
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = (int)(s.charAt(j) - '0');
            }
        }
        
        System.out.print(bfs(0, 0));
    }
}