import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> cntMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            cntMap.put(genres[i], cntMap.getOrDefault(genres[i], 0) + 1);
        }
        
        int len = 0;
        for(String s : cntMap.keySet())
            if(cntMap.get(s) > 1) len += 2;
            else len++;
        
        int[] answer = new int[len];
        int[][] arr = new int[genres.length][3];
        for(int i = 0; i < genres.length; i++)
            arr[i] = new int[]{i, map.get(genres[i]), plays[i]};
        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) {
                if(a[2] == b[2])
                    return a[0] - b[0];
                return b[2] - a[2];
            }
            return b[1] - a[1];
        });
        
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            int cnt = 1;
            answer[idx++] = arr[i][0];
            int std = arr[i][1];
            while(i + 1 < arr.length && arr[i + 1][1] == std) {
                i++;
                if(cnt == 1)
                    answer[idx++] = arr[i][0];
                cnt++;
            }
        }
        return answer;
    }
}