class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] arr = dartResult.toCharArray();
        int idx = arr.length - 1;
        int sCnt = 0;
        int cCnt = 0;
        
        while(idx >= 0) {
            if(arr[idx] != '*' && arr[idx] != '#') {
                int num = 0;
                if(arr[idx - 1] != '0')
                    num = arr[idx - 1] - '0';
                else if(idx - 2 >= 0 && arr[idx - 2] == '1')
                    num = 10;
                
                if(arr[idx] == 'D')
                    num = num * num;
                else if(arr[idx] == 'T')
                    num = num * num * num;
                
                if(num != 0 && num % 10 == 0)
                    idx--;
                idx -= 2;
                
                for(int i = 0; i < sCnt; i += 2)
                    num *= 2;
                if(cCnt > 0){
                    cCnt--;
                    num *= -1;
                }
                
                if(sCnt > 0)
                    sCnt--;
                answer += num;
            } else {
                if(arr[idx] == '*')
                    sCnt+= 2;
                else if(arr[idx] == '#')
                    cCnt++;
                idx--;
            }
        }
        return answer;
    }
}