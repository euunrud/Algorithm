import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                    cnt++;
            }
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int time = 0;
        while(cnt > 0) {
            time++;
            boolean[][] vst = new boolean[n][m];
            Queue<int[]> que = new ArrayDeque<>();
            que.offer(new int[]{0, 0});
            vst[0][0] = true;
            Map<String, Integer> map = new HashMap<>();
            
            while(!que.isEmpty()) {
                int[] q = que.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = q[0] + dx[i];
                    int ny = q[1] + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if(arr[nx][ny] == 0 && vst[nx][ny] == false){
                            vst[nx][ny] = true;
                            que.offer(new int[]{nx, ny});
                        }else if(arr[nx][ny] == 1) {
                            String s = nx + " " + ny;
                            map.put(s, map.getOrDefault(s, 0) + 1);
                        }
                    }
                }
            }
            
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() >= 2) {
                    String s = entry.getKey();
                    int x = Integer.parseInt(s.split(" ")[0]);
                    int y = Integer.parseInt(s.split(" ")[1]);
                    arr[x][y] = 0;
                    cnt--;
                }
            }
        }
        
        System.out.print(time);
    }
}