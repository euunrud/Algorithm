import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        Queue<int[]> que = new ArrayDeque<>();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                    que.offer(new int[]{i, j, 0});
            }
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int day = 0;
        
        while(!que.isEmpty()) {
            int[] a = que.poll();
            if(a[2] > day)
                day = a[2];
            for(int i = 0; i < 4; i++) {
                int nx = a[0] + dx[i];
                int ny = a[1] + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                    que.offer(new int[]{nx, ny, a[2] + 1});
                    arr[nx][ny] = 1;
                }
            }
        }
        
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < m; j++)
                if(arr[i][j] == 0){
                    day = -1;
                    break;
                }
        
        System.out.println(day);
    }
}