import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int count = 0;
        int[][][] dir = {{{-1, -1}, {-1, 0}, {0, -1}},
                         {{-1, 0}, {-1, 1}, {0, 1}},
                         {{0, -1}, {1, -1}, {1, 0}},
                         {{0, 1}, {1, 1}, {1, 0}}};
        
        boolean find = true;
        int xl = m;
        int yl = n;
        String[][] arr = new String[xl][yl];
        
        for(int i = 0; i < xl; i++) {
            arr[i] = board[i].split("");
        }
    
        
        while(find) {
            int tcnt = 0;
            
            // 같은거 찾아서 없어질 거 표시
            boolean[][] copy = new boolean[xl][yl];
            
            for(int i = 0; i < xl; i++) {
                for(int j = 0; j < yl; j++) {
                    for(int z = 0; z < 4; z++) {
                        int cnt = 1;
                        for(int k = 0; k < 3; k++) {
                            int nx = i + dir[z][k][0];
                            int ny = j + dir[z][k][1];
                            
                            if(nx >= 0 && nx < xl && ny >= 0 && ny < yl && !arr[nx][ny].equals("-") && arr[nx][ny].equals(arr[i][j])) {
                                cnt++;
                            }
                        }
                        if(cnt == 4) {
                            for(int k = 0; k < 3; k++) {
                                int nx = i + dir[z][k][0];
                                int ny = j + dir[z][k][1];
                                
                                copy[nx][ny] = true;
                            }
                            copy[i][j] = true;
                        }
                    }
                }
            }
            
            // 지우기
            for(int i = 0; i < xl; i++) {
                for(int j = 0; j < yl; j++) {
                    if(copy[i][j] == true) {
                        arr[i][j] = "-";
                        count++;
                        tcnt++;
                    }
                }
            }
            
            //중력 적용
            for(int j = 0; j < yl; j++) {
                for(int i = xl - 2; i >= 0; i--) {
                    if(arr[i][j].equals("-")) continue;
                    for(int k = i + 1; k < xl; k++) {
                        if(arr[k][j].equals("-")) {
                            String t = arr[k][j];
                            arr[k][j] = arr[k - 1][j];
                            arr[k - 1][j] = t;
                        }
                    }
                }
            }
            
            if(tcnt == 0) break;
        }
        return count;
    }
}