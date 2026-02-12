import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[][] arr = new int[n][n];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.put(friends[i], i);
        
        for(int i = 0; i < gifts.length; i++) {
            String[] srr = gifts[i].split(" ");
            int a = map.get(srr[0]);
            int b = map.get(srr[1]);
            arr[a][b]++;
        }
        
        int[] per = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i][j] == arr[j][i]) {
                    int g1 = 0;
                    int g2 = 0;
                    int t1 = 0;
                    int t2 = 0;
                    for(int k = 0; k < n; k++){
                        g1 += arr[i][k];
                        t1 += arr[k][i];
                        g2 += arr[j][k];
                        t2 += arr[k][j];
                    }
                    
                    if(g1 - t1 > g2 - t2)
                        per[i]++;
                    else if(g1 - t1 < g2 - t2)
                        per[j]++;
                } else {
                    if(arr[i][j] > arr[j][i])
                        per[i]++;
                    else
                        per[j]++;
                }
            }
        }
        
        for(int i = 0; i < n; i++) 
            answer = Math.max(per[i], answer);
        return answer;
    }
}