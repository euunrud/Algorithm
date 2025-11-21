class Solution {
    static int len;
    static String[] word;
    static int answer;
    static boolean[] vst;
    
    static void dfs(int cnt, int idx, String str, String target) {
        if(str.equals(target))
            if(answer > cnt)
                answer = cnt;
        
        if(cnt > len)
            return;
        
        for(int i  = 0; i < word.length; i++) {
            if(vst[i] == false) {
                int c = 0;
                for(int j = 0; j < len; j++) 
                    if(str.charAt(j) != word[i].charAt(j))
                        c++;
                
                if(c == 1) {
                    vst[i] = true;
                    dfs(cnt + 1, i, word[i], target);
                    vst[i] = false;
                }
            }
            
        }        
    }
    public int solution(String begin, String target, String[] words) {
        answer = words.length;
        len = words[0].length();
        word = words;
        vst = new boolean[words.length];
        boolean flag = false;
        for(int i = 0; i < words.length; i++)
            if(words[i].equals(target)) {
                flag = true;
                break;
            }
        
        if(flag == false)
            return 0;
        
        dfs(0, -1, begin, target);
        return answer;
    }
}