import java.util.*;

class Solution {
    Queue<int[]> que = new LinkedList<>();
    boolean[][] vst;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int bfs(int[][] maps) {
        while(!que.isEmpty()) {
            int[] q = que.poll();
            if(q[0] == maps.length - 1 && q[1] == maps[0].length - 1) return q[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = q[0] + dx[i];
                int ny = q[1] + dy[i];
                
                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1 && vst[nx][ny] == false) {
                    que.offer(new int[]{nx, ny, q[2] + 1});
                    vst[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
    public int solution(int[][] maps) {
        int answer = 0;
        vst = new boolean[maps.length][maps[0].length];
        que.offer(new int[]{0, 0, 1});
        vst[0][0] = true;
        
        int as = bfs(maps);
        return as;
    }
}