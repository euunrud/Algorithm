import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        boolean ch = true;
        int day = 0;
        while(ch) {
            ch = false;
            int[][] vst = new int[n][n];
            
            Queue<int[]> que = new ArrayDeque<>();
            que.offer(new int[]{0, 0, 1});
            vst[0][0] = 1;
            int sum = arr[0][0];
            int cnt = 1;
            List<int[]> team = new ArrayList<>();
            team.add(new int[]{0, 0});
            while(!que.isEmpty()) {
                int[] q = que.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = q[0] + dx[i];
                    int ny = q[1] + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && vst[nx][ny] == 0) {
                        int abs = Math.abs(arr[q[0]][q[1]] - arr[nx][ny]);
                        if(abs < l || abs > r) continue;
                        que.offer(new int[]{nx, ny, q[2]});
                        vst[nx][ny] = q[2];
                        team.add(new int[]{nx, ny});
                        sum += arr[nx][ny];
                        cnt++;
                        ch = true;
                    }
                }
                
                
                if(que.isEmpty()) {
                    //연합 처리
                    int per = sum / cnt;
                    for(int i = 0; i < team.size(); i++) {
                        int[] t = team.get(i);
                        arr[t[0]][t[1]] = per;
                    }
                    
                    team = new ArrayList<>();
                    sum = 0;
                    cnt = 1;
                    
                    ///새로시작
                    for(int i = 0; i < n; i++) {
                        if(!que.isEmpty())break;
                        for(int j = 0; j < n; j++) {
                            if(vst[i][j] == 0) {
                                que.offer(new int[]{i, j, q[2] + 1});
                                sum = arr[i][j];
                                vst[i][j] = q[2] + 1;
                                team.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }
            }
            if(ch == false) break;
            day++;
        }
        System.out.println(day);
    }
}