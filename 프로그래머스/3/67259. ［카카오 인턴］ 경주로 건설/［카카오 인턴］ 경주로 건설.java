class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int n;
    int min = 1000000;
    int[][][] dp;
    void calc(int x, int y, int d, boolean[][] vst, int[][] board, int sum) {
        if(sum > min) return;
        if(x == n - 1 && y == n - 1) {
            min = Math.min(sum, min);
            return;
        }
        if(dp[x][y][d/2] != 0 && dp[x][y][d/2] < sum) {
            return;
        }
        dp[x][y][d/2] = sum;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && vst[nx][ny] == false && board[nx][ny] == 0) {
                vst[nx][ny] = true;
                int pay = sum + 100;
                if(i / 2 != d / 2) pay += 500;
                calc(nx, ny, i, vst, board, pay);
                vst[nx][ny] = false;
            }
        }
    }
    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        //지금 방향을 기준으로 어디가 직선이고, 코너인지 계산해야함.
        
        boolean[][] vst = new boolean[n][n];
        vst[0][0] = true;
        dp = new int[n][n][2];
        if(board[0][1] == 0) {
            vst[0][1] = true;
            calc(0, 1, 1, vst, board, 100);
            vst[0][1] = false;
        }
        if(board[1][0] == 0) {
            vst[1][0] = true;
            calc(1, 0, 3, vst, board, 100);
            vst[1][0] = false;
        }
        return min;
    }
}