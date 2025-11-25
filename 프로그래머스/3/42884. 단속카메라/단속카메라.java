import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> {
            if(a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int cnt = 1;
        int std = routes[0][1];
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] > std) {
                std = routes[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}