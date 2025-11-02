class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int[][] time = new int[timelogs.length][7];
        
        for(int i = 0; i < schedules.length; i++)
            if(schedules[i] % 100 >= 50)
                schedules[i] += 50;
            else 
                schedules[i] += 10;
        
        for(int i = 0; i < timelogs.length; i++)
            for(int j = 0; j < 7; j++)
                time[i][(startday + j - 1) % 7] = timelogs[i][j];
        
        for(int i = 0; i < time.length; i++) {
            boolean flag = true;
            int idx = 0;
            
            while(idx < 5){
                if(time[i][idx++] > schedules[i]){
                    flag = false;
                    break;
                }
            }
            
            if(flag == true)
                answer++;
        }
        
        return answer;
    }
}