class Solution {
    public int solution(String s) {
        int min = s.length();
        for(int i = 1; i <= s.length()/2; i++)
            min = Math.min(check(s, i), min);
        
        return min;
    }
    
    public int check(String s, int n) {
        int i;
        String prev = s.substring(0, n);
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for(i = n; i + n <= s.length(); i += n) {
            String now = s.substring(i, i + n);
            if(prev.equals(now)) {
                cnt++;
            } else {
                if(cnt != 1)
                    sb.append(cnt);
                sb.append(prev);
                cnt = 1;
                prev = now;
            }
        }
        
        String now = s.substring(i, s.length());
        if(cnt > 1)
            sb.append(cnt);
        sb.append(prev).append(now);

        return sb.length();
    }
}