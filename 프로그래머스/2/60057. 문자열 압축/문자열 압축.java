class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        for(int i = 1; i <= len / 2; i++) {
            int length = 0;
            int idx = 0;
            while(idx + i <= len) {
                int cnt = 1;
                String std = s.substring(idx, idx + i);
                while(idx + 2 * i <= len && s.substring(idx + i, idx + i * 2).equals(std)) {
                    cnt++;
                    idx += i;
                }
                if(cnt != 1)
                    while(cnt > 0) {
                        length++;
                        cnt /= 10;
                    }
                idx += i;
                length += i;
            }
            
            if(idx < len)
                length += len - idx;
            answer = Math.min(answer, length);
        }
        
        return answer;
    }
}