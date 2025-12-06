import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < words.length; i++) {
            if(set.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
            } else if(i != 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
            }
            
            if(answer[0] != 0 && answer[1] != 0)
                break;
            set.add(words[i]);
        }

        return answer;
    }
}