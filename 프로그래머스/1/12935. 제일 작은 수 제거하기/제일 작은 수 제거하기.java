import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        if(len == 1) 
            return new int[]{-1};
        
        int min = arr[0];
        for(int i = 1; i < len; i++)
            min = Math.min(min, arr[i]);

        int[] answer = new int[len - 1];
        int idx = 0;
        
        for(int i = 0; i < len; i++)
            if(arr[i] != min)
                answer[idx++] = arr[i];

        return answer;
    }
}