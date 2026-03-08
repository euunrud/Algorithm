import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        Set<int[]> set = new HashSet<>();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(answer[i] == 0) break;
                for(int k = 0; k < 5; k++) {
                    if(answer[i] == 0) break;
                    //p이면자신의 상하좌우에서  'O'인 것 중에서 거리 2 이하인거 있나 검사 
                    if(places[i][j].charAt(k) == 'P') {
                        int[] dx = {0, 0, -1, 1};
                        int[] dy = {-1, 1, 0, 0};
                        Queue<int[]> que = new ArrayDeque<>();
                        boolean[][] vst = new boolean[5][5];
                        vst[j][k] = true;
                        for(int a = 0; a < 4; a++) {
                            int nx = j + dx[a];
                            int ny = k + dy[a];
                            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && vst[nx][ny] == false && places[i][nx].charAt(ny) != 'X') {
                                vst[nx][ny] = true;
                                que.offer(new int[]{nx, ny, 1});
                            }
                        }
                        
                        while(!que.isEmpty()) {
                            int[] q= que.poll();
                            if(places[i][q[0]].charAt(q[1]) == 'P') {
                                answer[i] = 0;
                                break;
                            }
                            
                            if(q[2] == 1) {
                                for(int a = 0; a < 4; a++) {
                                    int nx = q[0] + dx[a];
                                    int ny = q[1] + dy[a];
                                    if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && vst[nx][ny] == false && places[i][nx].charAt(ny) != 'X') {
                                        vst[nx][ny] = true;
                                        que.offer(new int[]{nx, ny, q[2] + 1});
                                    }
                                }
                            }
                        }
                        
                    }
                }
            }
            
        }
        return answer;
    }
}