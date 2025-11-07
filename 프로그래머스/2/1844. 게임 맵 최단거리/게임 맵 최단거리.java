import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] vst = new boolean[n][m];
        Queue<int[]> que = new ArrayDeque<>();
        
        que.offer(new int[]{0, 0, 1});
        vst[0][0] = true;
        while(!que.isEmpty()) {
            int[] a = que.poll();
            
            if(a[0] == n - 1 && a[1] == m - 1) {
                answer = a[2];
                break;
            }
            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};
            for(int i = 0; i < 4; i++) {
                int nx = a[0] + dx[i];
                int ny = a[1] + dy[i];
                if(nx >= n || nx < 0 || ny >= m || ny < 0) 
                    continue;
                if(maps[nx][ny] == 0 || vst[nx][ny] == true) 
                    continue;
                vst[nx][ny] = true;
                que.offer(new int[]{nx, ny, a[2] + 1});
            }
        }
        answer = answer != 0 ? answer : -1;
        return answer;
    }
}