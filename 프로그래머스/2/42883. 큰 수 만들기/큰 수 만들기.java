import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] cArr = number.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        
        stack.addLast(cArr[0]);
        for(int i = 1; i < cArr.length; i++) {
            while(!stack.isEmpty() && k > 0 && stack.peekLast() < cArr[i]) {
                stack.pollLast();
                k--;
            }
            stack.addLast(cArr[i]);
        }
    
        while(k > 0) {
            stack.pollLast();
            k--;
        }
        
       StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        answer = sb.toString();
        return answer;
    }
}