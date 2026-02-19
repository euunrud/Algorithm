import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1;
        int len = times.length;
        long right = (long)times[len - 1] * n;
        
        while(left < right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for(int i = 0; i < len; i++) {
                cnt += (mid / times[i]);
            }
            if(cnt >= n) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}