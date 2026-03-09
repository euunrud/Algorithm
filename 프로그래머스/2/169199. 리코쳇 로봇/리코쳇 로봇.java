import java.util.*; 

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int n = board.length;
        int m = board[0].length();
        char[][] arr = new char[n][m];
        for(int i = 0; i < n; i++)
            arr[i] = board[i].toCharArray();
        
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(arr[i][j] == 'R') {
                    x = i; y = j;
                    break;
                }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][][] vst = new boolean[n][m][4];
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != 'D') {
                while(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                if(vst[nx - dx[i]][ny - dy[i]][i] == true) continue;
                que.offer(new int[]{nx - dx[i], ny - dy[i], 1});
                vst[nx - dx[i]][ny - dy[i]][i] = true;
            }
        }
        
        while(!que.isEmpty()) {
            int[] q = que.poll();
            if(arr[q[0]][q[1]] == 'G') {
                answer = q[2];
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = q[0] + dx[i];
                int ny = q[1] + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != 'D') {
                    while(nx >= 0 && nx < n && ny >= 0 & ny < m && arr[nx][ny] != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    }
                    if(vst[nx - dx[i]][ny - dy[i]][i] == true) continue;
                    que.offer(new int[]{nx - dx[i], ny - dy[i], q[2] + 1});
                    vst[nx - dx[i]][ny - dy[i]][i] = true;
                }
            }
        }
        return answer;
    }
}