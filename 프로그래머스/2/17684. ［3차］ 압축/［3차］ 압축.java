import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        char c = 'A' - 1;
        for(int i = 1; i <= 26; i++)
            map.put(String.valueOf(++c), i);
        
        List<Integer> list = new ArrayList<>();
        int idx = 27;
        int idx2 = 0;
        for(int i = 0; i < msg.length(); i++) {
            if(i == msg.length() - 1)
                list.add(map.get(msg.substring(i, i + 1)));
            for(int j = i + 1; j < msg.length(); j++) {
                if(!map.containsKey(msg.substring(i, j + 1))) {
                    map.put(msg.substring(i, j + 1) ,idx++);
                    list.add(map.get(msg.substring(i, j)));
                    i = j - 1;
                    break;
                } else if(j == msg.length() - 1) {
                    list.add(map.get(msg.substring(i, j + 1)));
                    i = j;
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}