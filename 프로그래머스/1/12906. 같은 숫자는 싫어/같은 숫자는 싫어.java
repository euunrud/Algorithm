import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        
        st.push(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(st.peek() != arr[i])
                st.push(arr[i]);
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println(st);

        return st;
    }
}