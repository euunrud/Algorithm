import java.util.*; 

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] vst = new boolean[n][m];
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        que.offer(new int[]{0, 0, 1});
        vst[0][0] = true;
        
        while(!que.isEmpty()) {
            int[] sp = que.poll();
            if(sp[0] == n - 1 && sp[1] == m - 1)
                answer = sp[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = sp[0] + dx[i];
                int ny = sp[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && vst[nx][ny] == false && maps[nx][ny] == 1){
                    que.offer(new int[]{nx, ny, sp[2] + 1});
                    vst[nx][ny] = true;
                }
            }
        }
        return answer;
    }
}