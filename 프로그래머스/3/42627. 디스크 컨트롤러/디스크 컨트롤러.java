import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> {
            if(a[2] == b[2]) {
                if(a[1] == b[1])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        
        int len = jobs.length;
        int idx = 0;
        int time = 0;
        int avg = 0;
        while(idx < len || !pq.isEmpty()) {
            while(idx < len && jobs[idx][0] <= time)
                pq.offer(new int[]{idx, jobs[idx][0], jobs[idx++][1]});
            if(pq.isEmpty()) {
                time++;
                continue;
            }
            
            int[] job = pq.poll();
            time += job[2];
            avg += time - job[1];
        }
        
        return avg / len;
    }
}