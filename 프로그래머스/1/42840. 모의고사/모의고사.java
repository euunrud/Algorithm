class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] sc = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if(p1[i % p1.length] == answers[i])
                sc[0]++;
            if(p2[i % p2.length] == answers[i])
                sc[1]++;
            if(p3[i % p3.length] == answers[i])
                sc[2]++;
        }
        
        int max = Math.max(sc[0], Math.max(sc[1], sc[2]));
        int cnt = 0;
        for (int s : sc) 
            if (s == max) cnt++;

        answer = new int[cnt];
        cnt = 0;
        for (int i = 0; i < 3; i++)
            if (sc[i] == max)
                answer[cnt++] = i + 1;
        
        return answer;
    }
}