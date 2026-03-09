import java.util.*; 

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int n = board.length;
        int m = board[0].length();
        char[][] arr = new char[n][m];
        int x = 0; 
        int y = 0;
        
        for (int i = 0; i < n; i++) {
            arr[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] vst = new boolean[n][m];
        que.offer(new int[]{x, y, 0});
        vst[x][y] = true;

        while (!que.isEmpty()) {
            int[] q = que.poll();

            if (arr[q[0]][q[1]] == 'G') {
                answer = q[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = q[0];
                int ny = q[1];

                while (true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];

                    if (tx < 0 || tx >= n || ty < 0 || ty >= m || arr[tx][ty] == 'D') {
                        break;
                    }

                    nx = tx;
                    ny = ty;
                }

                if (nx == q[0] && ny == q[1]) continue;

                if (!vst[nx][ny]) {
                    vst[nx][ny] = true;
                    que.offer(new int[]{nx, ny, q[2] + 1});
                }
            }
        }

        return answer;
    }
}