import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = -1;
        boolean flag = true;
        while(flag) {
            Arrays.sort(wallet);
            Arrays.sort(bill);
            
            if(wallet[1] < bill[1] || wallet[0] < bill[0]) 
                bill[1] /= 2;
            else
                flag = false;
            answer++;
        }
        return answer;
    }
}