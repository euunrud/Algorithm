import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 0;
        int max = stones[0];
        for(int s: stones) 
            if(s > max)
                max = s;
        right = max;
        int answer = right;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for(int i = 0; i < stones.length; i++) {
                if(cnt >= k)
                    break;
                if(mid >= stones[i])
                    cnt++;
                else
                    cnt = 0;
            }
            
            if(cnt >= k)
                right = mid - 1;
            else {
                left = mid + 1;
                answer = mid;
            }
        }
        
        return answer + 1;
    }
}