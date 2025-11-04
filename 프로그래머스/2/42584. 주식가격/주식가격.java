import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i < prices.length; i++) {
            int[] arr = new int[2];
            arr[0] = i;
            arr[1] = prices[i];
            while(!stack.isEmpty() ) {
                int[] a = stack.peek();
                if(a[1] > prices[i])
                    answer[a[0]] = i - a[0];
                else
                    break;
                stack.pop();
            }
            stack.push(arr);
        }
        
        while(!stack.isEmpty()) {
            int[] a = stack.pop();
            answer[a[0]] = prices.length - 1 - a[0];
        }
        return answer;
    }
}